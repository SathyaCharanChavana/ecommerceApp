package com.example.ecommerce.service;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setImageUrl(updatedProduct.getImageUrl());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        }
        return null;
    }
    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }
}
