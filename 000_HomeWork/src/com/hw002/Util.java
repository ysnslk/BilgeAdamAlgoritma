package com.hw002;

import java.util.Scanner;

public class Util {
	static Scanner sc = new Scanner(System.in);

	public static int intDegerAl(String sorgu) {
		System.out.println(sorgu);
		int intDeger = sc.nextInt();
		return intDeger;
	}

	public static String StringDegerAl(String sorgu) {
		System.out.println(sorgu);
		String StringDeger = sc.next();
		return StringDeger;
	}

}
