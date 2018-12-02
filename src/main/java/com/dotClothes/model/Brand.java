package com.dotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Brand")
public class Brand extends Model {

    @Column(name = "name_brand")
    private String nameBrand;

    public Brand() {
        super();
    }

    public Brand(Long id) {
        super(id);
    }
}
