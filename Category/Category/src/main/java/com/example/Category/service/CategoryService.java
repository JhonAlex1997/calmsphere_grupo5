package com.example.Category.service;

import com.example.Category.model.Category;
import com.example.Category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return repository.findById(id);
    }

    public Category updateCategory(Long id, Category newCategory) {
        return repository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return repository.save(category);
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}