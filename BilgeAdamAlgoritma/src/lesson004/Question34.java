package lesson004;

import java.util.Scanner;

public class Question34 {

	public static void main(String[] args) {
		// Verilen kelimenin harflerini alt alta yazdıralrım.
		//java
		char b;
		String kelime = "java";
		for(int i=0;i<kelime.length();i++) {
			b= kelime.charAt(i);
			System.out.println(b);
		}
		
		
		//Kullanıcıdan string değeri alalım. 
		//harfleri yazdır.
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir kelime girin");
		String str = sc.nextLine();
		for(int i=0;i<str.length();i++) {
			System.out.println(i+".index ->"+str.charAt(i));
		}
		
	}

}
