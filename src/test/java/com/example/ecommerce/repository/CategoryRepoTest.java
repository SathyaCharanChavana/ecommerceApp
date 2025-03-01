package com.example.ecommerce.repository;

import com.example.ecommerce.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//Integration Test
@SpringBootTest

public class CategoryRepoTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void insertCategory(){
        Category category=new Category();
        category.setCategoryName("Electronics");
        category.setDescription("Electronic Items");
        categoryRepository.save(category);
    }

}
