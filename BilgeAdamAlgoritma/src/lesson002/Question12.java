package lesson002;

import java.util.Scanner;

public class Question12 {

	public static void main(String[] args) {
		//Dışarıdan iki tane sayısal değer alalım
		//İki sayının toplamı çift ise true tek ise false
		//En sonda sayıların toplamının yarısını yazdır.
		
		Scanner sc = new Scanner(System.in);
		boolean ciftMi ;
		int s1,s2,toplam;
		System.out.println("1.Sayıyı girin :");
		s1 = sc.nextInt();
		System.out.println("2.Sayıyı girin :");
		s2 = sc.nextInt();
		toplam = s1 +s2;
		if(toplam%2 == 0) {
			ciftMi = true;	
		}
		else {
			ciftMi=false;
		}
		System.out.println(ciftMi);
		System.out.println(toplam/2f);
	}

}
