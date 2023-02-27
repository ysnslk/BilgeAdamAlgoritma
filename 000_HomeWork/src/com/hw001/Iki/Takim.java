package com.hw001.Iki;

public class Takim {
	private String name;
	private int puan;
	private int kasa;

	public Takim(String name, int kasa) {
		super();
		this.name = name;
		this.kasa = kasa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

	public int getKasa() {
		return kasa;
	}

	public void setKasa(int kasa) {
		this.kasa = kasa;
	}

	public void kasaGoster() {
		System.out.println("Takım : " + this.name + " Takım Kasası : " + this.kasa);
	}

	

}
