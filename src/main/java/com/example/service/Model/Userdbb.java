package com.example.service.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "userdb")
public class Userdbb {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "url_avt")
    private String urlAvt;

    @Column(name = "tottal")
    private int tottal;

    // Các phương thức getter và setter cho các thuộc tính
    // ...

    // Quan hệ một-nhiều với bảng orderr

    public Userdbb() {
    }

    public Userdbb(String id, String name, String password, String email, String urlAvt, int tottal) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.urlAvt = urlAvt;
        this.tottal = tottal;
    }

    @Override
    public String toString() {
        return "Userdbb{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", urlAvt='" + urlAvt + '\'' +
                ", tottal=" + tottal +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlAvt() {
        return urlAvt;
    }

    public void setUrlAvt(String urlAvt) {
        this.urlAvt = urlAvt;
    }

    public int getTottal() {
        return tottal;
    }

    public void setTottal(int tottal) {
        this.tottal = tottal;
    }

//    public Set<Orderr> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Orderr> orders) {
//        this.orders = orders;
//    }
}