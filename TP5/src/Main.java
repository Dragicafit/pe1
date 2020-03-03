import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("videos_worth_spreading.in");
		testSortRequests(n);
		Output.output(n.caches, "videos_worth_spreading.out");
	}

	public static void remplissage(Network n) {
		for (EndPoint e : n.endPoints) {
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
		for (EndPoint e : n.endPoints)
			quickSort(e.requests, 0, e.requests.length - 1);
		for (EndPoint e : n.endPoints) {
			for (Request r : e.requests) {
				for (Cache c : n.caches) {
					int minLatence = 0;
					for (int i = 1; i < c.liaisons.length; i++) {
						if ()
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
