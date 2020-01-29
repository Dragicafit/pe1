
import java.io.*;
import java.util.ArrayList;

public class output {

	public static ArrayList<Bus> liste = new ArrayList<Bus>();
	static FileOutputStream f;

	public output() {
		liste = null;
	}

	public static void write() throws IOException {
		f = new FileOutputStream("test.txt");
		for (Bus elt : liste) {
			f.write(("###\n").getBytes());
			f.write((elt.getType().toString() + "\n").getBytes());
			for (City c : elt.getCities()) {
				f.write((c.getName()).getBytes());
			}
		}
		f.flush();
		f.close();
	}
}
