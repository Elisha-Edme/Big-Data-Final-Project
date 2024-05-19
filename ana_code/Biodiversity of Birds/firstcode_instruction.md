## Instructions

This Scala script performs analysis on biodiversity data of birds.
It reads a CSV file containing information about bird distribution by county,
cleans the data, and performs statistical analysis.

1. **Data Cleaning**:
   - The script formats the "Year Last Documented" column for readability by replacing "-" with " to ".
   - It converts the "Common Name" column to lowercase for normalization.
   - Create a binary column based on "Is Protected in NY."

2. **Output**:
   - The cleaned data is written to HDFS directory "Hw7/cleanedData".
   - A binary column "Is Protected in NY" is created based on the condition of the "NY Listing Status" column.
   - The data with the binary column is written to HDFS directory "Hw7/withBinaryColumn".

3. **Statistical Analysis**:
   - The script calculates the bird count by county and performs the following statistical analysis:
     - Mean and standard deviation of the number of bird species.
     - Median and mode of the number of bird species.

4. **Permissions**:
   - Assessment of Hw7 is provided to adm209_nyu_edu, as18774_nyu_edu, and as18464_nyu_edu.

5. **How to use**:
   - To use or run this Scala code, ensure you have the following prerequisites:
     - Apache Spark installed and configured with Hadoop.
     - The data file `Biodiversity_of_Birds_-_Distribution_by_County_20240305.csv` available in HDFS. For this code, it reads hdfs://nyu-dataproc-m/user/xs2038_nyu_edu/project_data/Biodiversity_of_Birds_-_Distribution_by_County_20240305.csv automatically if with permissions.
   - Follow these steps to execute the code:
     1. Save the provided code to a file named `FirstCode.scala`.
     2. Open a terminal and navigate to the directory containing `FirstCode.scala`.
     3. Run the following command to submit the Spark application and execute the code:
        ```
        spark-submit --class BirdAnalysis --master <master-url> FirstCode.scala
        ```
        Replace `<master-url>` with the URL of your Spark master node, for example, `spark://host:port`.
     4. Wait for the task to complete. Once finished, you can view the statistical results in the console output.

   6. **Screenshot**:
   - Link: [Screenshots File](../../screenshots/Xingyi%20Shen/first_code_drop/)
