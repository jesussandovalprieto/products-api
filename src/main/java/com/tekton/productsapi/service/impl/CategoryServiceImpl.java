package com.tekton.productsapi.service.impl;

import com.tekton.productsapi.dto.CategoryDTO;
import com.tekton.productsapi.models.Category;
import com.tekton.productsapi.repository.CategoryRepository;
import com.tekton.productsapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Category save(CategoryDTO categoryDTO) {
        Category c = new Category();
        c.setName(categoryDTO.getName());
        return this.repository.save(c);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public Category update(Integer id, CategoryDTO categoryDTO) {
        Category category = categoryDTO.toCategory();
        category.setId(id);
        return this.repository.save(category);
    }
}
