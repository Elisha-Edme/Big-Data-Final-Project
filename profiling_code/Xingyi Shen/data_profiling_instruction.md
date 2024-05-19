# MR Job 1: Data Profiling

## Files
   - `UniqueRecs.java`
   - `UniqueRecsMapper.java`
   - `UniqueRecsReducer.java`
   - jar build is included

## Description
   - This MapReduce job lists the unique values of at least 3 columns in a dataset.
   - Run it on the original dataset, before cleaning, and output the number of records (add a column with the count of the number of records).
   - Run it again on the cleaned dataset (result of MR Job 2 described below), and make your results visible in a screenshot.

## **Usage**
   - To use this MR job, follow these steps:
     1. Ensure you have Apache Hadoop installed and configured.
     2. Compile the provided Java code (`UniqueRecs.java`, `UniqueRecsMapper.java`, `UniqueRecsReducer.java`) to generate the JAR file.
     3. Run the MR job using the following command:
        ```
        hadoop jar YourJarFileName.jar UniqueRecs /path/to/input /path/to/output
        ```
     4. Replace `/path/to/input` with the path to your original dataset and `/path/to/output` with the desired output directory.
     5. After the job completes, review the output to see the unique values of the specified columns in the dataset.

## Screenshot
   - Link: [Screenshots File](../../screenshots/Xingyi%20Shen/data_profiling_output/)
