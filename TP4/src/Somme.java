
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
			for (int j = 0; j <= k; j++) {
				z[i][j] = -2;
			}
		}
		for (int i = 0; i <= s; i++) {
			this.z[i][0] = -1;
		}
		for (int i = 0; i <= k; i++) {
			this.z[0][i] = 0;
		}
	}

	public void fillZ(int i, int j) {
		if (z[i][j - 1] == -2) {
			fillZ(i, j - 1);
		}
		if (i - pieces[j] < 0) {
			z[i][j] = z[i][j - 1];
			return;
		}
		if (z[i - pieces[j]][j] == -2) {
			fillZ(i - pieces[j], j);
		}
		z[i][j] = min(z[i][j - 1], plus(z[i - pieces[j]][j]));
	}

	public long min(long a, long b) {
		if (a == -1) {
			return b;
		}
		if (b == -1) {
			return a;
		}
		return a < b ? a : b;
	}

	public long plus(long a) {
		return a == -1 ? -1 : a + 1;
	}

	public void afficher() {
		for (int j = s; j >= 0; j--) {
			for (int i = 0; i <= k; i++) {
				if (z[j][i] >= 0) {
					System.out.print(z[j][i] + " ");
				}else {
					System.out.print("∞ ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Somme s = new Somme(8, 3);
		s.pieces = new int[] { 0, 6, 4, 2 };
		s.fillZ(8, 3);
		s.afficher();
	}
}
