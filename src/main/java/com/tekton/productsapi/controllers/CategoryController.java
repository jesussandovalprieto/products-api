package com.tekton.productsapi.controllers;

import com.tekton.productsapi.dto.CategoryDTO;
import com.tekton.productsapi.dto.ResponseDTO;
import com.tekton.productsapi.models.Category;
import com.tekton.productsapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Cacheable("categories")
    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(new ResponseDTO<List<Category>>("OK", this.service.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(new ResponseDTO<Category>("OK", this.service.save(categoryDTO)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody CategoryDTO category) {
        return ResponseEntity.ok(new ResponseDTO<Category>("OK", this.service.update(id, category)));
    }
}
