
public class Somme {

	int s; // Somme à atteindre
	int k; // Pièces utilisés
	int[] pieces; // Pièces
	long[][] z;

	public Somme(int s, int k) {
		this.s = s;
		this.k = k;
		this.pieces = new int[k];
		this.z = new long[s + 1][k + 1];
		initZ();
	}

	public void initZ() {
		for (int i = 0; i <= s; i++) {
			this.z[i][0] = -1;
		}
		for (int i = 0; i <= k; i++) {
			this.z[0][i] = 0;
		}
	}
}
