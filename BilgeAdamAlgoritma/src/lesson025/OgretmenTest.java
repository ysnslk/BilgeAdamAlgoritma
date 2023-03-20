package lesson025;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OgretmenTest {
	public static void main(String[] args) {

		File file = new File("ogrenci.txt");
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Ogretmen ogretmen1 = new Ogretmen("Ahmet", bufferedReader);
		Ogretmen ogretmen2 = new Ogretmen("Ali", bufferedReader);

		// Thread t1 =new Thread(ogretmen1);
		// Thread t2 =new Thread(ogretmen2);

		ogretmen1.start();
		ogretmen2.start();
		
		try {
			ogretmen1.join();
			ogretmen2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println(ogretmen1.notuOkunanlar.size());
		System.out.println(ogretmen2.notuOkunanlar.size());
		
		//ilk 9 öğrenciye 1 bi öğretmen baksın

	}
}