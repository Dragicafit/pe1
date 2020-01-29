

import java.util.ArrayList;
import java.util.Map;

public class Graph {
	private ArrayList<City> cities;
	private ArrayList<Bus> buses;
	
	public Graph(ArrayList<City> cities, ArrayList<Bus> buses) {
		this.cities = cities;
		this.buses = buses;
	}
	
	public void parcours() {
		City city = cities.get(0);
		for (Bus bus : buses) {
			City old = null;
			while (old != city) {
				city.visited = true;
				bus.cities.add(city);
				old = city;
				for (Map.Entry<City,Integer> entry : city.neighbours.entrySet()) {
					if (!entry.getKey().visited && city.types.get(bus.type) <= entry.getValue()) {
						city = entry.getKey();
						break;
					}
				}
			}
		}
	}
}
