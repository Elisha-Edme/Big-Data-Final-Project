import java.io.IOException;

import javax.naming.Context;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UniqueRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final IntWritable one = new IntWritable(1);
    private boolean isFirstLine = true;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Jump 1 st line
        if (isFirstLine) {
            isFirstLine = false;
            return;
        }

        String line = value.toString();

        String[] parts = line.split(",");

        // 5 - cleaned, 12 - original
        if (parts.length == 5 || parts.length == 12) {
            // MR job lists the unique value of at least 3 columns in a dataset.

            String county = parts[0].trim();
            String taxonomicSubgroup = parts[parts.length > 5 ? 3 : 1].trim();
            String scientificName = parts[parts.length > 5 ? 4 : 2].trim();
            String commonName = parts[parts.length > 5 ? 5 : 3].trim();
            String nyListingStatus = parts[parts.length > 5 ? 7 : 4].trim();

            context.write(new Text("County: " + county), one);
            context.write(new Text("Taxonomic Subgroup: " + taxonomicSubgroup), one);
            context.write(new Text("Scientific Name: " + scientificName), one);
            context.write(new Text("Common Name: " + commonName), one);
            context.write(new Text("NY Listing Status: " + nyListingStatus), one);

        }
    }
}
