package lesson005;

public class Question43 {

	public static void main(String[] args) {
		//dizi içinde 2 ve 4 un kaç kere geçtiğini bulun
		//Hangisi daha fazla ise onu bul
		//ÖDEV Kaçları saymak istiyosak kullanıcıdan alalım
		int[] array = { 1, 3, 4, 4, 4, 4, 2, 2, 9, 8, 8 };
		int ikiSay=0 ,dortSay=0;
		for(int i =0 ;i<array.length;i++) {
			if(array[i] == 2 ) {
				ikiSay++;
			}
			else if(array[i] == 4) {
				dortSay++;
			}
		}
		if(ikiSay > dortSay) {
			System.out.println("2 ler 4 lerden daha fazla dizi içinde " + ikiSay +" tane 2 var");
		}
		else if(ikiSay < dortSay) {
			System.out.println("4 ler 2 lerden daha fazla dizi içinde " + dortSay +" tane 2 var");
		}
		else {
			System.out.println("4 ler ve 2 ler birbirine eşit");
		}

	}

}
