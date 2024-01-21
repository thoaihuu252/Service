package com.example.service.Service;

import com.example.service.Model.Product;
import com.example.service.controller.ProductRepositoryWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSv {

    @Autowired
    private ProductRepositoryWeb productRepository;

    // Method to get all products from the database
    public List<Product> getAllProducts() {
        return  (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);

    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public void deleteProduct(String productId) {
        Product existingProduct = productRepository.findById(productId).orElse(null);

        if (existingProduct == null) {
            throw new IllegalArgumentException("Sản phẩm không tồn tại.");
        }

        // Thêm logic kiểm tra và xử lý nếu cần

        productRepository.delete(existingProduct);
    }
}

