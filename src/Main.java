import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		FileReader f = new FileReader("tests/newprobA.in");
		ArrayList<City> cities = new ArrayList<City>(f.getCities().values());
		System.out.println(cities);
		f.addEdges();
		ArrayList<Bus> bus = new ArrayList<>();
		for(int i = 0; i < f.getATypeBus(); i++) {
			bus.add(new Bus(Type.A));
		}
		for(int i = 0; i < f.getBTypeBus(); i++) {
			bus.add(new Bus(Type.B));
		}
		for(int i = 0; i < f.getCTypeBus(); i++) {
			bus.add(new Bus(Type.C));
		}
		Graph g = new Graph(cities, bus);
		g.parcours();
		System.out.println(g.buses.get(0).cities);
		output o = new output(g.buses);
		try {
			o.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
