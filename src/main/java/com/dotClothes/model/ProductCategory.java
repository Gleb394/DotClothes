package com.dotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Product_Category")
public class ProductCategory extends Model {

    @Column(name = "name_product_category")
    private String nameProductCategory;

    public ProductCategory() {
        super();
    }

    public ProductCategory(Long id) {
        super(id);
    }
}
