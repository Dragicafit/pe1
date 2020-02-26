import java.util.HashMap;
import java.util.Map;

public class Cache {
	public int max_size;
	public int size;
	public Map<Integer, Integer> videos;
	public Map<EndPoint, Integer> endpoint;
	
	public Cache() {
		videos = new HashMap<Integer, Integer>();
		endpoint = new HashMap<EndPoint, Integer>();
	}
}
