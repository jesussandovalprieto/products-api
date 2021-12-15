package com.tekton.productsapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDetailDTO {
    @NotNull(message = "Product ID is required")
    private Integer productId;

    @NotBlank(message = "Trademark is required")
    private String trademark;

    @NotNull(message = "Quantity is required")
    private Double quantity;

    @NotNull(message = "Price is required")
    private Double price;
}
