package lesson002;

import java.util.Scanner;

public class Question18 {

	//Girilen char değerini alfabenin içinde var mı yok mu 
	public static void main(String[] args) {
		char x ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir karakter girin");
		x = sc.next().charAt(0);
		if(x >= 65 && x >=90 || x>=97 && x<=109) {
			System.out.println("Girilen karakter alfabenin içinde vardır.");
		}
		else {
			System.out.println("Girilen karakter alfabenin içinde yoktur.");
		}
	}

}
