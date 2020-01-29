

import java.util.ArrayList;
import java.util.Map;

public class Graph {
	public ArrayList<City> cities;
	public ArrayList<Bus> buses;
	
	public Graph(ArrayList<City> cities, ArrayList<Bus> buses) {
		this.cities = cities;
		this.buses = buses;
	}
	
	public void parcours() {
		City city = cities.get(0);
		City old = null;
		for (Bus bus : buses) {
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
