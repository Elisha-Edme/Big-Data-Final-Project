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
- To use this MapReduce job, follow these steps:
    1. Ensure you have Apache Hadoop installed and configured.
    2. Upload the `add.sh`, `compile.sh`, and `delete.sh` files to your cluster
    3. Give them access using the `chmod +x add.sh compile.sh delete.sh` command
    4. Run the `./add.sh` command
    5. Run the `./compile.sh` command
    6. After the job completes, review the output to ensure the data has been cleaned according to your requirements.
    7. If you would like to delete the files, run the `delete.sh` command


## Screenshot
   - Link: [Screenshots File](../../screenshots/Eli%20Edme/data_profiling/)
