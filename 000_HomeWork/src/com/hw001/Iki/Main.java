package com.hw001.Iki;

public class Main {

	public static void main(String[] args) {

		TakimManager takimManager = new TakimManager();
		Takim t1 = new Takim("Barcelona", 100);
		Takim t2 = new Takim("Real Madrid", 100);
		System.out.println("\n-- Kasa Göster --\n");
		t1.kasaGoster();

		System.out.println("\n-- Maç Yap --\n");
		takimManager.macYap(t1, t2);

		System.out.println("\n-- Takıma Ekle --\n");
		takimManager.takimEkle(t1);
		takimManager.takimEkle(t2);

		System.out.println("\n-- Pun Durumu --\n");
		takimManager.puanDurumu();

		System.out.println("\n-- İflas Durumu --\n");

		takimManager.iflasEtmeDurumun();

		System.out.println("\n-- Şampiyon Takım --\n");

		takimManager.sampiyonuBelirt();
	}

}
