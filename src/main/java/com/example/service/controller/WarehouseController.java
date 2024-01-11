package com.example.service.controller;

import com.example.service.Model.Product;
import com.example.service.Model.Warehouse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private ArrayList<Warehouse> warehouseList;

    public WarehouseController() {
        // Khởi tạo danh sách kho và sản phẩm mẫu
        warehouseList = new ArrayList<>();
        warehouseList.add(new Warehouse("1", "Warehouse A", "Area A", 0, new ArrayList<>()));
        warehouseList.add(new Warehouse("2", "Warehouse B", "Area B", 0, new ArrayList<>()));
        // Thêm một số sản phẩm mẫu cho mỗi kho
        warehouseList.get(0).getProductList().add(new Product("1", "Product A", 100, "Shop A","url"));
        warehouseList.get(0).getProductList().add(new Product("1", "Product A", 100, "Shop A","url"));
        warehouseList.get(1).getProductList().add(new Product("1", "Product A", 100, "Shop A","url"));
    }

    @GetMapping
    public ArrayList<Warehouse> getAllWarehouses() {
        return warehouseList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable String id) {
        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();
        return warehouse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        warehouseList.add(warehouse);
        return new ResponseEntity<>(warehouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable String id, @RequestBody Warehouse updatedWarehouse) {
        Optional<Warehouse> existingWarehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();

        if (existingWarehouse.isPresent()) {
            Warehouse warehouse = existingWarehouse.get();
            warehouse.setNameWh(updatedWarehouse.getNameWh());
            warehouse.setAreaWh(updatedWarehouse.getAreaWh());
            warehouse.setNumberOrderWh(updatedWarehouse.getNumberOrderWh());

            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable String id) {
        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();

        if (warehouse.isPresent()) {
            warehouseList.remove(warehouse.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getProductsForWarehouse(@PathVariable String id) {
        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();
        return warehouse.map(value -> new ResponseEntity<>(value.getProductList(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<Product> addProductToWarehouse(@PathVariable String id, @RequestBody Product product) {
        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();
        if (warehouse.isPresent()) {
            warehouse.get().getProductList().add(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
