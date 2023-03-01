package lesson016;

public class Kitap {

	private String isim;
	private String yazar;
	private int fiyat;
	private boolean indirimliMi;

	public Kitap() {

	}

	public Kitap(String isim, String yazar, int fiyat) {
		super();
		this.isim = isim;
		this.yazar = yazar;
		this.fiyat = fiyat;
		this.indirimliMi = false;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public boolean isIndirimliMi() {
		return indirimliMi;
	}

	public void setIndirimliMi(boolean indirimliMi) {
		this.indirimliMi = indirimliMi;
	}

}
