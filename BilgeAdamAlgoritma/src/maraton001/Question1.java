package maraton001;

public class Question1 {

	public static void yildizYazdir() {
		for (int i = 1; i < 12; i++) {
			if (i > 7) {
				for (int j = 1; j < 8; j++) {
					System.out.print("* ");
				}
				System.out.println();

			} else {
				for (int j = 1; j < i; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}

		}
	}

	public static void main(String[] args) {
		/*
		 * Aşağıdaki şeklidöngülerkullanarakekrana çizdiren staticmetod yazınız ve main
		 * içinden bu metoduçağırarak çalıştırınız:
		 */
		yildizYazdir();

	}

}
