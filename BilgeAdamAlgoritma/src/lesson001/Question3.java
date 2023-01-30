package lesson001;

public class Question3 {

	public static void main(String[] args) {
		// Verilen ürünün satış fiyatının içinde %18 kdv ve
		// %15 kar olduğunu biliyotuız. Ürünün ham fiyatını bulan program
		//int double float default değerleri 0 olarak
		float satisf = 100, hamf = 0;
		float kar = 0.15f, kdv = 0.18f;
		hamf = satisf - (satisf * kar) - (satisf * kdv);
		System.out.println("Ürünün ham fiyatı :" + hamf);
	}

}
