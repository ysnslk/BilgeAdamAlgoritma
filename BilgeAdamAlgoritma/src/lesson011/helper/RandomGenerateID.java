package lesson011.helper;

import java.util.Random;

public class RandomGenerateID {
	public static String generateID() {
		Random rnd = new Random();
		int n = rnd.nextInt(100, 1000);
		String random = Integer.toString(n);
		return random;

	}
	
	public static String generateProduct(String name) {
		String code = generateID();
		String newCode = name.substring(0,3)+code;
		return newCode;

	}
}
