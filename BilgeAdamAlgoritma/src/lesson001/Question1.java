package lesson001;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {

		// Javada primitive tipler nelerdir ?
		// Birbirinden farkı ?

		// Verilen isim ve soy isim değerleini hello (isim ) soyisim yaz
		// Değişken tanımlarken
		String name = "Yasin";
		String sname = "Solak";
		System.out.println("Hello " + name + " " + sname);

		// Girilen isim soyismi yazdıran program
		System.out.println("************************");
		Scanner input = new Scanner(System.in);
		System.out.println("İsminiz ?");
		name = input.next();
		System.out.println("Soyisminiz ?");
		sname = input.nextLine();
		System.out.println(name + " " + sname);

	}

}
