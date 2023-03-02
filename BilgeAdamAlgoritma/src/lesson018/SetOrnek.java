package lesson018;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetOrnek {
	public static void main(String[] args) {
		/*
		 * 2 Tane set oluşturalım tekrarEdenler , tekrar etmeyenler kullanıcıdan bir
		 * kelime alıcaz
		 * 
		 * tekraredenleri tekraretmeyenleri yazıdr
		 * 
		 */

		Set<Character> tekrarEdenler = new HashSet<>();
		Set<Character> tekrarEtmeyenler = new HashSet<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir kelime girin");
		String kelime = sc.nextLine();
		for (int i = 0; i < kelime.length(); i++) {
			if(!tekrarEdenler.contains(kelime.charAt(i)) && !tekrarEtmeyenler.add(kelime.charAt(i))) {
				tekrarEdenler.add(kelime.charAt(i));
				tekrarEtmeyenler.remove(kelime.charAt(i));
			}
			
		}
		System.out.println("Tekrar edenler : ");
		System.out.println(tekrarEdenler);
		System.out.println("Tekrar etmeyenler : ");
		System.out.println(tekrarEtmeyenler);
	}
}
