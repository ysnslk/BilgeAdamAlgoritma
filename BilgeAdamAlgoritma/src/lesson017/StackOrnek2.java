package lesson017;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackOrnek2 {

	static Stack<Character> stack = new Stack<>();

	public static void palindrom(String name) {

		for (int i = 0; i < name.length(); i++) {
			stack.add(name.charAt(i));
		}
		for (Character character : stack) {
			System.out.println(character);
		}
	}

	public static boolean isPalindrom(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != stack.pop()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Kelime girin");
		String kelime = sc.next();
		palindrom(kelime);

		if (isPalindrom(kelime)) {
			System.out.println("Palindrom");
		} else {
			System.out.println("Palindrom değil");
		}
	}
}
