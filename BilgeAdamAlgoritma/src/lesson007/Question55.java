package lesson007;

public class Question55 {

	public static void main(String[] args) {
		//Verilen arrayda en büyük ve en küçük  değerleri bulan prog
		String[] array = { "5", "2", "3", "4", "99", "85" };
		int enb= 0 ,enk =100;
		for (int i = 0; i < array.length; i++) {
			if(enb <= Integer.parseInt(array[i])) {
				enb = Integer.parseInt(array[i]);//Primitive int verir
				//enb = Integer.valueOf(array[i]); Nesne döndürür
				
			}
			if(enk >=Integer.parseInt(array[i])){
				enk = Integer.parseInt(array[i]);
			}
		}
		System.out.println("En Büyük : "+enb);
		System.out.println("En Küçük : "+enk);

	}

}
