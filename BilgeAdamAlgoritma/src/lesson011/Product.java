package lesson011;

import lesson011.helper.RandomGenerateID;

public class Product {
	private String id;
	private int price;
	private String name;
	private int stock;
	private boolean isActive=true;

	// Overloading
	public Product() {
		// Bir sınıftan nesne ürettiğimizde arka tarafta çalışan ilk metodtur
		System.out.println("Product sınıfının 0 parametreli constructor u çalıştı");
		this.id = RandomGenerateID.generateID();
	}

	public Product(int price, String name, int stock) {
		System.out.println("Product sınıfının 4 parametreli constructor u çalıştı");
		this.setPrice(price);
		this.id = RandomGenerateID.generateID();
		this.name = name;
		this.stock = stock;

	}

	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			System.out.println("0 dan büyük bir değer girin");
			this.price = 0;
		} else {
			this.price = price;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void bilgilerGoster() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Price :" + price + ", Name :" + name + ", Stock :" + stock;
	}

	public String veritabanınaKaydet() {
		return this.name + " Ürün veritabanına kaydedildi";
	}

	public void ismiGuncelle(String name) {
		setName(name);
		System.out.println("İsim başarıyla güncellendi");
	}
	
	public void gosterimdenKaldir(Product product) {
		if(product.getStock() <= 0) {
			setActive(false);
			System.out.println(product.getName()+" Gösterimden kaldırıldı");
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
