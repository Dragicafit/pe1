import java.util.ArrayList;

public class Bus {
	public Type type;
	public ArrayList<City> cities;
	
	public Bus(Type type) {
		this.type = type;
		this.cities = new ArrayList<City>();
	}

	public Type getType() {
		return type;
	}

	public ArrayList<City> getCities() {
		return cities;
	}
	
	public void addCity(City city) {
		this.cities.add(city);
	}
}
