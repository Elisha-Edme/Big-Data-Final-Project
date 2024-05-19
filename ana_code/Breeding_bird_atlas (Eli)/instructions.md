## Instructions

This Scala script performs analysis on the breeding bird atlas dataset.
It reads a CSV file containing information about bird distribution by county,
cleans the data, and performs statistical analysis.

1. **Data Cleaning**:
   - Merged the year, month, and day column into one new column (date)
   - Created a binary column that modeled a bird's "at risk" chance by using the protections status and breeding status
   - Dropped the map link column

2. **Output**:
   - The clean data is written to HDFS directory "hw7_output".

3. **Statistical Analysis**:
   - The script calculates the bird count by county and performs the following statistical analysis:
     - Mean, median, and standard deviation of the number of birds species per county.
     - Mode of the bird species (Most common bird in dataset).

4. **Permissions**:
   - Output of Hw7 is provided to adm209_nyu_edu, as18774_nyu_edu, and as18464_nyu_edu.
   - Completed using the share.sh file

5. **How to use**:
   - To use or run this Scala code, ensure you have the following prerequisites:
     - Apache Spark installed and configured with Hadoop.
     - The data file `input.csv` available in HDFS. This must be downloaded into the home directory
   - Follow these steps to execute the code:
     1. Save the provided code to a file named `FirstCode.scala`.
     2. Open a terminal and navigate to the directory containing `FirstCode.scala`.
     3. Run the following command to submit the Spark application and execute the code:
        ```
        spark-shell --deploy-mode client -i FirstCode.scala
        ```
     4. Wait for the task to complete. Once finished, you can view the statistical results in the console output.
   - Execute the `share.sh` file to share the output with the TAs/Professor

   6. **Screenshot**:
   - Link: [Screenshots File](../../screenshots/Eli%20Edme/first_code_drop/)