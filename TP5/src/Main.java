import java.io.IOException;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse(args[0]);
		remplissage(n);
		Output.output(n.caches, "test.txt");
	}
	
	public static void remplissage(Network n) {
		for (EndPoint e : n.endPoints) {
			for (Map.Entry<Integer, Integer> entry : e.request.entrySet()) {
				for (Cache c : n.caches) {
					Integer poids = n.center.videos.get(entry.getValue());
					if (poids < c.max_size - c.size) {
						c.videos.put(entry.getKey(), poids);
						c.size += poids;
						break;
					}
				}
			}
		}
	}
}
