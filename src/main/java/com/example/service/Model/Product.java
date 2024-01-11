package com.example.service.Model;

public class Product {
    private String id;
    private String name;
    private int price;
    private String shop;
    private String imageUrl;


    public Product(String id, String name, int price, String shop,String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
        this.imageUrl = imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }


}
