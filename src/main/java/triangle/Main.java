package triangle;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Main extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ToolRunner.run(new Main(), args);
	}
	public int run(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Job myjob = Job.getInstance(getConf());
		myjob.setJarByClass(Main.class);
		myjob.setMapperClass(TriangleMapper_1.class);
		myjob.setReducerClass(TriangleReducer_1.class);
		myjob.setMapOutputKeyClass(Text.class);
		myjob.setMapOutputValueClass(Text.class);
		myjob.setOutputFormatClass(TextOutputFormat.class);
		myjob.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(myjob, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(myjob, new Path(arg0[0]).suffix(".first"));
		

		Job secondjob = Job.getInstance(getConf());
		secondjob.setJarByClass(Main.class);
		secondjob.setMapperClass(TriangleMapper_2.class);
		secondjob.setReducerClass(TriangleReducer_2.class);
		secondjob.setMapOutputKeyClass(Text.class);
		secondjob.setMapOutputValueClass(Text.class);
		secondjob.setOutputFormatClass(TextOutputFormat.class);
		secondjob.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(secondjob, new Path(arg0[0]).suffix(".first/part-r-00000"));
		FileOutputFormat.setOutputPath(secondjob, new Path(arg0[0]).suffix(".second"));
		
		myjob.waitForCompletion(true);
			secondjob.waitForCompletion(true);
		return 0;
	}
}
