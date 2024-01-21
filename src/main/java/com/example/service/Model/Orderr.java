package com.example.service.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "orderr")
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name_order")
    private String nameOrder;

    @Column(name = "phone_order")
    private String phoneOrder;

    @Column(name = "price_order")
    private int priceOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "ship")
    private int ship;

    @Column(name = "area_order")
    private String areaOrder;

    // Các phương thức getter và setter cho các thuộc tính
    // ...

    // Quan hệ nhiều-nhiều với bảng product
    @ManyToMany
    @JoinTable(
            name = "product_orderr",
            joinColumns = @JoinColumn(name = "orderr_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    // Quan hệ nhiều-một với bảng userdb
    @ManyToOne
    @JoinColumn(name = "userdb_id")
    private Userdbb user;

    // Quan hệ nhiều-một với bảng warehouse
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehousee warehouse;

    public Orderr() {
    }

    public Orderr(String id, String nameOrder, String phoneOrder, int priceOrder, String status, int ship, String areaOrder) {
        this.id = id;
        this.nameOrder = nameOrder;
        this.phoneOrder = phoneOrder;
        this.priceOrder = priceOrder;
        this.status = status;
        this.ship = ship;
        this.areaOrder = areaOrder;
    }


    @Override
    public String toString() {
        return "Orderr{" +
                "id='" + id + '\'' +
                ", nameOrder='" + nameOrder + '\'' +
                ", phoneOrder='" + phoneOrder + '\'' +
                ", priceOrder=" + priceOrder +
                ", status='" + status + '\'' +
                ", ship=" + ship +
                ", areaOrder='" + areaOrder + '\'' +
                '}';
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

    public String getAreaOrder() {
        return areaOrder;
    }

    public void setAreaOrder(String areaOrder) {
        this.areaOrder = areaOrder;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Userdbb getUser() {
        return user;
    }

    public void setUser(Userdbb user) {
        this.user = user;
    }

    public Warehousee getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehousee warehouse) {
        this.warehouse = warehouse;
    }

}