package lesson018;

import java.util.PriorityQueue;
import java.util.Queue;

public class AcilServis {

	public static void main(String[] args) {

		Queue<Hasta> acilServis = new PriorityQueue<>();

		acilServis.offer(new Hasta("Oguz", "Apandist"));
		acilServis.offer(new Hasta("Kemal", "Agrı"));
		acilServis.offer(new Hasta("Ayşe", "Yanık"));
		acilServis.offer(new Hasta("Zeliha", "Yanık"));
		acilServis.offer(new Hasta("Okan", "Apandist"));
		acilServis.offer(new Hasta("Orhan", "Yanık"));
		acilServis.offer(new Hasta("Merve", "Yanık"));
		acilServis.offer(new Hasta("Gizem", "Agrı"));
		acilServis.offer(new Hasta("Muharrem", "Apandist"));

		while (!acilServis.isEmpty()) {
			System.out.println(acilServis.peek().getIsim() + " " + acilServis.peek().getSikayet() + " "
					+ acilServis.poll().getOncelik());
		}
	}

}
