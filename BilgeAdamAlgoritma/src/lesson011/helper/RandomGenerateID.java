package lesson011.helper;

import java.util.Random;

public class RandomGenerateID {
	public static String generateID() {
		Random rnd = new Random();
		int n = rnd.nextInt(1, 100);
		String random = Integer.toString(n);
		return random;

	}
}
