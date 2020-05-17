package triangle;
import org.apache.hadoop.util.ToolRunner;

public class TriangleTest {

	public static void main(String[] not_used) throws Exception {
		// TODO Auto-generated method stub
		String[] args = {"src/test/resources/graph.txt"};
		
		ToolRunner.run(new Main(), args);
	}

}
