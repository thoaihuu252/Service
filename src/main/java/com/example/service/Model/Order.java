package com.example.service.Model;

import java.util.ArrayList;

public class Order {
    private String id;
    private String nameOrder;
    private String phoneOrder;
    private int priceOrder;
    private String areaOrder;
    private String status;
    private int ship;
    private ArrayList<Product> productList;

    public Order(String id, String nameOrder, String phoneOrder, int priceOrder, String areaOrder, String status, int ship, ArrayList<Product> productList) {
        this.id = id;
        this.nameOrder = nameOrder;
        this.phoneOrder = phoneOrder;
        this.priceOrder = priceOrder;
        this.areaOrder = areaOrder;
        this.status = status;
        this.ship = ship;
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getPhoneOrder() {
        return phoneOrder;
    }

    public void setPhoneOrder(String phoneOrder) {
        this.phoneOrder = phoneOrder;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }

    public String getAreaOrder() {
        return areaOrder;
    }

    public void setAreaOrder(String areaOrder) {
        this.areaOrder = areaOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShip() {
        return ship;
    }

    public void setShip(int ship) {
        this.ship = ship;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
