package lesson001;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		// Girilen ortalamanın harf notuna göre geçip geçmediğini bulan program
		// 90 üstü AA
		// 80 ve 90 arası BB
		// 60 la 70 arası DD
		// 60 tan küçükse FF

		double ort;
		Scanner input = new Scanner(System.in);
		System.out.println("Ortalamayı Giriniz");
		ort = input.nextDouble();
		if(ort >=90) {
			System.out.println("Harf Notu : AA");
		}
		else if(ort >=80 && ort<90) {
			System.out.println("Harf Notu : BB");
		}
		else if(ort >=70 && ort<80) {
			System.out.println("Harf Notu : CC");
		
		}else if(ort >=60 && ort<70) {
			System.out.println("Harf Notu : DD");
		}
		else {
			System.out.println("Harf Notu : FF");
		}
		
		
	}

}
