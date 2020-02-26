import java.util.ArrayList;

public class Network {
	public DataCenter center;
	public ArrayList<Cache> caches;
	public ArrayList<EndPoint> endPoints;
	
	public Network() {
		center = new DataCenter();
		caches = new ArrayList<Cache>();
		endPoints = new ArrayList<EndPoint>();
	}
}
