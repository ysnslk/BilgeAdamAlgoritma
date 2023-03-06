package com.hw002;

import java.util.ArrayList;

public class Televizyon {

	private String marka;
	private String boyut;
	private ArrayList<Kanal> kanallar;
	private int sesSeviyesi = 0;
	private Kanal mevcutKanal;

	MainTV m = new MainTV();

	public Televizyon(String marka, String boyut) {
		super();
		this.marka = marka;
		this.boyut = boyut;
		this.kanallar = new ArrayList<Kanal>();
	}

	public void kanallarıOlustur() {
		Kanal nTv = new HaberKanali(1, "NTV", "Borsa");
		Kanal bein = new HaberKanali(2, "Bein Sports", "Spor");
		Kanal show = new HaberKanali(3, "Show TV", "Magazin");
		Kanal kral = new MuzikKanali(4, "Kral POP", "Müzik");
		Televizyon tv = new Televizyon("LG", "14Inch");
		kanallar.add(nTv);
		kanallar.add(bein);
		kanallar.add(show);
		kanallar.add(kral);

	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getBoyut() {
		return boyut;
	}

	public void setBoyut(String boyut) {
		this.boyut = boyut;
	}

	public ArrayList<Kanal> getKanallar() {
		return kanallar;
	}

	public void setKanallar(ArrayList<Kanal> kanallar) {
		this.kanallar = kanallar;
	}

	public int getSesSeviyesi() {
		return sesSeviyesi;
	}

	public void setSesSeviyesi(int sesSeviyesi) {
		this.sesSeviyesi = sesSeviyesi;
	}

	public Kanal getMevcutKanal() {
		return mevcutKanal;
	}

	public void setMevcutKanal(Kanal mevcutKanal) {
		this.mevcutKanal = mevcutKanal;
	}

	public void sesArttir() {
		if (m.tv != null || m.tvStatus) {
			if (this.sesSeviyesi >= 10) {
				System.out.println("Minimum sesi seviyesindesiniz...!");
				System.out.println("Mevcut ses : " + this.sesSeviyesi);
			} else {
				this.sesSeviyesi++;
				System.out.println("Ses Arttırıldı.\nSes seviyesi : " + this.sesSeviyesi);
			}
		} else {
			System.out.println("Lütfen ilk önce televizyonu kurun ve ya televizyonu açın...!");
		}
	}

	public void sesAzalt() {
		if (m.tv != null || m.tvStatus) {
			if (this.sesSeviyesi <= 0) {
				System.out.println("Maksimum ses seviyesindesiniz...!");
				System.out.println("Mevcut ses : " + this.sesSeviyesi);
			} else {
				this.sesSeviyesi--;
				System.out.println("Ses azaltıldı.\nSes seviyesi : " + this.sesSeviyesi);
			}
		} else {
			System.out.println("Lütfen ilk önce televizyonu kurun ve ya televizyonu açın...!");
		}
	}

	public void kanalDegistir(int kanalNo) {
		if (m.tv != null || m.tvStatus) {
			if (this.getMevcutKanal().getKanalNo() == --kanalNo) {
				System.out.println(
						"Zaten gitmek istediğiniz kanaldasınız ( " + this.getMevcutKanal().getKanalAdi() + " )");
			} else {
				Kanal kanal = kanallar.get(--kanalNo);
				this.setMevcutKanal(kanal);
				System.out.println("Mevcut kanal :" + kanal.getKanalAdi());
			}
		} else {
			System.out.println("Lütfen ilk önce televizyonu kurun ve ya televizyonu açın...!");
		}

	}

	public void kanalListele() {
		if (m.tv != null || m.tvStatus) {
			if (kanallar.size() > 0) {
				for (Kanal kanal : kanallar) {
					System.out.println("Kanal No : " + kanal.getKanalNo() + " Kanal Adı : " + kanal.getKanalAdi());
				}
			} else {
				System.out.println("Kanal bulunamadı.");
			}
		} else {
			System.out.println("Lütfen ilk önce televizyonu kurun ve ya televizyonu açın...!");
		}
	}

	public void kanalBilgiGoster() {
		if (m.tv != null || m.tvStatus) {
			System.out.println("Mevcut Kanal Bilgisi");
			System.out.println("Kanal No : " + this.getMevcutKanal().getKanalNo() + " Kanal "
					+ this.getMevcutKanal().getKanalAdi());
		} else {
			System.out.println("Lütfen ilk önce televizyonu kurun ve ya televizyonu açın...!");
		}
	}

}
