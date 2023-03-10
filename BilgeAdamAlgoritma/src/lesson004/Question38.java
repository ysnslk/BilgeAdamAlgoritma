package lesson004;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Question38 {

	public static void main(String[] args) {
		//          Menu 1-Dışarıdan bir kelime ve bir harf girilsin  eğer kelimemizin
		// için de o 
		//         harf varsa kaç tane olduğunu ve index numaralarını yazdırın.
		//         eğer harfi içermiyorsa bir çıktı aradağınız harf yok gibi
		//         2-Dışarıdan bir kelime giriniz daha sonra değiştirmek istediğiniz
		// harfi
		//           giriniz daha sonra hangi harfle değiştireceğinizi giriniz Eğer
		// kelimemiz
		//           içerisinde o harf varsa değiştirsin.
		//         3-Dışarıdan Girilen bir kelimeyi ters çevirip yazdıralım.Polindrom
		// olup
		//          * olmadığını bulunuz(kek,iki,kabak,kayak)
		// 4-Sistemden çıksın

		Scanner sc = new Scanner(System.in);

		String kelime, eHarf, yHarf, polindrom;
		boolean kontrol = true;
		while (kontrol) {
			System.out.println("====String İşlemleri======");
			System.out.println("1-Harf Saydırma");
			System.out.println("2-Harf Değiştirme");
			System.out.println("3-Polindrom Kontrolü");
			System.out.println("4-Kelimenin bütün harfleri arasına ? koyalım");
			System.out.println("5-Kelimenin ilk üç index alıp sonuna ... koyun");
			System.out.println("6-Kelimenin ilk üç index alıp geri kalan harfler yerine  . koyun");
			System.out.println("0-Çıkış");
			int secim = sc.nextInt();
			sc.nextLine();
			switch (secim) {
			case 1:
				int sayac = 0;
				String indexler = "";
				System.out.println("Lütfen Bir kelime girin");
				String k = sc.nextLine();
				System.out.println("Hangi harfi saymak istersin");
				String harf = sc.nextLine();
				if (!k.contains(harf)) {
					System.out.println("Aradığınız harf kelime içinde yok");
				} else {
					for (int i = 0; i < k.length(); i++) {
						if (k.charAt(i) == harf.charAt(0)) {
							sayac++;
							indexler += i +",";
						}
					}
					System.out.println(sayac);
					System.out.println("Indexleri : "+indexler.substring(0,indexler.length()-1));
				}
				break;
			case 2:
				System.out.println("Bir kelime giriniz");
				kelime = sc.nextLine();
				System.out.println("Değişmesini istediğiniz harfi giriniz");
				eHarf = sc.nextLine();
				System.out.println("Değiştirmek istediğiniz harfi giriniz");
				yHarf = sc.nextLine();
				if (kelime.contains(eHarf)) {
					kelime = kelime.replace(eHarf, yHarf);
				} else 
				{
					System.out.println("\n\n[ " + eHarf + " ]" + " Kelime içinde mevcut değil! \n");
				}
				break;
			case 3:
				StringBuilder stringBuilder = new StringBuilder();
				System.out.println("Bir kelime giriniz");
				polindrom = sc.nextLine();
				int p = polindrom.length() - 1;
				for (int i = p; i >= 0; i--) {
					stringBuilder.append(polindrom.charAt(i));
				}
				System.out.println("Girilen Kelime :" + polindrom);
				System.out.println("Tersi :" + stringBuilder);
				System.out.println(stringBuilder);
				if (polindrom.equals(stringBuilder.toString())) {
					System.out.println("Kelime Polindromdur");
				} else 
				{
					System.out.println("değil");
				}
					System.out.println("\n\n");
				break;
			case 4:
				StringBuilder strB = new StringBuilder();
				System.out.println("Bir kelime giriniz");
				String kelime4 = sc.nextLine();
				for(int i=0;i<kelime4.length();i++) {
					strB.append(kelime4.charAt(i)+"?");
				}
				System.out.println(kelime4);
				System.out.println("Son Hal : "+strB.substring(0,strB.length()-1));
				break;
			case 5:
				System.out.println("Bir kelime giriniz");
				String kelime5 = sc.nextLine();
				String kelime6 = kelime5.substring(0,3);
				String eklenecekSekil ="...";
				System.out.println(kelime6+eklenecekSekil);
				break;
			case 6:
				System.out.println("Bir kelime giriniz");
				String kelime7 = sc.nextLine();
				String kelime8="";
				for(int i=0;i<kelime7.length();i++) {
					if(i<3) {
						kelime8+=kelime7.charAt(i);
					}
					else {
						kelime8+=".";
					}
				}
				System.out.println(kelime8);
				break;
			case 0:
				kontrol = false;
				break;

			default:
				System.out.println("Lütfen Geçerli bir değer girin");
				break;
			}

		}
		System.out.println("====== İyi Günler ======");
	}

}
