package lesson003;

import java.util.Scanner;

public class Question30 {

	public static void main(String[] args) {
		//girilen sayıya kadar tek olan sayıların toplamı
				Scanner sc = new Scanner(System.in);
				int sayi,toplam=0;
				System.out.println("Sayı Giriniz");
				sayi = sc.nextInt();
				
				for(int i=1;i<=sayi;i+=2) {
					toplam = toplam + i;
				}
				System.out.println("Tek Sayıların Toplamı : "+toplam);

	}

}
