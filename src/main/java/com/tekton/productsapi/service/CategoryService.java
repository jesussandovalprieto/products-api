package com.tekton.productsapi.service;

import com.tekton.productsapi.dto.CategoryDTO;
import com.tekton.productsapi.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Category save(CategoryDTO categoryDTO);
    Category update(Integer id, CategoryDTO categoryDTO);
    Optional<Category> findById(Integer id);
}
