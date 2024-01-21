package com.example.service.Service;
import com.example.service.Model.Product;
import com.example.service.Model.Warehousee;
import com.example.service.controller.WarehouseRepositoryWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WarehouseSv {
    @Autowired
    WarehouseRepositoryWeb warehouseRepositoryWeb;
    public List<Warehousee> getAllWarehouse() {
        return warehouseRepositoryWeb.findAll();
    }
    public Optional<Warehousee> getAllWarehousebyID(String id) {
        return warehouseRepositoryWeb.findById(id);
    }

//    public Set<Product> getProductsForWarehouse(String warehouseId) {
//        Warehousee existingWarehouse = warehouseRepositoryWeb.findById(warehouseId).orElse(null);
//
//        if (existingWarehouse == null) {
//            throw new IllegalArgumentException("Kho không tồn tại.");
//        }
//
//        return existingWarehouse.getProducts();
//    }
}
