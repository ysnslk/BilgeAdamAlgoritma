package lesson002;

import java.util.Scanner;

public class Question13 {
	
	
	//Telefona ve maile bir kod gelecek bu kodları biz tanımlıyoruz.
	//Kullanıcadan maile ve telefona gelen kodu istiyoruz.
	//Eğer onun mailine ve telefonuna giden kod ile uyuşuyorsa 
	//Sisteme kayıt oldunuz.
	//Eğer bir yanlış varsa bunun nerden olduğunu bul.
			

	public static void main(String[] args) {
		
		int mailKod, telKod;
		int mailKodS = 123456 ,telKodS = 123456;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Lütfen mailinize gelen kodu giriniz");
		mailKod = sc.nextInt();
		System.out.println("Lütfen telefonunuza gelen kodu giriniz");
		telKod = sc.nextInt();
		if(mailKodS == mailKod && telKodS == telKod) {
			System.out.println("Sisteme başarı ile kayıt oldunuz.");
		}
		else if(mailKodS != mailKod && telKodS == telKod) {
			System.out.println("Lütfen mailinizdeki kodu kontrol edin");
		}
		else if(mailKodS == mailKod && telKodS != telKod){
			System.out.println("Lütfen telefonunuza gelen kodu kontrol edin");
		}
		else {
			System.out.println("Lütfen her iki doğrulama kodunu kontrol ediniz.");
		}
	}

}
