import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestArray {
	static int SIZE = 100000;
	static int NB = 1000;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] array = new int[SIZE];
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int i = 0; i < SIZE; i++) {
			list.add(getRandomNumberInRange());
			array[i] = getRandomNumberInRange();
			hash.put(i, getRandomNumberInRange());
		}
		
		System.out.println("aleatoire");
		
		long init = System.currentTimeMillis();
		for (int j = 0; j < NB; j++) {
			for (int i = 0; i < SIZE; i++) {
				int a = array[getRandomNumberInRange(SIZE)];
				a++;
			}
		}
		System.out.println("tableau : " + (System.currentTimeMillis() - init));
		init = System.currentTimeMillis();

		for (int j = 0; j < NB; j++) {
			for (int i = 0; i < SIZE; i++) {
				int a = list.get(getRandomNumberInRange(SIZE));
				a++;
			}
		}
		System.out.println("arraylist : " + (System.currentTimeMillis() - init));
		init = System.currentTimeMillis();
		for (int j = 0; j < NB; j++) {
			for (int i = 0; i < SIZE; i++) {
				int a = hash.get(getRandomNumberInRange(SIZE));
				a++;
			}
		}
		System.out.println("hashmap : " + (System.currentTimeMillis() - init));
		init = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < NB; j++) {
				int a = array[i];
				a++;
			}
		}

		System.out.println("ordonné");
		System.out.println("tableau : " + (System.currentTimeMillis() - init));
		init = System.currentTimeMillis();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < NB; j++) {
				int a = list.get(i);
				a++;
			}
		}
		System.out.println("arraylist : " + (System.currentTimeMillis() - init));
		init = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < NB; j++) {
				int a = hash.get(i);
				a++;
			}
		}
		System.out.println("hashmap : " + (System.currentTimeMillis() - init));
	}

	private static int getRandomNumberInRange() {
		return new Random().nextInt(10000);
	}

	private static int getRandomNumberInRange(int i) {
		return new Random().nextInt(i);
	}
}
