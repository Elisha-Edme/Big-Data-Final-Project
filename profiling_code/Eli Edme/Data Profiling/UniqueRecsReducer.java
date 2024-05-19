import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class UniqueRecsReducer extends Reducer<Text, Text,Text,Text> {

    public void reduce(Text key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int[] sum = {0, 0, 0};
      for (Text val : values) {
        if (val.toString().equals("3")) {
          sum[0]++;
        }
        else if (val.toString().equals("4")) {
          sum[1]++;
        }
        else  {
          sum[2]++;
        }
      }
      if (sum[0] == 1)
      {
        context.write(key, new Text("is unique in column 3"));
      }
      if (sum[1] == 1)
      {
        context.write(key, new Text("is unique in column 4"));
      }
      if (sum[2] == 1)
      {
        context.write(key, new Text("is unique in column 9"));
      }
    }
}