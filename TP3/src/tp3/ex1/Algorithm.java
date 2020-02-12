package tp3.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithm {
	List<Cows> cows;
	
	public Algorithm(Cows[] listOfCows) {
		cows = new ArrayList<Cows>(Arrays.asList(listOfCows));
		Collections.sort(cows);
		int g = 0;
		for(Cows c : cows) {
			
		}
	}
}
