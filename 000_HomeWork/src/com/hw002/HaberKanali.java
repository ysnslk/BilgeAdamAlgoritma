package com.hw002;

public class HaberKanali extends Kanal {

	private String haberTuru;

	public HaberKanali(int kanalNo, String kanalAdi, String haberTuru) {
		super(kanalNo, kanalAdi);
		this.haberTuru = haberTuru;
	}

	public String getHaberTuru() {
		return haberTuru;
	}

	public void setHaberTuru(String haberTuru) {
		this.haberTuru = haberTuru;
	}

}
