

import java.io.*;
import java.util.ArrayList;

public class output {

	public ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();
	FileOutputStream f;
	
	public output() {
		liste = null;
	}
	public void write() throws IOException {

		for (ArrayList<String> elt : liste) {
			f.write(("###").getBytes());
			for (String s : elt) {
				f.write((s + "\n").getBytes());
			}
		}
		f.flush();
		f.close();
	}
}
