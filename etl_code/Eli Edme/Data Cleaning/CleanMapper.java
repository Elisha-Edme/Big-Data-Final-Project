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

public  class CleanMapper extends Mapper<Object, Text, Text, Text >{

public void map(Object key, Text value, Context context
             ) throws IOException, InterruptedException {
    String[] columns = value.toString().split(",");
    String acc = new String(); int count_empty = 0;
    for (int i = 0; i < columns.length; i++)
    {
        if (i != 5 ) {
            acc += columns[i] + ((i == columns.length - 1) ? "" : ",");
        }
        if (columns[i].equals(""))
        {
            count_empty++;
        }
    }
    if (count_empty < 1)
    {
        Text ans = new Text(acc);
        context.write(ans, new Text("1"));
    }
}
}
