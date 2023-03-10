package lesson015.veteriner;

public class Kedi extends Hayvan {

	private String tur;
	private String cins;
	private String karne;

	public Kedi(String name, boolean kayitliMi, String dogumTarihi,String cins) {
		super(name, kayitliMi, dogumTarihi);
		this.tur = "Kedi";
		this.cins = cins;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getCins() {
		return cins;
	}

	public void setCins(String cins) {
		this.cins = cins;
	}

	public String getKarne() {
		return karne;
	}

	public void setKarne(String karne) {
		this.karne = karne;
	}

	@Override
	public void karneOlustur() {
		System.out.println("*******************");
		System.out.println("***Kedi Karnesi****");
		System.out.println("*******************");
		this.setKarne("Cinsi : " + this.getCins() + " Türü : " + this.getTur());
		System.out.println("Karneniz oluşturuldu =>  Cinsi : " + this.getCins() + " Türü : " + this.getTur());
	}

	@Override
	public void bilgileriGoster() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Kedi [tur=" + tur + ", cins=" + cins + ", karne=" + karne + ", getName()=" + getName()
				+ ", isKayitliMi()=" + isKayitliMi() + ", getDogumTarihi()=" + getDogumTarihi() + "]";
	}

}
