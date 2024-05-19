import scala.math.round
import org.apache.spark.sql.functions._

var originalCSV = spark.read.csv("input.csv").toDF("Fed. Region","Block ID","Map Link","County","Common Name","Scientific Name","NYS Protection Status","Family Name","Family Description","Breeding Behavior","Month","Day","Year","Breeding Status")

// Get rid of first row
originalCSV = originalCSV.except(originalCSV.limit(1))

// Cleaned dataset with date formatting and binary column

// Create a new column representing the formatted date
originalCSV = originalCSV.withColumn("Date",
  when(col("Month").isNotNull && col("Day").isNotNull,
    concat(col("Day"), lit("-"), col("Month"), lit("-"), col("Year"))
  ).otherwise(col("Year"))
).drop("Month", "Day", "Year", "Map Link")
// Dropped the old date column and the map Link column (Map column not helpful)

// Create a binary column for at risk
// At risk means that the bird's breeding status is possible but it is unprotected or marked as game
val cleanData = originalCSV.withColumn("At Risk",
  when((col("NYS Protection Status") === "Unprotected" || col("NYS Protection Status") === "Game Species") && col("Breeding Status") === "Possible", 1)
    .otherwise(0)
)

// Show the updated DataFrame
cleanData.show()

// Save the csv
cleanData.write.option("header", "true").csv("hdfs://nyu-dataproc-m/user/eae8374_nyu_edu/hw7_output")

// FIND MODE BIRD NAME

// Group by the "Common Name" column and count the occurrences of each bird name
val birdNameCountsDF = cleanData.groupBy("Common Name").agg(count("*").alias("BirdCount"))

// Sort the DataFrame by the count of occurrences in descending order
val mostCommonBirdDF = birdNameCountsDF.sort(desc("BirdCount"))

// Take the first row, which represents the most common bird name
val mostCommonBird = mostCommonBirdDF.select("Common Name").first.getString(0)

// Display the most common bird name
println(s"The most common bird name is: $mostCommonBird")

val countyCountsDF = cleanData.groupBy("County").agg(count("*").alias("BirdsCount"))

// FIND MEDIAN 

// Extract the counts into an array and sort it
val countsArray = countyCountsDF.select("BirdsCount").rdd.map(r => r.getLong(0)).collect().sorted

// Calculate the median number of birds per county
val medianBirdsPerCounty = if (countsArray.length % 2 == 0) {
  // If even, take the average of the two middle values
  val middleIndex = countsArray.length / 2
  round((countsArray(middleIndex - 1) + countsArray(middleIndex)) / 2.0)
} else {
  // If odd, take the middle value
  countsArray(countsArray.length / 2)
}

println(s"The median number of birds per county is: $medianBirdsPerCounty")

// FIND MEAN

// Find and show the average number of birds per county
val meanBirdsPerCounty = round(countyCountsDF.select(mean("BirdsCount")).first.getDouble(0))
println(s"The mean number of birds per county is: $meanBirdsPerCounty")

// FIND STD

// Find and show the standard deviation of the number of birds per county
val stdDev = countyCountsDF.select(stddev("BirdsCount")).first.getDouble(0)
println(s"The standard deviation of the number of birds per county is: $stdDev")