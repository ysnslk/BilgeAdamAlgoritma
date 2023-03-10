package lesson012;

public class Pizza {

	private int price;
	private boolean isVeg;
	private static final int normalFiyat = 200;
	private static final int vegiFiyat = 300;
	private static final int sosFiyat = 50;
	private static final int peynirFiyat = 100;
	private static final int kuryeFiyat = 20;

	public Pizza() {

	}

	public Pizza(boolean isVeg) {
		this.isVeg = isVeg;
		if (this.isVeg) {
			this.setPrice(vegiFiyat);
		} else {
			this.setPrice(normalFiyat);
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setIsVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public void sosEkle() {
		System.out.println("Sos Eklendi : " + sosFiyat);
		setPrice(getPrice() + sosFiyat);
	}

	public void sosCikar() {
		System.out.println("Sos Çıkartıldı : -" + sosFiyat);
		setPrice(getPrice() - sosFiyat);
	}

	public void peynirEkle() {
		System.out.println("Peynir Eklendi : " + peynirFiyat);
		setPrice(getPrice() + peynirFiyat);
	}

	public void peynirCikar() {
		System.out.println("Peynir Çıkartıldı : -" + peynirFiyat);
		setPrice(getPrice() - peynirFiyat);
	}

	public void eveSiparisVer() {
		setPrice(getPrice() + kuryeFiyat);
	}

	public void fisAl() {
		System.out.println("Toplam Ücret Ödemeniz : " + getPrice());
	}

}
