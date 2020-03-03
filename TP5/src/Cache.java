import java.util.ArrayList;

public class Cache extends DataCenter {
	public ArrayList<Video> videos;
	public Liaison[] liaisons;
	public int max_size;
	public int size;

	public Cache() {
		this.videos = new ArrayList<Video>();
	}
	
	public boolean isInVideo(Video v) {
		for (Video video : videos) {
			if (v.numero == video.numero) return true;
		}
		return false;
	}
}
