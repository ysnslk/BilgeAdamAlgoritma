package lesson001;

import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		// Girilen 3 sayıdan en büyük olanı yazdıran program
		
		Scanner input = new Scanner(System.in);
		
		int n1,n2,n3;
		System.out.println("1. Sayıyı Girin");
		n1=input.nextInt();
		System.out.println("2. Sayıyı Girin");
		n2=input.nextInt();
		System.out.println("3. Sayıyı Girin");
		n3=input.nextInt();
		if(n1 > n2 && n1 > n3) {
			System.out.println("1. Sayı en büyük sayı");
		}
		else if(n2 > n1 && n2 > n3) {
			System.out.println("2. Sayı en büyük sayı");
		}
		else if(n3 > n1 && n3 > n2){
			System.out.println("3. Sayı en büyük sayı");
		}
		else {
			System.out.println("Eşit Sayılar var");
		}
		

	}

}
