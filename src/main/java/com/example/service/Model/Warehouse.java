package com.example.service.Model;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String id;
    private String nameWh; //Warehouse - wh
    private String areaWh;
    private int numberOrderWh;
    private ArrayList<Orderr> productList;


    public Warehouse(String id, String nameWh, String areaWh, int numberOrderWh, ArrayList<Orderr> productList) {
        this.id = id;
        this.nameWh = nameWh;
        this.areaWh = areaWh;
        this.numberOrderWh = numberOrderWh;
        this.productList = productList;
    }

    public List<Orderr> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Orderr> productList) {
        this.productList = productList;
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
}
