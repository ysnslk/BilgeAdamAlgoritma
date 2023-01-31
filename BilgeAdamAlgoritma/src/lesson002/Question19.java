package lesson002;

import java.util.Scanner;

public class Question19 {

	public static void main(String[] args) {
		// Girilen karakterin ünlü mü ünsüz mü olduğunu bulan program
		char a ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir karakter girin");
		a = sc.next().charAt(0);
		if(a=='a' ||a=='e' ||a=='i' ||a=='ı' ||a=='o' ||a=='ö'
				||a=='u' ||a=='ü' ||a=='A' ||a=='E' ||a=='I'
				||a=='İ' ||a=='O' ||a=='Ö' ||a=='U' ||a=='Ü' ) {
			System.out.println("Karakteri Sesli harftir");
		}
		else {
			System.out.println("Karakteri Sessiz harftir");
		}

	}

}
