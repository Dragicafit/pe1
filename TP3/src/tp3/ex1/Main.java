package tp3.ex1;

public class Main {
	public static void main(String[] args) {
		Parser p = new Parser("Testfiles/Test1.txt");
		p.parse();
		Algorithm a = new Algorithm(p.data.listOfCows);
	}
}
