package com.example.service.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "warehouse")
public class Warehousee {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name_wh")
    private String nameWh;

    @Column(name = "area_wh")
    private String areaWh;

    @Column(name = "number_order_wh")
    private int numberOrderWh;



    // Quan hệ một-nhiều với bảng orderr
    @OneToMany(mappedBy = "warehouse")
    private Set<Orderr> orders;

    public Warehousee() {
    }

    @Override
    public String toString() {
        return "Warehousee{" +
                "id='" + id + '\'' +
                ", nameWh='" + nameWh + '\'' +
                ", areaWh='" + areaWh + '\'' +
                ", numberOrderWh=" + numberOrderWh +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameWh() {
        return nameWh;
    }

    public void setNameWh(String nameWh) {
        this.nameWh = nameWh;
    }

    public String getAreaWh() {
        return areaWh;
    }

    public void setAreaWh(String areaWh) {
        this.areaWh = areaWh;
    }

    public int getNumberOrderWh() {
        return numberOrderWh;
    }

    public void setNumberOrderWh(int numberOrderWh) {
        this.numberOrderWh = numberOrderWh;
    }

//    public Set<Orderr> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Orderr> orders) {
//        this.orders = orders;
//    }

    public Warehousee(String id, String nameWh, String areaWh, int numberOrderWh) {
        this.id = id;
        this.nameWh = nameWh;
        this.areaWh = areaWh;
        this.numberOrderWh = numberOrderWh;
    }
}