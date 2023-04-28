package com.yasinsolak.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_productdetails")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int puan;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    public ProductDetails(Long id, String comment, int puan) {
        this.id = id;
        this.comment = comment;
        this.puan = puan;
    }

    public ProductDetails(String comment, int puan) {
        this.comment = comment;
        this.puan = puan;
    }

    public ProductDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
