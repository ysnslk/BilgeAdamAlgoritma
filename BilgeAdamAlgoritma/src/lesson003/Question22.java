package lesson003;

import java.util.Scanner;

public class Question22 {

	public static void main(String[] args) {
		//Girilen sayı için çarpım tablosu yapan
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Sayı giriniz");
//		int sayi  = sc.nextInt();
//		for(int i=1;i<=9;i++) {
//			System.out.println(sayi+"x"+i +"="+ (sayi*i));
//		}
//		
		// İç içe for ile çözelim
		for(int i=1;i<=10;i++) {
			System.out.println("*****************");
			for(int j=1;j<=10;j++) {
				System.out.println(i+"x"+j +"="+ (i*j));
			}
		}

	}

}
