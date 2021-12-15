package com.tekton.productsapi.controllers;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.dto.ResponseDTO;
import com.tekton.productsapi.models.Product;
import com.tekton.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(new ResponseDTO<List<Product>>("OK", this.service.findAll()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return Optional
                .ofNullable(this.service.findById(id))
                .map(product -> ResponseEntity.ok(new ResponseDTO<Product>("OK", product.get())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ResponseDTO<Product>("OK", this.service.save(productDTO)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ProductDTO product) {
        return ResponseEntity.ok("success");
    }
}
