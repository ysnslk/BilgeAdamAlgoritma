package lesson005;

public class Question40 {

	public static void main(String[] args) {
		//a ile biten kelimelerin yerine ? koyalım
		//0 index değişti diyelim --> yeni değeri(?)
		String [] dizi = {"Amerkia","Almanya","İsveç","Türkiye","Danimarka"};

		for(int i=0;i<dizi.length;i++) {
			if(dizi[i].endsWith("a")) {
				dizi[i]="?";
				String yeniDeger = dizi[i];
				System.out.println(i+". index değişti ->"+yeniDeger);
			}
		}
	}

}
