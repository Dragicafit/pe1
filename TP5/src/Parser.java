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
			network.caches.add(new Cache());
			network.caches.get(i).max_size = cacheSize;
		}
		
		for(int i = 0; i < nbV; i++) {
			network.center.videos.put(i, sc.nextInt());
		}
		
		for(int i = 0 ; i < nbEp; i++) {
			int latency = sc.nextInt();
			int epCache = sc.nextInt();
			
			network.endPoints.add(new EndPoint());
			network.center.endpoints.put(network.endPoints.get(i), latency);
			
			for(int j = 0; j < epCache; j++) {
				Cache c = network.caches.get(sc.nextInt());
				c.endpoint.put(network.endPoints.get(i), sc.nextInt());
			}
		}
		
		for(int i = 0; i < nbR; i++) {
			int video = sc.nextInt();
			EndPoint ep = network.endPoints.get(sc.nextInt());
			ep.request.put(video, sc.nextInt());
		}
		return network;
	}
}
