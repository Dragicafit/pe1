import java.io.FileOutputStream;
import java.io.IOException;

public class Output {
	public static void output(Cache[] cache, String file) throws IOException {
		int id = 0;
		FileOutputStream f = new FileOutputStream(file);
		f.write((used_cache(cache) + "\n").getBytes());
		for (Cache c : cache) {
			if (c.size > 0) {
				f.write((id + "").getBytes());
				for (Video v : c.videos) {
					f.write((" " + v.numero).getBytes());
				}
				f.write(("\n").getBytes());
			}
			id++;
		}
		f.close();
	}

	public static int used_cache(Cache[] cache) {
		int count = 0;
		for (Cache c : cache) {
			if (c.size > 0) {
				count++;
			}
		}
		return count;
	}
}
