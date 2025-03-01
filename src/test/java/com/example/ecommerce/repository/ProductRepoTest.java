package com.example.ecommerce.repository;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void createProduct(){
        Product product=new Product();
        Category category= categoryRepository.findById(1L).get();
        product.setCategory(category);
        product.setName("Iphone");
        product.setDescription("Apple Iphone");
        productRepository.save(product);
    }
}
