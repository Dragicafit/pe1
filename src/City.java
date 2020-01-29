import java.util.HashMap;

public class City {
	public String name;
	public HashMap<Type, Integer> types;
	public HashMap<City, Integer> neighbours;
	public boolean visited = false;
	public FileReader data;
	
	public City(String name, int typeA, int typeB, int typeC) {
		this.name = name;
		this.types = new HashMap<Type, Integer>();
		this.types.put(Type.A, typeA);
		this.types.put(Type.B, typeB);
		this.types.put(Type.C, typeC);
		neighbours = new HashMap<City, Integer>();
	}
	
	public void addEdge(City name, int weight) {
		neighbours.put(name, weight);
	}
}