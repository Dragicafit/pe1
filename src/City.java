import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
	private String name;
	private int typeA;
	private int typeB;
	private int typeC;
	private Map<City, Integer> neighbours;
	private boolean visited = false;
	private FileReader data;
	
	public City(String name, int typeA, int typeB, int typeC) {
		this.name = name;
		this.typeA = typeA;
		this.typeB = typeB;
		this.typeC = typeC;
		neighbours = new HashMap<City, Integer>();
	}
}