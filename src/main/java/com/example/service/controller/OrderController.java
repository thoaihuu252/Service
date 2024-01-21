//package com.example.service.controller;
//import com.example.service.Model.Order;
//import com.example.service.Model.Product;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    private ArrayList<Order> orderList;
//
//    public OrderController() {
//        // Khởi tạo danh sách đơn hàng và sản phẩm mẫu
//
//    }
//
//    @GetMapping
//    public ArrayList<Order> getAllOrders() {
//        return orderList;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
//        Optional<Order> order = orderList.stream().filter(o -> o.getId().equals(id)).findFirst();
//        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//        orderList.add(order);
//        return new ResponseEntity<>(order, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order updatedOrder) {
//        Optional<Order> existingOrder = orderList.stream().filter(o -> o.getId().equals(id)).findFirst();
//
//        if (existingOrder.isPresent()) {
//            Order order = existingOrder.get();
//            order.setNameOrder(updatedOrder.getNameOrder());
//            order.setPhoneOrder(updatedOrder.getPhoneOrder());
//            order.setPriceOrder(updatedOrder.getPriceOrder());
//            order.setAreaOrder(updatedOrder.getAreaOrder());
//            order.setStatus(updatedOrder.getStatus());
//            order.setShip(updatedOrder.getShip());
//
//            return new ResponseEntity<>(order, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
//        Optional<Order> order = orderList.stream().filter(o -> o.getId().equals(id)).findFirst();
//
//        if (order.isPresent()) {
//            orderList.remove(order.get());
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{id}/products")
//    public ResponseEntity<ArrayList<Product>> getProductsForOrder(@PathVariable String id) {
//        Optional<Order> order = orderList.stream().filter(o -> o.getId().equals(id)).findFirst();
//        return order.map(value -> new ResponseEntity<>(value.getProductList(), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/{id}/products")
//    public ResponseEntity<Product> addProductToOrder(@PathVariable String id, @RequestBody Product product) {
//        Optional<Order> order = orderList.stream().filter(o -> o.getId().equals(id)).findFirst();
//        if (order.isPresent()) {
//            order.get().getProductList().add(product);
//            return new ResponseEntity<>(product, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
//
//
