package com.tekton.productsapi.dto;

import com.tekton.productsapi.models.Category;
import com.tekton.productsapi.models.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDTO {
    @NotNull(message = "Product category is required")
    private Integer categoryId;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    private String description;

    public Product toProduct() {
        Product product = new Product();
        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);
        product.setName(name);
        product.setDescription(description);
        return product;
    }
}
