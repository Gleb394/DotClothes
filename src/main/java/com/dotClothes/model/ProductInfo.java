package com.dotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Gleb on 10.07.18.
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Product_Info")
public class ProductInfo extends Model {

    @Column(name = "name_product")
    String nameProduct;
    @Column(name = "specification")
    String specification;
    @Column(name = "path_picture")
    String pathPicture;

    public ProductInfo() {
        super();
    }

    public ProductInfo(Long id) {
        super(id);
    }
}
