package com.tekton.productsapi.service;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product save(ProductDTO product);
    Optional<Product> findById(Integer id);
}
