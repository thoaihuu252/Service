package com.example.service.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Set;

public interface Order {

    public String getId();
    public String getNameOrder();

    public String getPhoneOrder() ;
    public int getPriceOrder() ;

    public String getStatus() ;
    public int getShip() ;

    public String getAreaOrder();
}
