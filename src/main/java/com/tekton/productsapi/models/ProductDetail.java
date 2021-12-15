package com.tekton.productsapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
public class ProductDetail extends Base {
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column
    private String trademark;

    @Column
    private Double quantity;

    @Column
    private Double price;
}
