package lesson008;

public class Question64 {

	public static void main(String[] args) {

		//Cosenio
		//5dk Girilen kelimenin ilk ve son harfini değiştirelim
		//Girilen kelimenin  0 ile 100 arasında olması gerek
		//Eğer tek harf girilidi ise
		//Palindrom
		System.out.println(harfDegistir("cosenio"));
		System.out.println(isPalindrom("cosenio"));
		
		System.out.println(isPalindrom("kayak") == true ? "Palindorum" : "Palindrom Değil");
		
		
		
	}
		public static String harfDegistir (String kelime) {
			if(kelime.length()> 100 || kelime.length()< 0 ) {
				System.out.println("Girilen kelime formata uygun değil");
			}
			else if(kelime.length() == 1) {
				return kelime;
			}
			
				char[]ch = kelime.toCharArray();
				char ilkHarf = ch[0];
				char sonHarf = ch[ch.length-1];
				ch[0]=sonHarf;
				ch[ch.length-1] = ilkHarf;
				return String.valueOf(ch);
			
			
		}

	public static boolean isPalindrom(String kelime) {
		//kelimeyi ters çevirelim
		String tersi = new StringBuilder(kelime).reverse().toString();
		boolean kontrol =kelime.equals(tersi);
		return kontrol;
		 
	}

}
