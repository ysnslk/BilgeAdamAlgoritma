package lesson006;

import java.util.Iterator;
import java.util.Scanner;

public class Question47 {

	public static void main(String[] args) {
		//İkiye ikilik bir array oluştur
		//İçinde isimler yazılsın
		
		//1. grup
		//Ali
		//Mehmet
		
		//2.Grup
		//Ahmet
		//Hakan 
		
		
		String[][] str = new String [2][2];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < str.length; i++) {
		
			for (int j = 0; j < str[i].length; j++) {
				System.out.println(i+". Satır "+j+" . sütün elamanı giriniz");
				str[i][j] = sc.nextLine();
			}
		}
		
		for (int i = 0; i < str.length; i++) {
			System.out.println((i+1)+" . Grup");
			for (int j = 0; j < str[i].length; j++) {
				System.out.println(str[i][j]);
			}
			System.out.println();
		}
	}

}
