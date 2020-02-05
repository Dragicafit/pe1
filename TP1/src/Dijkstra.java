import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	static int nbSommet = 0;
	static String cible = "";
	
	public static void main(String[] args) {
		System.out.println(dijkstra(getFileContent(args[0])));
	}

	public static Graph getFileContent(String fileName) {
		Graph graph = new Graph();
		try {
			InputStream flux = new FileInputStream(fileName);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne = buff.readLine()) != null) {
				String[] info = ligne.split(" ");
				graph.addNoeud(info[0], info[1], Integer.parseInt(info[2]));
			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return graph;
	}
	
	public static String dijkstra(Graph graph) {
		ArrayList<Noeud> visitedNodes = new ArrayList<Noeud>();
		int dist[] = new int[nbSommet];
		dist[0] = 0;
		for (int i = 1; i < nbSommet; i++) 
			dist[i] = Integer.MAX_VALUE;
		String previousNode[] = new String[nbSommet];
		previousNode[0] = "";
		Noeud current = graph.getNoeud("N0");
		while (visitedNodes.size() != nbSommet) {
			Noeud min = current.getMinDist();
			visitedNodes.add(current);
			for (Map.Entry<Noeud, Integer> entry : current.getChildren().entrySet()) {
				
			}
		}
		return "";
	}
}

class Noeud {
	private String name;
	private Map<Noeud, Integer> children;
	
	public Noeud(String name) {
		this.name = name;
		this.children = new HashMap<Noeud, Integer>();
	}
	
	public Noeud(String name, Noeud child, int dist) {
		this.name = name;
		this.children = new HashMap<Noeud, Integer>();
		this.children.put(child, dist);
	}

	public String getName() {
		return name;
	}

	public Map<Noeud, Integer> getChildren() {
		return children;
	}
	
	public void addChild(Noeud noeud, int dist) {
		children.put(noeud, dist);
	}
	
	public Noeud getMinDist() {
		Noeud plusProche = null;
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Noeud, Integer> entry : children.entrySet()) {
			if (entry.getValue() < min) {
				plusProche = entry.getKey();
				min = entry.getValue();
			}
		}
		return plusProche;
	}
}

class Graph {
	private ArrayList<Noeud> noeuds;
	
	public Graph() {
		noeuds = new ArrayList<Noeud>();
	}
	
	public void addNoeud(String name1, String name2, int dist) {
		for (Noeud n : noeuds)
			if (n.getName().equals(name1)) {
				n.addChild(new Noeud(name2), dist);
				return;
			}
		noeuds.add(new Noeud(name1, new Noeud(name2), dist));
	}
	
	public Noeud getNoeud(String name) {
		for (Noeud n : noeuds)
			if (n.getName().equals(name))
				return n;
		return null;
	}
}
