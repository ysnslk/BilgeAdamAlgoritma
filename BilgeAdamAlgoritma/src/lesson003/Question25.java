package lesson003;

import java.util.Scanner;

public class Question25 {

	public static void main(String[] args) {
		//Girilen sayının asal olup olmadığını bulan program
				Scanner sc = new Scanner(System.in);
				int sayi = sc.nextInt();
				int sayac =0;
				for(int i=2;i<sayi;i++) {
					if(sayi%i==0) {
						sayac++;
					}
				}
				if(sayac ==0) {
					System.out.println("Sayı asaldır");
				}else {
					System.out.println("Asal değildir");
				}

	}

}
