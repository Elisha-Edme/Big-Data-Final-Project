import java.io.IOException;
import java.util.StringTokenizer;

import javax.naming.Context;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public  class UniqueRecsMapper extends Mapper<Object, Text, Text, Text >{
public static final Text nine = new Text("9");
public static final Text four = new Text("4");
public static final Text three = new Text("3");
public void map(Object key, Text value, Context context
             ) throws IOException, InterruptedException {
    String[] columns = value.toString().split(",");
    Text val1 = new Text(columns[9]);
    Text val2 = new Text(columns[4]);
    Text val3 = new Text(columns[3]);
    context.write(val1, nine);
    context.write(val2, four);
    context.write(val3, three);
}
}
