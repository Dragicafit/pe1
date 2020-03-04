import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("kittens.in.txt");
		test(n);
		Output.output(n.caches, "kittens.out");
	}

	public static void remplissage(Network n) {
		for (EndPoint e : n.endPoints) {
			for (Request r : e.requests) {
				for (Cache c : n.caches) {
					Video v = r.video;
					if (v.poids < c.max_size - c.size) {
						c.videos.add(v);
						c.size += v.poids;
						break;
					}
				}
			}
		}
	}
	
	public static void testSortRequests(Network n) {
		for (EndPoint e : n.endPoints) {
			quickSort(e.requests, 0, e.requests.length - 1);
			for (Request r : e.requests) {
				for (Cache c : n.caches) {
					Video v = r.video;
					if (v.poids < c.max_size - c.size && !c.videos.contains(v)) {
						c.videos.add(v);
						c.size += v.poids;
						break;
					}
				}
			}
		}
	}
	
	public static void test(Network n) {
		for (EndPoint e : n.endPoints) {
			quickSort(e.requests, 0, e.requests.length - 1);
			for (Request r : e.requests) {
				Cache cache = null;
				int liaison = 0;
				for (int j = 1; j < n.caches.length; j++) {
					for (int i = 1; i < n.caches[j].liaisons.length; i++) {
						if (n.caches[j].liaisons[i].endpoint.numero == e.numero && n.caches[j].size < n.caches[j].max_size) {
							if (cache == null) {
								cache = n.caches[j];
								liaison = i;
							} else if (cache.liaisons[liaison].latence > n.caches[j].liaisons[i].latence && n.center.liaisons[i].latence > n.caches[j].liaisons[i].latence) {
								cache = n.caches[j];
								liaison = i;
							}
						}
					}
				}
				Video v = r.video;
				if (cache != null) {
					if (v.poids < cache.max_size - cache.size && !cache.isInVideo(v)) {
						cache.videos.add(v);
						cache.size += v.poids;
					}
				}
			}
		}
	}
	
	public static void quickSort(Request[] requests, int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(requests, begin, end);
	 
	        quickSort(requests, begin, partitionIndex-1);
	        quickSort(requests, partitionIndex+1, end);
	    }
	}
	
	private static int partition(Request[] requests, int begin, int end) {
	    Request pivot = requests[end];
	    int i = begin-1;
	 
	    for (int j = begin; j < end; j++) {
	        if (requests[j].nbDemandes > pivot.nbDemandes) {
	            i++;
	 
	            Request tmp = requests[i];
	            requests[i] = requests[j];
	            requests[j] = tmp;
	        }
	    }
	 
	    Request tmp = requests[i+1];
	    requests[i+1] = requests[end];
	    requests[end] = tmp;
	 
	    return i+1;
	}
}
