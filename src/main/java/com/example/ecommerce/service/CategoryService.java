package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(category);
        }
        return null;
    }
    public boolean deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
            return true;
        }
        return false;
    }
}
