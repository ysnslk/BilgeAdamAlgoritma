package lesson003;

public class Question24 {

	public static void main(String[] args) {
		// 1den 100 e kadar çift sayıların toplamını tek sayıların
		//oranını bulan program
		double tekt =0,ciftt=0;
		for(int i=1;i<=100;i++) {
			if(i%2 == 0) {
				ciftt = ciftt+i;
			}
			else {
				tekt = tekt+i;
			}
		}
		System.out.println("Oran = "+(ciftt/tekt));
	}

}
