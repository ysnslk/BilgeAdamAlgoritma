package lesson008;

import java.util.Scanner;

public class Question62 {
	
	public static void emailCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mail Adresinizi Giriniz");
		String mail = sc.nextLine();
		if(mail.contains("@")) {
			String[] a  = mail.split("@");
			for (int i = 1; i < a.length; i++) {
				if(a[i].equals("hotmail.com") || a[i].equals("gmail.com") ) {
					System.out.println("Mail Formatı Doğru");
				}
				else {
					System.out.println("Mail Formatı Doğru Değil!!!");
				}
			}
			
		}
	}
	public static void passCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Şifreinizi Giriniz");
		int pass = sc.nextInt();
		System.out.println("Şifreinizi Tekrar Giriniz");
		int rePass = sc.nextInt();
		if(pass == rePass) {
			System.out.println("Şifreler Uyuşuyor Kayıt Başarılı");
			}
		else {
			
		}
		System.out.println("Şifreler Uyuşmuyor Kayıt Başarısız");
		}
	

	public static void main(String[] args) {
		//2 metot yazalım
		//1-Kullanıcıdan aldığımız email değerini kontrol edelim
		//Dogru formatta mı ?
		//hotmail.com ve ya gmail.com	ile mi bitiyor
		//Pass ve repass kontrol edilecek
		
		emailCheck();
		passCheck() ;
	}

}
