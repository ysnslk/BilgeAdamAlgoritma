package lesson018;

public class Hasta implements Comparable<Hasta> {
	private String isim;
	private String sikayet;
	private int oncelik;

	public Hasta(String isim, String sikayet) {
		super();
		this.isim = isim;
		this.sikayet = sikayet;
		oncelikBelirle(sikayet);
//		this.oncelik = sikayet.equalsIgnoreCase("Apandist") ? 1 :
//			sikayet.equalsIgnoreCase("Yanık") ? 2 :
//				sikayet.equalsIgnoreCase("Apandist") ? 3 : 4;

	}

	public void oncelikBelirle(String sikayet) {
		if (sikayet.equalsIgnoreCase("Apandist")) {
			this.oncelik = 1;
		} else if (sikayet.equalsIgnoreCase("Yanık")) {
			this.oncelik = 2;
		} else {
			this.oncelik = 3;
		}
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSikayet() {
		return sikayet;
	}

	public void setSikayet(String sikayet) {
		this.sikayet = sikayet;
	}

	public int getOncelik() {
		return oncelik;
	}

	public void setOncelik(int oncelik) {
		this.oncelik = oncelik;
	}

	@Override
	public int compareTo(Hasta hasta) {
		if (this.oncelik > hasta.getOncelik()) {
			return 1;
		} else if (this.oncelik < hasta.getOncelik()) {
			return -1;
		} else {
			return 0;
		}
	}

	/*
	 * Array Arraylist farkı / ArrayList LinkedArraylist Hashmap Linked Hasmap farkı
	 * arka tarafta nasıl çalışıyora Setler neden kullanılır , avantajları neler ?
	 * 
	 */

}
