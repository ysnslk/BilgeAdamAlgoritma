package lesson002;

import java.util.Scanner;

public class Question14 {
	// Girilen 3 sayıyı büyükten küçüğe sırala
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int s1, s2, s3;
		System.out.println("1.Sayıyı Girin");
		s1 = sc.nextInt();
		System.out.println("2.Sayıyı Girin");
		s2 = sc.nextInt();
		System.out.println("3.Sayıyı Girin");
		s3 = sc.nextInt();
		if (s1 < s2 && s1 < s3 && s2 < s3) {
			System.out.println(s1 + " < " + s2 + " < " + s3);
		} else if (s1 < s2 && s1 < s3 && s3 < s2) {
			System.out.println(s1 + " < " + s3 + " < " + s2);
		} else if (s2 < s1 && s3 < s1 && s3 < s2) {
			System.out.println(s3 + " < " + s2 + " < " + s1);
		} else if (s2 < s1 && s3 < s1 && s2 < s3) {
			System.out.println(s2 + " < " + s3 + " < " + s1);
		}
	}
}
