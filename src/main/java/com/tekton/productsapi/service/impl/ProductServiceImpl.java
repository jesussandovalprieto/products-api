package com.tekton.productsapi.service.impl;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.models.Category;
import com.tekton.productsapi.models.Product;
import com.tekton.productsapi.repository.CategoryRepository;
import com.tekton.productsapi.repository.ProductRepository;
import com.tekton.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product save(ProductDTO product) {
        Product p = new Product();
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        Category c = new Category();
        c.setId(product.getCategoryId());
        p.setCategory(c);
        return this.repository.save(p);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return this.repository.findById(id);
    }
}
