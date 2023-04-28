package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Category;
import com.yasinsolak.entity.Customer;
import com.yasinsolak.entity.Product;
import com.yasinsolak.service.CategoryService;
import com.yasinsolak.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    public ProductController(){
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    public void save(){
        String productName = BAUtils.readString("Product Name : ");
        double price = BAUtils.readDouble("Product Price : ");
        int stock = BAUtils.readInt("Product Stock : ");
        long categoryId = BAUtils.readInt("Category Id : ");
        Optional<Category> optionalCategory = categoryService.findById(categoryId);
        if(optionalCategory.isPresent()) {
            Product product = new Product();
            product.setName(productName);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategory(optionalCategory.get());
            productService.save(product);
        }else {
            System.out.println("Böyle bir kategori bulunmamaktardır...!");
        }

    }

    public void findAll(){
        List<Product> pList = productService.findAll();
        pList.forEach(System.out::println);
    }

    public void buyProduct(Customer customer) {
        long id = BAUtils.readInt("Almak istediğiniz sayıyı girin");
        int amount = BAUtils.readInt("Kaç adet almak istersin ?");
        Product product;
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isEmpty()){
            System.out.println("Ürün bulunamadı");
        }else{
            product = optionalProduct.get();
            if(product.getStock() >= amount){
                product.getCustomers().add(customer);
                product.setStock(product.getStock()-amount);
                productService.update(product);
                System.out.println("Ürün başarı ile alınmıştır");
            }else{
                System.out.println("Stokta sadece "+product.getStock()+" adet ürün kalmıştır");
            }
        }
    }

    public void findProductStockLessThenTen() {
        List<Product> products = productService.findAll().stream().filter(x-> x.getStock()<10).toList();
        products.forEach(x-> System.out.println(x.getName()+" Stok Miktarı : "+x.getStock()));
    }
}
