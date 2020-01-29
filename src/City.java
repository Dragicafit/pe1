import java.util.HashMap;
import java.util.Map;

public class City {
	public String name;
	public int typeA;
	public int typeB;
	public int typeC;
	public Map<City, Integer> neighbours;
	public boolean visited = false;
	public FileReader data;
	
	public City(String name, int typeA, int typeB, int typeC) {
		this.name = name;
		this.typeA = typeA;
		this.typeB = typeB;
		this.typeC = typeC;
		neighbours = new HashMap<City, Integer>();
	}
	
	public void addEdge(City name, int weight) {
		neighbours.put(name, weight);
	}
}