package triangle;

import java.io.IOException;
import java.util.*;

import org.apache.curator.shaded.com.google.common.collect.Lists;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TriangleReducer_1 extends Reducer <Text, Text, Text, Text>{
	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		for(Text v : arg1) {
			list.add(v.toString());
			arg2.write(arg0, v);
		}
		if(list.size() > 1) {
			for(int i = 0;i<list.size()-1;i++) {
				String node_a = list.get(i).toString()
						.replaceAll(arg0.toString(), "").strip();
				for(int j = i + 1; j<list.size();j++) {
					String node_b = list.get(j).toString()
							.replaceAll(arg0.toString(), "").strip();
					//arg2.write(new Text(list.get(i)), new Text(list.get(j)));
					arg2.write(new Text(node_a + " " + node_b), new Text(list.get(i).toString() + " " + list.get(j).toString()));
				}
			}
		}
	}
}
