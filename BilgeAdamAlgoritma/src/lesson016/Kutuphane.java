package lesson016;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kutuphane implements IKutuphaneManager {
	private String isim;
	private List<Kitap> kitaplar;

	public Kutuphane(String isim) {
		super();
		this.isim = isim;
		this.kitaplar = new ArrayList<Kitap>();
		System.out.println("Kütüphane oluştu");
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public List<Kitap> getKitaplar() {
		return kitaplar;
	}

	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}

	@Override
	public void kitapEkle() {

		String isim = Util.StringDegerAl("Lütfen Kitap Adını Girin.");
		String yazar = Util.StringDegerAl("Lütfen Kitap Yazarını Girin.");
		int fiyat = Util.intDegerAl("Lütfen Kitap Fiyatını Girin.");
		Kitap kitap = new Kitap(isim, yazar, fiyat);
		kitaplar.add(kitap);
		System.out.println("Kitap Eklendi");
	}

	@Override
	public void kitaplariListele() {
		if (kitaplar.size() > 0) {
			for (Kitap kitap : kitaplar) {
				System.out.println("Kitap Adı : " + kitap.getIsim() + " Fiyatı : " + kitap.getFiyat());
			}
		} else {
			System.err.println("Lütfen İlk Önce Kütüphaneye Kitap Ekleyin!!!!!\n");
		}

	}

	@Override
	public void yazarIleArama() {
		String yazar = Util.StringDegerAl("Kitaplarını aramak istediğiniz yazarı giriniz.");
		for (Kitap kitap : kitaplar) {
			if (kitap.getYazar().equalsIgnoreCase(yazar)) {
				System.out.println(kitap.getIsim());
			}

		}
	}

	@Override
	public void kitapSil() {
		String isim = Util.StringDegerAl("Silmek istediğiniz kitabın ismini girin : ");
		Kitap kitap = kontrol(isim);
		if (kitap != null) {
			kitaplar.remove(kitap);
			System.out.println("Başarıyla Silindi");
		}
	}

	@Override
	public void indirimYap() {
		String isim = Util.StringDegerAl("Lütfen indirim almak istediğiniz kitabın ismini girin : ");
		int indirim = Util.intDegerAl("Lütfen istediğiniz indirimi girin.");
		Kitap kitap = kontrol(isim);
		if (kitap != null) {
			kitap.setFiyat(kitap.getFiyat() - indirim);
			kitap.setIndirimliMi(true);
			System.out.println("Güncel Fiyat ---> " + kitap.getFiyat());
		}
	}

	private Kitap kontrol(String name) {
		for (int i = 0; i < kitaplar.size(); i++) {
			if (kitaplar.get(i).getIsim().equalsIgnoreCase(name)) {
				return kitaplar.get(i);
			}
		}
		System.out.println("Kitap bulunamamıştır.");
		return null;
	}

	@Override
	public void kitabıGuncelle() {
		String isim = Util.StringDegerAl("Lütfen güncellemek istediğiniz kitabın adını girin : ");
		Kitap kitap = kontrol(isim);
		if (kitap != null) {
			String guncelIsim = Util.StringDegerAl("Güncellemek istediğiniz adı girin : ");
			kitap.setIsim(guncelIsim);
			System.out.println("Kitap ismi güncellendi ---> " + kitap.getIsim());
		}
	}

	@Override
	public void indirimdekiKitaplariListele() {
		if (kitaplar.size() > 0) {
			for (Kitap kitap : kitaplar) {
				if (kitap.isIndirimliMi()) {
					System.out.println("Kitap Adı : " + kitap.getIsim() + " Fiyatı : " + kitap.getFiyat());
				}
				
			}
		} else {
			System.err.println("Lütfen İlk Önce Kütüphaneye Kitap Ekleyin!!!!!\n");
		}
		
	}

}
