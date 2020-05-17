package triangle;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TriangleMapper_1 extends Mapper<Object, Text, Text, Text>{
	
	Text a = new Text();
	Text b = new Text();
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//String[] v = value.toString().split("\n");
		//for(String record : v) {
		String record = value.toString();
			String[] tmp = record.replaceAll("[(\\(\\))]","").replace(",", " ").split(" ");
			int degree1 = Integer.parseInt(tmp[2]);
			int degree2 = Integer.parseInt(tmp[3]);
			
			if(degree1 == 1 || degree2 == 1) {
				//continue;
			}
			else {
			if(degree1 > degree2) {
				context.write(new Text(tmp[1]), new Text(tmp[0] + " " + tmp[1]));
			}
			else if(degree1 < degree2) {
				context.write(new Text(tmp[0]), new Text(tmp[0] + " " + tmp[1]));
			}
			else {
				String k;
				if(tmp[0].compareTo(tmp[1]) > 0) {
					k = tmp[1];
				}
				else {
					k = tmp[0];
				}
				context.write(new Text(k), new Text(tmp[0] + " " + tmp[1]));
			}
			}
		//}
	}
	
}
