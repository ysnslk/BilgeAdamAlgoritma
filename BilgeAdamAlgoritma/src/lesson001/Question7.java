package lesson001;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		//Girilen sayının tek mi çift mi olduğunu bulan program
		Scanner input = new Scanner(System.in);
		int sayi ;
		System.out.println("Sayı Giriniz");
		sayi = input.nextInt();
		if(sayi %2 == 0) {
			System.out.println("Sayı çifttir");
		}
		else {
			System.out.println("Sayı tektir");
		}

	}

}
