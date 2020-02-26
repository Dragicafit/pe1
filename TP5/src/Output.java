import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Output {
	static FileOutputStream f;
	public void output(ArrayList<Cache> cache)throws IOException {
		int id = 0;
		f = new FileOutputStream("test.txt");
		f.write((used_cache(cache)+"\n").getBytes());
		for (Cache c : cache) {
			if(c.size > 0){
				f.write(id);
				for (Map.Entry<Integer, Integer> v : c.videos.entrySet()) {
					f.write((" "+v.getKey()).getBytes());
				}
				f.write(("\n").getBytes());
			}
			id++;
		}
	}
	

	public int used_cache(ArrayList<Cache>cache) {
		int count = 0;
		for (Cache c : cache) {
			if(c.size > 0) {
				count++;
			}
		}
		return count;
	}
}
