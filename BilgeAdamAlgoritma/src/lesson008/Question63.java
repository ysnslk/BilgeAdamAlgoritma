package lesson008;

public class Question63 {
	
	public static void arrayTopla(int[] array1,int[] array2) {
		int[] arrayTopla = new int[array1.length];
		for (int i = 0; i < arrayTopla.length; i++) {
			arrayTopla[i] = array1[i]+array2[i];
			System.out.print(arrayTopla[i] +" ");
			
		}
	}
	

	public static void main(String[] args) {
		//Parametre olarak iki tane array alan
		//ve aldığımızı arrayleri toplayıp farklı bir arrayin içinde saklayan metod
		//Toplamları yazdırcaz
		int[] array1 = { 1, 2, 3, 4, 5, 6 };
		int[] array2 = { 1, 2, 3, 4, 5, 6 };
		arrayTopla(array1,array2);
	}

}
