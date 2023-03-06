package lesson020;

import java.util.List;

public class Main {
	
	static List<Integer> list;

	public static void main(String[] args) {
		
		try {
			list.add(2);
		} catch (NullPointerException e) {
			
		}
		System.out.println("Bu satır çalışıyor mu?");
		System.out.println(Util.tarihAl("Tarih gir"));
	}
}
