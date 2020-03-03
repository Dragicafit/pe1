import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("videos_worth_spreading.in");
		Commun(n);
		Output.output(n.caches, "videos_worth_spreading.out");
		System.out.println("fini");
	}

	public static void Commun(Network n) {
		for (Cache c : n.caches) {
			ArrayList<Request> l = new ArrayList<Request>();
			for (Liaison li: c.liaisons) {
				for (Request r : li.endpoint.requests) {
					if (l.isEmpty()) {
						l.add(r);
					} else if (l.contains(r)) {
						l.get(l.indexOf(r)).nbDemandes += r.nbDemandes;
					} else {
						boolean b = false;
						for (Request rq : l) {
							if (rq.nbDemandes > r.nbDemandes) {
								l.add(l.indexOf(rq), r);
								b = true;
								break;
							}
						}
						if (!b)
							l.add(r);
					}
				}
			}
			for (Request rq : l) {
				if (!c.videos.contains(rq.video) && rq.video.poids + c.size <= c.max_size) {
					c.videos.add(rq.video);
					c.size += rq.video.poids;
				}
			}
		}
	}

}
