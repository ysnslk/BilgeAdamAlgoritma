package lesson003;

import java.util.Scanner;

public class Question23 {

	public static void main(String[] args) {
		// Girilen sayının faktöriyelini bulan program
		Scanner sc = new Scanner(System.in);
		System.out.println("Sayı giriniz");
		int carpim =1,sayi =sc.nextInt();
		for(int i=1;i<=sayi;i++) {
			carpim = carpim * i;
		}
		System.out.println(sayi+"! = "+carpim);
	}

}
