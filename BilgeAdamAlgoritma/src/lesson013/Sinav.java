package lesson013;

import java.util.Iterator;
import java.util.Scanner;

public class Sinav {

	private int maxPuan;
	private int sure;
	private int soruSayisi;
	private String ders;
	private String konu;
	private Soru[] sorular;
	private String[] cevapSecenekleri = { "A", "B", "C", "D" };
	private String[] cevaplar;
	private int dogruSayisi = 0;
	private int yanlisSayisi = 0;
	private int puan = 0;
	

	public Sinav() {

	}

	public int getMaxPuan() {
		return maxPuan;
	}

	public void setMaxPuan(int maxPuan) {
		this.maxPuan = maxPuan;
	}

	public int getSure() {
		return sure;
	}

	public void setSure(int sure) {
		this.sure = sure;
	}

	public int getSoruSayisi() {
		return soruSayisi;
	}

	public void setSoruSayisi(int soruSayisi) {
		this.soruSayisi = soruSayisi;
	}

	public String getDers() {
		return ders;
	}

	public void setDers(String ders) {
		this.ders = ders;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	public Soru[] getSorular() {
		return sorular;
	}

	public void setSorular(Soru[] sorular) {
		this.sorular = sorular;
	}

	public String[] getCevapSecenekleri() {
		return cevapSecenekleri;
	}

	public void setCevapSecenekleri(String[] cevapSecenekleri) {
		this.cevapSecenekleri = cevapSecenekleri;
	}

	public String[] getCevaplar() {
		return cevaplar;
	}

	public void setCevaplar(String[] cevaplar) {
		this.cevaplar = cevaplar;
	}

	public void sinavOlustur() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hangi dersin sınavı ?");
		setDers(sc.next());
		System.out.println("Sınavın Konusu ?");
		setKonu(sc.next());
		System.out.println("Sınav Süresi ?");
		setSure(sc.nextInt());
		System.out.println("Soru Sayısı kaç ?");
		int soruSayisi = sc.nextInt();
		setSoruSayisi(soruSayisi);
		sorular = new Soru[soruSayisi];

		for (int i = 0; i < sorular.length; i++) {
			Soru soru = new Soru();
			soru.soruOlustur(cevapSecenekleri);
			sorular[i] = soru;
		}
		
		
	}
	
	public void cevapGir() {
		Scanner sc = new Scanner(System.in);
		cevaplar = new String[sorular.length];
		for (int i = 0; i < sorular.length; i++) {
			System.out.println(sorular[i].getIcerik());
			for (int j = 0; j < sorular[i].getCevapIcerikleri().length; j++) {
				System.out.println(cevapSecenekleri[j]+"-) "+sorular[i].getCevapIcerikleri()[j]);
			}
			System.out.println("Lütfen cevabınızı giriniz.");
			cevaplar[i] = sc.next().toUpperCase();
		}
		
		
		
		
	}
	
	public void cevaplariKontrolEt() {
		
		for (int i = 0; i < sorular.length; i++) {
			if(cevaplar[i].equals(sorular[i].getDogruCevap())) {
				dogruSayisi++;
				puan += sorular[i].getPuan();
			}
			else {
				yanlisSayisi++;
			}
		}
		System.out.println("Dogru Cevap : "+dogruSayisi);
		System.out.println("Yanlıs Cevap : "+yanlisSayisi);
		System.out.println("Puan : "+puan);
		
		
	}
	
	
	

}
