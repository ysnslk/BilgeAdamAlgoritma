package lesson006;

public class Question46 {

	public static void main(String[] args) {
		// 3 x 3 boş matris oluşturalım

		// 1 1 1
		// 2 2 2
		// 3 3 3

		int[][] matris = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris[i].length; j++) {
				System.out.print(matris[i][j]);

			}
			System.out.println();
		}

	}

}
