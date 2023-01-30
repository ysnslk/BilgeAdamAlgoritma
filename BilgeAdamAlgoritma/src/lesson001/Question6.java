package lesson001;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {
		//kullanıcdan alınan vize ve final notlarını 
		//geçip geçmediğini yazan prog
		
		Scanner input = new Scanner(System.in);
		
		float vize ,fnal , ort;
		System.out.println("Vize notunu girin");
		vize = input.nextFloat();
		System.out.println("Final notunu girin");
		fnal = input.nextFloat();
		ort = (vize *0.4f)+ (fnal*0.6f);
		if(ort >=50) {
			System.out.println("Geçtiniz");
		}
		else {
			System.out.println("Kaldınız");
		}
		
	}

}
