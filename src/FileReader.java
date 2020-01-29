import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
	public String filepath;
	public Map<String, City> cities;
	
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
	
	public Map<String, City> getCities() {
		Map<String, City> cities = new HashMap<String, City>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.next();
		sc.next();
		sc.next();
		sc.next();
		for(int i = 0; i < getNumberOfCities(); i++) {
			String cityName = sc.next();
			int typeA = Integer.parseInt(sc.next());
			int typeB = Integer.parseInt(sc.next());
			int typeC = Integer.parseInt(sc.next());
			System.out.println(cityName + " " + typeA + " " + typeB + " " + typeC);
			cities.put(cityName, new City(cityName, typeA, typeB, typeC));
		}
		this.cities = cities;
		return cities;
	}
	
	public void addEdges() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.next();
		sc.next();
		sc.next();
		sc.next();
		for(int i = 0; i <= getNumberOfCities(); i++) {
			sc.nextLine();
		}
		while(sc.hasNext()) {
			String cityName1 = sc.next();
			String cityName2 = sc.next();
			int weight = Integer.parseInt(sc.next());
			City city1 = cities.get(cityName1);
			City city2 = cities.get(cityName2);
			city1.addEdge(city2, weight);
			city2.addEdge(city1, weight);
			System.out.println(cityName1 + " " + cityName2 + " " + weight);
		}
	}
}