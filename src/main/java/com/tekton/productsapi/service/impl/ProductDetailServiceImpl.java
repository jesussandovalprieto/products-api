package com.tekton.productsapi.service.impl;

import com.tekton.productsapi.dto.ProductDTO;
import com.tekton.productsapi.dto.ProductDetailDTO;
import com.tekton.productsapi.models.Category;
import com.tekton.productsapi.models.Product;
import com.tekton.productsapi.models.ProductDetail;
import com.tekton.productsapi.repository.ProductDetailRepository;
import com.tekton.productsapi.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository repository;

    @Autowired
    public ProductDetailServiceImpl(ProductDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDetail> findAll() {
        return this.repository.findAll();
    }

    @Override
    public ProductDetail save(ProductDetailDTO productDetailDTO) {
        Product product = new Product();
        product.setId(productDetailDTO.getProductId());

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);

        productDetail.setTrademark(productDetailDTO.getTrademark());
        productDetail.setPrice(productDetailDTO.getPrice());
        productDetail.setQuantity(productDetailDTO.getQuantity());

        return this.repository.save(productDetail);
    }

    @Override
    public Optional<ProductDetail> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<ProductDetail> findByProductId(Integer productId) {
        return this.repository.findByProductId(productId);
    }
}
