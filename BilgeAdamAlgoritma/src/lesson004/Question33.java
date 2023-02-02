package lesson004;

import java.util.Scanner;

public class Question33 {

	public static void main(String[] args) {
		// Klavyeden girilen 0 ile 100 arasından 5 adet  sayıdan 
		//en büyük ve en küçük olanı bulan program.
		Scanner sc = new Scanner(System.in);
		int i=0, enb=-1,enk=101,num;
		while(i<5) {
			System.out.println((i+1)+". Sayıyı giriniz");
			num = sc.nextInt();
			if(num<=100 && num>=0) {
				if(num> enb) {
					enb = num;
				}
				if(num < enk) {
					enk=num;
				}
				i++;
			}
			else {
				System.out.println("Geçerli Sayıları Girin\n");
			}
		}
		System.out.println("Max : "+enb);
		System.out.println("Min : "+enk);
		
		
		
		
		
		
		
		
	}

}
