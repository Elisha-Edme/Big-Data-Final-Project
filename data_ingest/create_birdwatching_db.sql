CREATE DATABASE IF NOT EXISTS birdwatching;

USE birdwatching;

CREATE TABLE IF NOT EXISTS bird_distribution (
  County STRING,
  Category STRING,
  `Taxonomic Group` STRING,
  `Taxonomic Subgroup` STRING,
  `Scientific Name` STRING,
  `Common Name` STRING,
  `Year Last Documented` STRING,
  `NY Listing Status` STRING,
  `Federal Listing Status` STRING,
  `State Conservation Rank` STRING,
  `Global Conservation Rank` STRING,
  `Distribution Status` STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;