package lesson007;

public class Question54 {

	public static void main(String[] args) {
		//Verilen dizide rakamların farkının en az olduğu  sayıların farkını bulalım.
		int [] array2 = {1,-10,-4,3};
		int deger =0,fark = 100;
	//	int mutlakdeğer = Math.absExact(-4);

		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if(i != j ) {
					deger = Math.abs(array2[i]-array2[j]);
					System.out.print (deger+" ");
					if(deger <= fark) {
						fark = deger;
					}
				}
			}
		}
		System.out.println("\nEk az fark : "+ fark);
		
	}

}
