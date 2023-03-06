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
		System.out.println("\n- - - - - - - - - \n");

		Queue<Hasta> acilServis2 = new PriorityQueue<>();

		acilServis2.offer(new Hasta("Oguz", ESikayet.APANDIST));
		acilServis2.offer(new Hasta("Kemal", ESikayet.YANIK));
		acilServis2.offer(new Hasta("Ayşe", ESikayet.AGRI));
		acilServis2.offer(new Hasta("Zeliha", ESikayet.YANIK));
		acilServis2.offer(new Hasta("Okan", ESikayet.APANDIST));
		acilServis2.offer(new Hasta("Orhan", ESikayet.AGRI));
		acilServis2.offer(new Hasta("Merve", ESikayet.YANIK));
		acilServis2.offer(new Hasta("Gizem", ESikayet.AGRI));
		acilServis2.offer(new Hasta("Muharrem", ESikayet.APANDIST));

		while (!acilServis2.isEmpty()) {
			System.out.println(acilServis2.peek().getIsim() + " " + acilServis2.peek().getSikayet() + " "
					+ acilServis2.poll().getOncelik());
		}

	}

}
