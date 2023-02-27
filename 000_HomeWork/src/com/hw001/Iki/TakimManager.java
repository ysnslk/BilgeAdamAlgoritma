package com.hw001.Iki;

import java.util.Iterator;
import java.util.Random;

public class TakimManager {

	private Takim[] takimlar = new Takim[2];
	private static int index = 0;

	public Takim[] getTakimlar() {
		return takimlar;
	}

	public void setTakimlar(Takim[] takimlar) {
		this.takimlar = takimlar;
	}

	public void takimEkle(Takim takim) {
		this.takimlar[index] = takim;
		index++;
		System.out.println(takim.getName() + " Başarıyla Eklendi...!");
	}

	public void iflasEtmeDurumun() {
		for (int i = 0; i < takimlar.length; i++) {
			if (takimlar[i].getKasa() < 5000) {
				System.out.println("Takım Adı : " + takimlar[i].getName() + " Kasa : " + takimlar[i].getKasa());
			}
		}
	}

	public void puanDurumu() {
		for (Takim takim : takimlar) {
			System.out.println("Takım : " + takim.getName() + " Puan : " + takim.getPuan());
		}
	}

	public void sampiyonuBelirt() {
		int sampiyon = 0;
		String sampiyonTakim = "";
		for (int i = 0; i < takimlar.length; i++) {
			if (takimlar[i].getPuan() > sampiyon) {
				sampiyon = takimlar[i].getPuan();
				sampiyonTakim = takimlar[i].getName();
			}
		}
		System.out.println("Şampiyonnnnn !!!!! " + sampiyonTakim);
	}

	public void macYap(Takim takim1, Takim takim2) {
		int galibiyet = 3;
		int galibiyetPrimi = 10000;
		int berabere = 1;
		int beraberePrimi = 10000;
		Random rnd = new Random();
		int rndSayi = rnd.nextInt(1, 4);
		switch (rndSayi) {
		case 1:
			takim1.setPuan(takim1.getPuan() + galibiyet);
			takim1.setKasa(takim1.getKasa() + galibiyetPrimi);
			System.out.println(takim1.getName() + " Maçı kazanmıştır...!");
			break;
		case 2:
			takim2.setPuan(takim2.getPuan() + galibiyet);
			takim2.setKasa(takim2.getKasa() + galibiyetPrimi);
			System.out.println(takim2.getName() + " Maçı kazanmıştır...!");
			break;
		case 3:
			takim1.setPuan(takim1.getPuan() + berabere);
			takim1.setKasa(takim1.getKasa() + beraberePrimi);
			takim2.setPuan(takim2.getPuan() + berabere);
			takim2.setKasa(takim2.getKasa() + beraberePrimi);
			System.out.println("Maç beraber bitmiştir...!");
			break;

		default:
			System.err.println("HATA");
			break;
		}
	}

}
