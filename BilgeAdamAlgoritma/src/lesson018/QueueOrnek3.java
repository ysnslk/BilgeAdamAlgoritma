package lesson018;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueOrnek3 {

	public static void main(String[] args) {
		/*
		 * Musteri sınıfı açalım isim yas Mainde queue oluştur Müşterileri at
		 * 
		 * müşterileri yaş önceliğine göre işlem yapıp kuyruktan at
		 * 
		 * Comparable
		 */

		Queue<Musteri> musteriQueue = new PriorityQueue<>();
		musteriQueue.offer(new Musteri("Ahmet", 25));
		musteriQueue.offer(new Musteri("Mustafa", 20));
		musteriQueue.offer(new Musteri("Fatma", 35));
		musteriQueue.offer(new Musteri("Yaşar", 23));
		musteriQueue.offer(new Musteri("Zehra", 26));
		musteriQueue.offer(new Musteri("Bugra", 48));

		System.out.println("* * * * * * * * * *  * * * * * * * * ");
		while (!musteriQueue.isEmpty()) {
			System.out.println("Kuyruktan çıkmıştır " + musteriQueue.poll().getIsim());
		}

	}

}
