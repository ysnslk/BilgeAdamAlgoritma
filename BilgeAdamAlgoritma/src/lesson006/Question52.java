package lesson006;

import java.util.Iterator;

public class Question52 {

	public static void main(String[] args) {
		//Verilen arrayde tekrar eden sayıları bun
		
		int array1[] = { 50, 60, 3, 4, 3, 9, 8 ,7, 45, 95};
		int array2[] = { 1, 2, 50, 60, 3, 8, 9, 7,88,95 };
		int index = 0;
		int array3[] = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				
				if(array1[i] == array2[j]) {
					array3[index] = array2[j];
					index++;
				}
			}
		}
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i]+" ");
		}
	}

}
