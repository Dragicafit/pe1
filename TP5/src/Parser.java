import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	
	public static Network parse(String filepath) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int nbV = sc.nextInt();
		int nbEp = sc.nextInt();
		int nbR = sc.nextInt();
		int nbC = sc.nextInt();
		int cacheSize = sc.nextInt();
		
		Network network = new Network();
		
		// Videos
		
		for(int i = 0; i < nbC; i++) {
			network.caches[i] = new Cache();
			network.caches[i].max_size = cacheSize;
		}
		
		for(int i = 0; i < nbV; i++) {
			network.center.videos[i] = new Video();
			network.center.videos[i].numero = i;
			network.center.videos[i].poids = sc.nextInt();
		}
		
		for(int i = 0 ; i < nbEp; i++) {
			int latency = sc.nextInt();
			int epCache = sc.nextInt();
			
			network.endPoints[i] = new EndPoint();
			network.center.liaisons[i] = new Liaison();
			network.center.liaisons[i].endpoint = network.endPoints[i];
			network.center.liaisons[i].center = network.center;
			network.center.liaisons[i].latence = latency;
			
			for(int j = 0; j < epCache; j++) {
				int cache = sc.nextInt();
				network.caches[cache].liaisons[j].endpoint = network.endPoints[i];
				network.caches[cache].liaisons[j].latence = sc.nextInt();
				network.caches[cache].liaisons[j].center = network.caches[cache];
			}
		}
		
		for(int i = 0; i < nbR; i++) {
			int video = sc.nextInt();
			network.endPoints[sc.nextInt()].requests[video].nbDemandes = sc.nextInt();
		}
		return network;
	}
}
