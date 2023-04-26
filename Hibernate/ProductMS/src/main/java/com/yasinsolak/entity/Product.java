package com.yasinsolak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_prodcuts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @ManyToMany
    @JoinTable(name = "products_customers",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;
    @OneToMany(mappedBy = "product")
    private List<ProductDetails> productDetails;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }

    public Product(Long id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
