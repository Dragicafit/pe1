
public class Somme {
	
	int s;	// Somme à atteindre
	int k;	// Pièces utilisés
	int[] pieces;	// Pièces
	int[][] z;
	
	public Somme(int s, int k) {
		this.s = s;
		this.k = k;
		this.pieces = new int[k];
		this.z = new int[s+1][k+1];
	}
}
