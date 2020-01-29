

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
		for (Bus bus : buses) {
			int i = 0;
			while (city.visited) {
				city = cities.get(i);
				i++;
			}
			for (City city2 : this.cities) {
				if (!city2.visited && city2.types.get(bus.type) > city.types.get(bus.type)) {
					city = city2;
				}
			}
			int gazole = city.types.get(bus.type);
			City old = null;
			while (old != city) {
				city.visited = true;
				bus.cities.add(city);
				old = city;
				for (Map.Entry<City,Integer> entry : city.neighbours.entrySet()) {
					if (!entry.getKey().visited && gazole >= entry.getValue()) {
						gazole -= entry.getValue();
						city = entry.getKey();
						break;
					}
				}
			}
		}
	}
}
