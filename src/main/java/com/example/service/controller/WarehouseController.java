package com.example.service.controller;

import com.example.service.Model.Orderr;
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


        // Thêm một số sản phẩm mẫu cho mỗi kho
        Orderr order1 = new Orderr("1", "Order A", "123456789", 100, "Pending",  10,"Arrea A");
        Orderr order2 = new Orderr("2", "Order B", "987654321", 150, "Pending", 20,"Area B");
        var orders = new ArrayList<Orderr>();
        orders.add(order1);
        orders.add(order2);

        // Tạo đối tượng Warehouse với danh sách đơn hàng
        warehouseList.add(new Warehouse("2", "Warehouse B", "Area B", 0, orders));
        warehouseList.add(new Warehouse("1", "Warehouse A", "Area A", 0, orders));

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

//    @GetMapping("/{id}/products")
//    public ResponseEntity<List<Product>> getProductsForWarehouse(@PathVariable String id) {
//        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();
//        return warehouse.map(value -> new ResponseEntity<>(value.getProductList(), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

//    @PostMapping("/{id}/products")
//    public ResponseEntity<Product> addProductToWarehouse(@PathVariable String id, @RequestBody Product product) {
//        Optional<Warehouse> warehouse = warehouseList.stream().filter(w -> w.getId().equals(id)).findFirst();
//        if (warehouse.isPresent()) {
//            warehouse.get().getProductList().add(product);
//            return new ResponseEntity<>(product, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
