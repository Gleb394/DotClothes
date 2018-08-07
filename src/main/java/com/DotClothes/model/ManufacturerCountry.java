package com.DotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Manufacturer_Country")
public class ManufacturerCountry extends Model {

    @Column(name = "name_manu_country")
    private String nameManuCountry;

    public ManufacturerCountry() {
        super();
    }

    public ManufacturerCountry(Long id) {
        super(id);
    }
}
