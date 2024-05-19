# Create Birdwatching Database

## Overview
This document explains the Hive SQL script `create_birdwatching_db.sql`, which is used to set up the initial database and table structure for the Birdwatching project.

## Script Functionality
- **Database Creation**: The script checks if a database named `birdwatching` exists. If not, it creates this new database. This ensures that all related data is organized under a specific namespace in Hive.

- **Table Creation**: Within the `birdwatching` database, the script creates a table named `bird_distribution`. This table is designed to store detailed information about bird sightings and related data across various counties. The structure includes fields like `County`, `Category`, and `Scientific Name`, among others.

## Table Schema
- `County`: Name of the county where the birds are observed.
- `Category`: General category of the observation (e.g., Animal, Bird).
- `Taxonomic Group`: The broader taxonomic classification of the bird.
- `Taxonomic Subgroup`: More specific subgroup classification.
- `Scientific Name`: The scientific name of the bird species.
- `Common Name`: Common name of the bird as known generally.
- `Year Last Documented`: The last year in which the bird was documented in the area.
- `NY Listing Status`: Conservation status as per New York state listings.
- `Federal Listing Status`: Federal conservation status if applicable.
- `State Conservation Rank`: The conservation rank at the state level.
- `Global Conservation Rank`: The conservation rank at the global level.
- `Distribution Status`: Current status of the bird's distribution in the area.

## Usage
- This script should be run using the Hive command line interface or through a Hive client connected to the Hive server.
- It sets the foundation for data ingestion where data related to bird sightings will be loaded into this table.

## File Location
- **Path**: [`/create_birdwatching_db.sql`](create_birdwatching_db.sql)
