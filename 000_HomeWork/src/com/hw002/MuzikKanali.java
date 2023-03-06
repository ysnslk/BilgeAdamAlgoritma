package com.hw002;

public class MuzikKanali extends Kanal {

	private String muzikTuru;

	public MuzikKanali(int kanalNo, String kanalAdi, String muzikTuru) {
		super(kanalNo, kanalAdi);
		this.muzikTuru = muzikTuru;
	}

	public String getMuzikTuru() {
		return muzikTuru;
	}

	public void setMuzikTuru(String muzikTuru) {
		this.muzikTuru = muzikTuru;
	}

}
