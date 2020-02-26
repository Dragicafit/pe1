import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Output {
	public static void output(ArrayList<Cache> cache, String file)throws IOException {
		int id = 0;
		FileOutputStream f = new FileOutputStream(file);
		f.write((used_cache(cache)+"\n").getBytes());
		for (Cache c : cache) {
			if(c.size > 0){
				f.write((id+"").getBytes());
				for (Map.Entry<Integer, Integer> v : c.videos.entrySet()) {
					f.write((" "+v.getKey()).getBytes());
				}
				f.write(("\n").getBytes());
			}
			id++;
		}
	}
	

	public static int used_cache(ArrayList<Cache>cache) {
		int count = 0;
		for (Cache c : cache) {
			if(c.size > 0) {
				count++;
			}
		}
		return count;
	}
}
