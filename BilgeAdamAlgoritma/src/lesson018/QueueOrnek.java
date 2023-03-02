package lesson018;

import java.util.Queue;
import java.util.LinkedList;

public class QueueOrnek {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.add("a");
		q.add("c");
		q.add("b");
		q.add("d");
		System.out.println(q);
		
		while (!q.isEmpty()) {
			System.out.println("Eleman Çıkartıldı : "+ q.poll());
		}
	}

}
