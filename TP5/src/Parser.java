import java.io.File;
import java.util.Scanner;

public class Parser {
	DataCenter data;
	String filepath;
	
	public Parser(String filepath) {
		data = new DataCenter();
		this.filepath = filepath;
	}
	
	public void parse() {
		Scanner sc = new Scanner(new File(filepath));
		int[] size = new int[5];
	}
}
