package com.example.service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "shop")
    private String shop;

    @Column(name = "image_url")
    private String imageUrl;

    public Product(String id, String name, int price, String shop, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
        this.imageUrl = imageUrl;
    }

    public Product() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getShop() {
        return shop;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shop='" + shop + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
