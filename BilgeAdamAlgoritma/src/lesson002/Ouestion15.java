package lesson002;

import java.util.Scanner;

public class Ouestion15 {
	/*
	 * Koç Burcu : 21 Mart - 20 Nisan           Boğa Burcu : 21 Nisan - 21 Mayıs
	 *           İkizler Burcu : 22 Mayıs - 22 Haziran           Yengeç Burcu : 23
	 * Haziran - 22 Temmuz           Aslan Burcu : 23 Temmuz - 22 Ağustos          
	 * Başak Burcu : 23 Ağustos - 22 Eylül           Terazi Burcu : 23 Eylül - 22
	 * Ekim           Akrep Burcu : 23 Ekim - 21 Kasım           Yay Burcu : 22
	 * Kasım - 21 Aralık           1. Ay Oğlak Burcu : 22 Aralık - 21 Ocak          
	 * 1. Ay Kova Burcu : 22 Ocak - 19 Şubat           Balık Burcu : 20 Şubat - 20
	 * Mart        
	 */
//        // Kaçıncı ayda doğdunuz-->  4. ayda 
//        // hangi gün doğdunuz-->  Ayın 20'sinde
//        //Switch case kullanalım
//        //Default --> lütfen 1-12 arasında bir sayı girin
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ay, gun;
		System.out.println("Hangi Ayda Doğdunuz");
		ay = sc.nextInt();
		System.out.println("Hangi Gün Doğdunuz");
		gun = sc.nextInt();
		if(gun > 31) {
			System.out.println("Lütfen geçerli bir gün girin");
		}
		else {
			switch (ay) {
			case 1:
				if (gun > 22) {
					System.out.println("Kova Burcusunuz");
				} else {
					System.out.println("Oğlak Burcusunuz");
				}
				break;
			case 2:
				if (gun >= 20) {
					System.out.println("Balık Burcusunuz");
				} else {
					System.out.println("Kova Burcusunuz");
				}

				break;
			case 3:
				if (gun > 20) {
					System.out.println("Koç Burcusunuz");
				} else {
					System.out.println("Balık Burcusunuz");
				}
				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			case 10:

				break;
			case 11:

				break;
			case 12:

				break;

			default:
				System.out.println("lütfen 1-12 arasında bir sayı girin");
			}
		}

	}

}
