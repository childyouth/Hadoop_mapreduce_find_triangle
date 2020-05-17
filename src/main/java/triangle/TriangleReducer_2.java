package triangle;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TriangleReducer_2 extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> values = new ArrayList<String>();
		for(Text t : arg1) {
			values.add(t.toString());
		}
		
		if(values.size() == 2)
			arg2.write(new Text("Triangle"), new Text(values.get(0) + " " + values.get(1)));
	}

}
