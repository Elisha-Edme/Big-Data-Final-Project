// FirstCode.scala

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

object BirdAnalysis {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("Biodiversity Data Analysis")
      .getOrCreate()

    // read CSV file
    val data = spark.read.option("header", "true").csv("hdfs://nyu-dataproc-m/user/xs2038_nyu_edu/project_data/Biodiversity_of_Birds_-_Distribution_by_County_20240305.csv")


    // Data cleaning operations:
    // 1. Date formatting: Replace "-" with " to " in "Year Last Documented" for readability.
    // 2. Text formatting: Convert "Common Name" to lower case for normalization.
    val cleanedData = data
      .withColumn("Year Last Documented", regexp_replace(col("Year Last Documented"), "-", " to "))
      .withColumn("Common Name", lower(col("Common Name"))) 

    cleanedData.write
      .option("header", "true")
      .csv("hdfs://nyu-dataproc-m/user/xs2038_nyu_edu/Hw7/cleanedData")

    cleanedData.show(5)

    //Create a binary column "Is Protected in NY"
    //based on the condition of another column "NY Listing Status".
    val withBinaryColumn = cleanedData
      .withColumn("Is Protected in NY", when(col("NY Listing Status") === "Protected Bird", 1).otherwise(0))

    withBinaryColumn.write
      .option("header", "true")
      .csv("hdfs://nyu-dataproc-m/user/xs2038_nyu_edu/Hw7/withBinaryColumn")

    withBinaryColumn.show(5)

    //Assess of Hw7 is provided to adm209_nyu_edu, as18774_nyu_edu and as18464_nyu_edu

    // Calculate the bird count by county and perform statistical analysis:
    // Mean, median, and mode of the "Number of Bird Species" and standard deviation.
    val birdCountByCounty = withBinaryColumn.groupBy("County")
      .agg(countDistinct("Scientific Name").alias("Number of Bird Species"))

    // mean
    birdCountByCounty.agg(
      mean("Number of Bird Species").alias("Mean"),
      stddev("Number of Bird Species").alias("Standard Deviation")
    ).show()

    // median
    val median = birdCountByCounty.stat.approxQuantile("Number of Bird Species", Array(0.5), 0.01)(0)
    println(s"Median number of bird species: $median")

    // mode
    val mode = birdCountByCounty.groupBy("Number of Bird Species")
      .count()
      .orderBy(desc("count"))
      .first()
      .getAs[Long]("Number of Bird Species")
    println(s"Mode number of bird species: $mode")

    spark.stop()
  }
}
