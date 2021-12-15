package com.tekton.productsapi.controllers;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.dto.ProductDetailDTO;
import com.tekton.productsapi.dto.ResponseDTO;
import com.tekton.productsapi.models.ProductDetail;
import com.tekton.productsapi.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product-details")
public class ProductDetailController {

    private final ProductDetailService service;

    @Autowired
    public ProductDetailController(ProductDetailService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(new ResponseDTO<List<ProductDetail>>("OK", this.service.findAll()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return Optional
                .ofNullable(this.service.findById(id))
                .map(product -> ResponseEntity.ok(new ResponseDTO<ProductDetail>("OK", product.get())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductDetailDTO productDetailDTO) {
        return ResponseEntity.ok(new ResponseDTO<ProductDetail>("OK", this.service.save(productDetailDTO)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ProductDTO product) {
        return ResponseEntity.ok("success");
    }
}
