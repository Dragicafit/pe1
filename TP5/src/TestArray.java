import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestArray {
	static int SIZE = 100000;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] array = new int[SIZE];
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int i = 0; i < SIZE; i++) {
			list.add(getRandomNumberInRange());
			array[i] = getRandomNumberInRange();
			hash.put(i, getRandomNumberInRange());
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < Character.MAX_VALUE; j++) {
				int a = list.get(i);
			}
		}
		System.out.println(1);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < Character.MAX_VALUE; j++) {
				int a = array[i];
			}
		}
		System.out.println(2);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < Character.MAX_VALUE; j++) {
				int a = hash.get(i);
			}
		}
		System.out.println(3);
	}

	private static int getRandomNumberInRange() {
		return new Random().nextInt(10000);
	}
}
