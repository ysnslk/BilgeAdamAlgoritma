package lesson001;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		//Girilen TL değerini USD'ye çeviren program
		Scanner input = new Scanner(System.in);
		
		final double usd = 18.90;
		double tl,x;
		System.out.println("Çevirmek istediğiniz TL miktarını girin");
		tl = input.nextDouble();
		x = tl / usd;
		System.out.println("Paranın Dolar cinsi :"+x);
		
	}

}
