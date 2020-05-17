package triangle;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TriangleMapper_2 extends Mapper<Object,Text,Text,Text>{
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String[] keyvalue = value.toString().split("\t");
		String[] keys = keyvalue[0].strip().split(" ");
		
		if(keys.length > 1) {
			Arrays.sort(keys);
			context.write(new Text(keys[0] + " " + keys[1]), new Text(keyvalue[1]));
		}
		else if(keys.length == 1) {
			keys = keyvalue[1].strip().split(" ");
			Arrays.sort(keys);
			context.write(new Text(keys[0] + " " + keys[1]), new Text(keyvalue[1]));
		}
	}
}
