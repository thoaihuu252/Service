package com.example.service.Service;

import com.example.service.Model.Order;
import com.example.service.Model.Orderr;
import com.example.service.Model.Product;
import com.example.service.controller.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Service
public class OrderSv {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private ProductSv productService;


    public List<Orderr> getAllOrder() {
        return orderRepository.findAll();
    }
    public List<Order> getAllOrderNWU() {
        //khong lay warehouse va user
        return orderRepository.findAllOrderSummaries();
    }
    public Optional<Orderr> getAllOrderbyID(String id) {
        return orderRepository.findById(id);
    }
    public Orderr createOrder(Orderr orderr) {
        // Validate if the products associated with the order exist
        Set<Product> products = orderr.getProducts();
        for (Product product : products) {
            if (productService.getProductById(product.getId()) == null) {
                throw new IllegalArgumentException("Product with id " + product.getId() + " does not exist.");
            }
        }

        // Additional business logic/validation if needed

        return orderRepository.save(orderr);
    }
    public Orderr updateOrderStatus(String id, String newStatus) {
        Orderr existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            throw new IllegalArgumentException("Don khong ton tai.");
        }

        existingOrder.setStatus(newStatus);

        // Thêm logic kiểm tra và xử lý nếu cần

        return orderRepository.save(existingOrder);
    }
    public void deleteOrder(String id) {
        Orderr existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            throw new IllegalArgumentException("Don khong ton tai.");
        }

        // Thêm logic kiểm tra và xử lý nếu cần

        orderRepository.delete(existingOrder);
    }
    public Set<Product> getAllProductsFromOrder(String orderId) {
        Orderr existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder == null) {
            throw new IllegalArgumentException("Don khong ton tai.");
        }
        return existingOrder.getProducts();
    }
    public Orderr addProductToOrder(String orderId, Product product) {
        Orderr existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder == null) {
            throw new IllegalArgumentException("don khong ton tai.");
        }

        // Kiểm tra xem sản phẩm có tồn tại không
        Product existingProduct = productService.getProductById(product.getId()).orElse(null);
        if (existingProduct == null) {
            existingProduct = productService.createProduct(product);
        }

        existingOrder.getProducts().add(existingProduct);


        return orderRepository.save(existingOrder);
    }
}
