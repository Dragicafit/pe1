package tp3.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	Data data;
	String path;
	
	public Parser(String path) {
		data = new Data();
		this.path = path;
	}
	
	public void parse() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		data.nbCows = Integer.parseInt(sc.next());
		data.listOfCows = new Cows[data.nbCows];
		for(int i = 0; i < data.nbCows; i++) {
			int gallons = Integer.parseInt(sc.next());
			int deadline = Integer.parseInt(sc.next());
			data.listOfCows[i]= new Cows(gallons, deadline);
		}
	}
}
