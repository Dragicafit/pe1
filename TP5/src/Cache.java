import java.util.ArrayList;

public class Cache extends Center {
	public ArrayList<Video> videos;
	public ArrayList<Liaison> liaisons;
	public int max_size;
	public int size;
	
	public Cache() {
		this.videos = new ArrayList<Video>();
		this.liaisons = new ArrayList<Liaison>();
	}
}
