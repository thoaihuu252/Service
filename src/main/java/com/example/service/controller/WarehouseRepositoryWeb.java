package com.example.service.controller;
import com.example.service.Model.Warehousee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepositoryWeb extends JpaRepository<Warehousee,String> {

}
