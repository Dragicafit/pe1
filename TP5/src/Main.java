import java.io.IOException;
import java.util.Map; 

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("input.in");
		remplissage(n);
		Output.output(n.caches, "test.out");
	}
	
	public static void remplissage(Network n) {
		for (EndPoint e : n.endPoints) {
			for (Request r : e.requests) {
				for (Cache c : n.caches) {
					Video v = r.video;
					if (v.poids < c.max_size - c.size) {
						c.videos[] = v;
						c.size += v.poids;
						break;
					}
				}
			}
		}
	}
}
