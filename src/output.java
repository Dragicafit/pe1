
import java.io.*;
import java.util.ArrayList;

public class output {

	public ArrayList<Bus> liste;
	static FileOutputStream f;

	public output(ArrayList<Bus> l) {
		liste = l;
	}

	public void write() throws IOException {
		f = new FileOutputStream("test.txt");
		for (Bus elt : liste) {
			f.write(("###\n").getBytes());
			f.write((elt.getType().toString() + "\n").getBytes());
			for (City c : elt.getCities()) {
				f.write((c.name+"\n").getBytes());
			}
		}
		f.flush();
		f.close();
	}
}
