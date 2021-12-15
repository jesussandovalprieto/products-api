package com.tekton.productsapi.dto;

import com.tekton.productsapi.models.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryDTO {
    @NotBlank(message = "Name is required")
    private String name;

    public Category toCategory() {
        Category c = new Category();
        c.setName(name);
        return c;
    }
}
