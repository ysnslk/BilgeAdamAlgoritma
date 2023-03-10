package lesson011;

import java.util.Iterator;

public class Sepet {
	private Product[] products;
	private int totalPrice;
	private static int index = 0;

	public Sepet() {
		this.products = new Product[10];
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getIndex() {
		return index;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void sepeteEkle(Product product) {
		if (product.getStock() > 0) {
			if (index >= 10) {
				System.out.println("Sınır Aşıldı yer yok");
			} else {
				products[index] = product;
				index++;
				totalPrice += product.getPrice();
				int stockValue = product.getStock() - 1;
				product.setStock(stockValue);
				product.gosterimdenKaldir(product);

			}
		} else {
			System.out.println("Ürün stoku bitmiştir.");
		}

	}

	// Her ürün eklendiğinde totalPRice artacak
	// Her ürün deklediğimde product 'ın stoğu azalması lazm.
	// 10 taneden fazla ürün alamasın.

	// product sınıfının içinde bir değişekn tutalım
	// Ürün aktif mi pasif mi ?

	// product sınıfının içine metot yazalım
	// aktif olan ürünü gösterimden kaldırsın

	// Sepetteki ürünleri göster

	public void getProductsManual() {
		for (int i = 0; i < this.products.length; i++) {
			if (products[i] != null) {
				System.out.println((i + 1) + " - Ürün " + this.products[i].getName());
			}
		}
	}

}
