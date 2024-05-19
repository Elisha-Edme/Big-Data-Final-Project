javac -classpath `yarn classpath` -d . UniqueRecsMapper.java
javac -classpath `yarn classpath` -d . UniqueRecsReducer.java
javac -classpath `yarn classpath`:. -d . UniqueRecs.java
jar -cvf uniqueRecs.jar *.class
hadoop jar uniqueRecs.jar UniqueRecs input.csv hw6_dir