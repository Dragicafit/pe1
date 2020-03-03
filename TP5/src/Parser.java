import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		network.caches = new Cache[nbC];
		for (int i = 0; i < nbC; i++) {
			network.caches[i] = new Cache();
			network.caches[i].max_size = cacheSize;
		}
		network.center.videos = new Video[nbV];
		for (int i = 0; i < nbV; i++) {
			network.center.videos[i] = new Video();
			network.center.videos[i].numero = i;
			network.center.videos[i].poids = sc.nextInt();
		}
		network.endPoints = new EndPoint[nbEp];
		network.center.liaisons = new Liaison[nbEp];

		ArrayList<Liaison>[] liaisons = new ArrayList[nbC];
		for (int i = 0; i < nbC; i++) {
			liaisons[i] = new ArrayList<Liaison>();
		}
		for (int i = 0; i < nbEp; i++) {
			int latency = sc.nextInt();
			int epCache = sc.nextInt();

			network.endPoints[i] = new EndPoint();
			network.center.liaisons[i] = new Liaison();
			network.center.liaisons[i].endpoint = network.endPoints[i];
			network.center.liaisons[i].center = network.center;
			network.center.liaisons[i].latence = latency;

			for (int j = 0; j < epCache; j++) {
				int cache = sc.nextInt();
				Liaison liaison = new Liaison();
				liaison.endpoint = network.endPoints[i];
				liaison.latence = sc.nextInt();
				liaison.center = network.caches[cache];
				liaisons[cache].add(liaison);
			}
		}
		for (int i = 0; i < nbC; i++) {
			network.caches[i].liaisons = new Liaison[liaisons[i].size()];
			network.caches[i].liaisons = liaisons[i].toArray(network.caches[i].liaisons);
		}

		ArrayList<Request>[] requests = new ArrayList[nbEp];
		for (int i = 0; i < nbEp; i++) {
			requests[i] = new ArrayList<Request>();
		}
		for (int i = 0; i < nbR; i++) {
			int video = sc.nextInt();
			int endPoint = sc.nextInt();
			Request request = new Request();
			request.nbDemandes = sc.nextInt();
			request.video = network.center.videos[video];
			requests[endPoint].add(request);
		}
		for (int i = 0; i < nbEp; i++) {
			network.endPoints[i].numero = i;
			network.endPoints[i].requests = new Request[requests[i].size()];
			network.endPoints[i].requests = requests[i].toArray(network.endPoints[i].requests);
		}
		return network;
	}
}
