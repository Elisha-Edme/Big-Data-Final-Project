import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private boolean isFirstLine = true;

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        if (isFirstLine) {
            isFirstLine = false;
            return;
        }

        String line = value.toString().trim();
        if (line.isEmpty()) {
            return;
        }

        String[] parts = line.split(",", -1);

        if (parts.length >= 12 && !containsNull(parts)) {
            String county = parts[0].trim();
            String taxonomicSubgroup = parts[3].trim();
            String scientificName = parts[4].trim();
            String commonName = parts[5].trim();
            String nyListingStatus = parts[7].trim();
            String cleanLine = String.join(",", county, taxonomicSubgroup, scientificName, commonName, nyListingStatus);

            context.write(new Text(cleanLine), NullWritable.get());
        }
    }

    private boolean containsNull(String[] array) {
        for (String str : array) {
            if (str == null || str.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
