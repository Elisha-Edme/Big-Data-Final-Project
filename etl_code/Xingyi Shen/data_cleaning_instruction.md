# MR Job 2: Data Cleaning

## Files
- `Clean.java`
- `CleanMapper.java`
- `CleanReducer.java`
- jar build is included


## Description
- This MapReduce job cleans the data to avoid nasty exceptions later on in your analytics.
- It should write out a new file/directory with only the columns you will use in your analytics.

## Usage
- To use this MapReduce job, follow these steps:
    1. Ensure you have Apache Hadoop installed and configured.
    2. Compile the provided Java files (`Clean.java`, `CleanMapper.java`, `CleanReducer.java`).
    3. Run the MR job using the compiled classes, specifying the input and output paths.
        ```
         hadoop jar YourJarFileName.jar Clean /path/to/input /path/to/output
         ```
        Replace `YourJarFileName.jar` with the name of your JAR file containing the compiled classes.
    4. After the job completes, review the output to ensure the data has been cleaned according to your requirements.
