package com.example.service.controller;

import com.example.service.Model.Product;
import com.example.service.Model.Warehouse;
import com.example.service.Model.Warehousee;
import com.example.service.Service.ProductSv;
import com.example.service.Service.WarehouseSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class WarehouseControllerrWeb {

    @Autowired
    private WarehouseSv warehouseService;

    // Method to handle GET request at /products and return a list of all products
    @GetMapping("/warehouses")
    public List<Warehousee> getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }
//    @GetMapping("/{warehouseId}/products")
//    public ResponseEntity<Set<Product>> getProductsForWarehouse(@PathVariable String warehouseId) {
//        try {
//            Set<Product> products = warehouseService.getProductsForWarehouse(warehouseId);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
