import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("kittens.in");
		Commun(n);
		Output.output(n.caches, "kittens.out");
	}
	public static void Commun(Network n) {
		for(Cache c : n.caches) {
			HashMap<Video, Integer> liste= new HashMap<>();
			ArrayList<Request> l = new ArrayList<Request>();
			for(Liaison li: c.liaisons) {
				for(Request r : li.endpoint.requests) {
					if(liste.containsKey(r.video)) {
						liste.put(r.video, r.nbDemandes+(liste.get(r.video)));
					}else {
						liste.put(r.video, r.nbDemandes);
					}
				}
			}
			for(Map.Entry<Video, Integer> elem : liste.entrySet()) {
				if(elem.getKey().poids + c.size <= c.max_size) {
					c.videos.add(elem.getKey());
					c.size += elem.getKey().poids;
				}
			}
		}
	}
	
}
