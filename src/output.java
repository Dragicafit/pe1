

import java.io.*;
import java.util.ArrayList;

public class output {

	public static ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();
	static FileOutputStream f;
	
	public output() {
		liste = null;
	}
	public static void write() throws IOException {
		f = new FileOutputStream("test.txt");
		for (ArrayList<String> elt : liste) {
			f.write(("###\n").getBytes());
			for (String s : elt) {
				f.write((s + "\n").getBytes());
			}
		}
		f.flush();
		f.close();
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> A1 = new ArrayList<String>();
        ArrayList<String> B1 = new ArrayList<String>();
        ArrayList<String> A2 = new ArrayList<String>();
        A1.add("A");
        A1.add("NOUAINVILLE");
        A1.add("JAVRON-LES-CHAPPELES");
        A1.add("BERENTZWILLER");
        B1.add("b");
        B1.add("JONQQUERETTES");
        B1.add("MONTIGNY-LES-CONDE");
        B1.add("ROUVRES-SUR-AUBE");
        B1.add("BERRIAC");
        B1.add("AUBUSSON");
        B1.add("SAINTE-ADRESSE");
        B1.add("MONTCARRA");
        B1.add("SAINT-TRIVIER-SUR-MOIGNANS");
        A2.add("A");
        A2.add("VILLE-SOUS-ANJOU");
        liste.add(A1);
        liste.add(B1);
        liste.add(A2);
        write();
	}
}
