package lesson002;

import java.util.Scanner;

public class Question17 {
	//Girilen karakterin ASCII kodunu bulan program.

	public static void main(String[] args) {
		char a ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir karakter girin");
		a = sc.next().charAt(0);
		int asciiCode = a;
		
		System.out.println("ASCII kodu : "+ asciiCode);
	}
}
