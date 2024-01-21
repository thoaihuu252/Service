package com.example.service.controller;

import com.example.service.Model.Order;
import com.example.service.Model.Orderr;
import com.example.service.Model.Product;
import com.example.service.Service.OrderSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class OrderControllerrWeb {

    @Autowired
    private OrderSv OrderService;

    // Method to handle GET request at /products and return a list of all products
    @GetMapping("/orders")
    public List<Orderr> getAllOrder() {
        return OrderService.getAllOrder();
    }
    @GetMapping("/ordersNWU")
    public List<Order> getAllOrderNWU() {
        return OrderService.getAllOrderNWU();
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orderr> getOrderById(@PathVariable String id) {
        Optional<Orderr> order = OrderService.getAllOrderbyID(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update-status-order/{id}")
    public ResponseEntity<Orderr> updateOrderStatus(@PathVariable String id, @RequestParam String newStatus) {
        try {
            Orderr updatedOrder = OrderService.updateOrderStatus(id, newStatus);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        try {
            OrderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{orderId}/products")
    public ResponseEntity<Set<Product>> getAllProductsFromOrder(@PathVariable String orderId) {
        try {
            Set<Product> products = OrderService.getAllProductsFromOrder(orderId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{orderId}/add-product")
    public ResponseEntity<Orderr> addProductToOrder(@PathVariable String orderId, @RequestBody Product product) {
        try {
            Orderr updatedOrder = OrderService.addProductToOrder(orderId, product);
            return new ResponseEntity<>(updatedOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
