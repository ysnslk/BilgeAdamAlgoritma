package lesson006;

import java.util.Scanner;

public class Question51 {

	public static void main(String[] args) {
		// Girilen Tr karakterleri Ing ye çeviriyoru
		String[] ingilizceKarakter = { "I", "i", "s", "S", "c", "C", "g", "G", "u", "U", "o", "O" };
		String[] turkceKarakter = { "İ", "ı", "ş", "Ş", "ç", "Ç", "ğ", "Ğ", "ü", "Ü", "ö", "Ö" };

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir metin girin");
		String metin = sc.nextLine();
		String metin1 = "";
		for (int i = 0; i < turkceKarakter.length; i++) {
			metin = metin.replace(turkceKarakter[i], ingilizceKarakter[i]);
			
		}
		System.out.println(metin);
	}

}
