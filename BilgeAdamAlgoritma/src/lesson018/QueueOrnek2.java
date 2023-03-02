package lesson018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueOrnek2 {
	/*
	 * Bir Queue oluşturalım 10 - 12 Isım queue
	 * 
	 * Daha sonra 1 -10 Arasında sayı üretelim
	 * 
	 * pide yazdıralım
	 * 
	 * Kuyruga göre pideleri dagıtıcaz pideler bittiğinde pideler bitti yazdıralım
	 * pideyi alan kişileri kuyruktan çıkartıcaz pideyi almayan kişileri yazdırıcaz
	 */

	public static void main(String[] args) {
		Queue<String> customer = new LinkedList<>();
		customer.add("a");
		customer.add("b");
		customer.add("c");
		customer.add("d");
		customer.add("e");
		customer.add("f");
		customer.add("g");
		customer.add("h");
		customer.add("ı");
		customer.add("i");
		customer.add("j");
		customer.add("k");

		Random rnd = new Random();
		int pideSayisi = rnd.nextInt(1, 11);
		for (int i = 0; i < pideSayisi; i++) {
			customer.poll();
		}

		if (!customer.isEmpty()) {
			System.out.println("Pide Alamayan Müşteriler");
			System.out.println(customer);
		} else {
			System.err.println("Pide almayan müşteri  kalmamıştır...!!");
		}
	}
}
