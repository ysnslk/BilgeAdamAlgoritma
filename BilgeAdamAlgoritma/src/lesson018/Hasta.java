package lesson018;

public class Hasta implements Comparable<Hasta> {
	private String isim;
	private String sikayet2;
	private ESikayet sikayet;
	private int oncelik;

	public Hasta(String isim, String sikayet2) {
		super();
		this.isim = isim;
		this.sikayet2 = sikayet2;
		oncelikBelirle(sikayet2);
//		this.oncelik = sikayet.equalsIgnoreCase("Apandist") ? 1 :
//			sikayet.equalsIgnoreCase("Yanık") ? 2 :
//				sikayet.equalsIgnoreCase("Apandist") ? 3 : 4;

	}

	public Hasta(String isim, ESikayet sikayet) {
		super();
		this.isim = isim;
		this.sikayet = sikayet;
		oncelikBelirleEnum(sikayet);
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
	//Illegal Argument
	public void oncelikBelirleEnum(ESikayet sikayet) {
		switch (sikayet) {
		case APANDIST:
			this.oncelik = 1;
			break;
		case YANIK:
			this.oncelik = 2;
			break;

		case AGRI:
			this.oncelik = 3;
			break;

		default:
			throw new IllegalArgumentException("Beklenmedik değer girdisi oldu");
		}
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getOncelik() {
		return oncelik;
	}

	public void setOncelik(int oncelik) {
		this.oncelik = oncelik;
	}

	public String getSikayet2() {
		return sikayet2;
	}

	public void setSikayet2(String sikayet2) {
		this.sikayet2 = sikayet2;
	}

	public ESikayet getSikayet() {
		return sikayet;
	}

	public void setSikayet(ESikayet sikayet) {
		this.sikayet = sikayet;
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
