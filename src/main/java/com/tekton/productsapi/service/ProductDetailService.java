package com.tekton.productsapi.service;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.dto.ProductDetailDTO;
import com.tekton.productsapi.models.Product;
import com.tekton.productsapi.models.ProductDetail;

import java.util.List;
import java.util.Optional;

public interface ProductDetailService {
    List<ProductDetail> findAll();
    ProductDetail save(ProductDetailDTO productDetailDTO);
    Optional<ProductDetail> findById(Integer id);
    Optional<ProductDetail> findByProductId(Integer productId);
}
