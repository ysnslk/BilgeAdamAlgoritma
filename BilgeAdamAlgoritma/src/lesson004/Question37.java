package lesson004;

import java.util.Scanner;

public class Question37 {

	public static void main(String[] args) {
		//Kullanıcıdan 
		//maill @hotmail.com @outlook.com, pass , repass
		//e mail formatını kontrol et.
		Scanner sc = new Scanner(System.in);
		String mail,pass,repass;
		boolean mailCheck=false;
		boolean passCheck = false;
		
		while (mailCheck==false) {
			System.out.println("Mail adresi giriniz");
			mail = sc.nextLine();
			if(mail.contains("@hotmail.com") ||mail.contains("@outlook.com")) {
				mailCheck = true;
			}
			else {
				System.out.println("Mail formatı hatalı tekrar deneyin.\n");
			}
		}
		while (passCheck==false) {
			System.out.println("Şifre giriniz");
			pass = sc.nextLine();
			System.out.println("Şifreyi tekrar giriniz");
			repass = sc.nextLine();
			if(pass.length()>=8 && repass.length()>=8 ) {
				if(pass.equals(repass)) {
					System.out.println("Başarı ile kayıt oldunuz.");
					passCheck=true;
				}
				else {
					System.out.println("Şifreler uyuşmuyor tekrar deneyin.");
				}
				
			}
			else {
				System.out.println("Şifreniz 8 karakterden büyük olmalı");
			}
		}
		
		
		
	}

}
