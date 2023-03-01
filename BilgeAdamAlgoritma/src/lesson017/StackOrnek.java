package lesson017;

import java.util.Iterator;
import java.util.Stack;

public class StackOrnek {

	public static void main(String[] args) {
		/*
		 * Ekleme işlemi
		 * 
		 * Stack --> (LIFO) Stack oluşturalım int değer atayalım stack i yazdılarım.
		 * 
		 * stack boşalana kadar bütün elemanları yazdıralım
		 */

		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(3);
		stack.add(94);
		stack.add(70);
		stack.add(150);
		stack.add(101);

		for (int s : stack) {
			System.out.println(s);
		}

//		while (!stack.isEmpty()) {
//			System.out.println("Eleman çıkartıldı : " + stack.pop());
//		}

		Stack<Integer> stack2 = new Stack<>();
		int toplam = 0;
		System.out.println("\n- - - - - \n");

		while (!stack.isEmpty()) {
			if (stack.peek() < 100) {
				toplam += stack.peek();
				System.out.println("Toplanıp Çıkanlar : " + stack.pop());
			} else {
				System.out.println("100 den büyük  Çıkanlar : " + stack.pop());
				stack2.push(stack.peek());
			}
		}
		System.out.println("\nYeni Stack\n");
		for (Integer integer : stack2) {
			System.out.println(integer);
		}
		System.out.println("Toplam : " + toplam);

	}

}
