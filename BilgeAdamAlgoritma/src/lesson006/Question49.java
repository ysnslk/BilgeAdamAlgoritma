package lesson006;

public class Question49 {

	public static void main(String[] args) {
		// Tek sayıları farklı bir array içine atalım.
		int[][] matris = { { 56, 23, 678, 231, 5 }, { 234, 21, 78, 26, 6 }, { 654, 33, 32, 67, 2 },
				{ 189, 35, 56, 89, 8 } };
		int index = 0;
		int[] array = new int[matris.length*matris.length];
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris[i].length; j++) {
				if (matris[i][j] % 2 != 0) {
					array[index] = matris[i][j];
					index++;
					System.out.print(array[i] + "  ");
					
				}

			}
		}

	}

}
