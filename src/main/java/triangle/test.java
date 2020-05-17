package triangle;

import java.util.Arrays;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "  hello gorgeous  ";
		//String a = "(h,e) 3 2";
		Pattern aaa = Pattern.compile("[(\\(\\))]");//("[\\(,\\) ]")
		System.out.println(Arrays.deepToString( a.replaceAll(aaa.toString(), "").replace(",", " ").split(" ")));
		Pattern p = Pattern.compile(" hello ");
		System.out.println(a.replaceAll("hello", "").strip());
		
		String b = "Fred Ethel	Lucy Fred Ethel Lucy";
		System.out.println(Arrays.deepToString(b.split("\t")[0].strip().split(" ")));
		System.out.println(b.split("\t")[0].strip().split(" ").length);
	}

}
