package lesson013;

import java.util.Scanner;

public class Soru {

	private int puan;
	private String icerik;
	private String dogruCevap;
	private String[] cevapIcerikleri; // Aşıkkı Bşıkkı

	public Soru() {

	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public String getDogruCevap() {
		return dogruCevap;
	}

	public void setDogruCevap(String dogruCevap) {
		this.dogruCevap = dogruCevap;
	}

	public String[] getCevapIcerikleri() {
		return cevapIcerikleri;
	}

	public void setCevapIcerikleri(String[] cevapIcerikleri) {
		this.cevapIcerikleri = cevapIcerikleri;
	}

	public void soruOlustur(String[] cevapSecenekleri) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen Sorunun İçeriğini Giriniz");
		icerik = sc.next();
		cevapIcerikleri = new String[cevapSecenekleri.length];
		for (int i = 0; i < cevapIcerikleri.length; i++) {
			System.out.println("Sorunun " + cevapSecenekleri[i] + " Şıkkını Giriniz.");
			cevapIcerikleri[i] = sc.next();
		}
		System.out.println("Soru kaç puan ?");
		setPuan(sc.nextInt());
		System.out.println("Lütfen doğru şıkkı seçiniz");
		dogruCevap = sc.next();
	}

}
