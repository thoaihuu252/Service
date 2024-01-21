package com.example.service.controller;


import com.example.service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryWeb extends JpaRepository<Product,String> {

}