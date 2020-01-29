import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	private String filepath;
	
	public FileReader(String filepath) {
		this.filepath = filepath;
	}
	
	public int getNumberOfCities() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(sc.next());
	}
	
	public int getATypeBus() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.next();
		return Integer.parseInt(sc.next());
	}
	
	public int getBTypeBus() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.next();
		sc.next();
		return Integer.parseInt(sc.next());
	}
	
	public int getCTypeBus() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.next();
		sc.next();
		sc.next();
		return Integer.parseInt(sc.next());
	}
	
	public List<City> getCities() {
		ArrayList<City> cities = new ArrayList<City>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}