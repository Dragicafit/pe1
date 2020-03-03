import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("input.in");
		Output.output(n.caches, "test.out");
	}
	
	public static void Commun(Network n) {
		for(Cache c : n.caches) {
			HashMap<Video, Integer> liste= new HashMap<>();
			for(Liaison li: c.liaisons) {
				for(Request r : li.endpoint.requests) {
					if(liste.containsKey(r.video)) {
						liste.put(r.video, r.nbDemandes+(liste.get(r.video)));
					}else {
						liste.put(r.video, r.nbDemandes);
					}
				}
			}
			remplissage(c,liste);
		}
	}
	
	public static void remplissage(Cache c,HashMap<Video,Integer>liste) {
		int i =0;
		for(Map.Entry<Video, Integer> elem : liste.entrySet()) {
			if(elem.getKey().poids + c.size < c.max_size) {
				c.videos[i] = elem.getKey();
				i++;
			}
		}
	}
}
