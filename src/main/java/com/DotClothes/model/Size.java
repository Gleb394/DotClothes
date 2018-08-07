package com.DotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Size")
public class Size extends Model {

    @Column(name = "name_size")
    private int nameSize;

    public Size() {
        super();
    }

    public Size(Long id) {
        super(id);
    }
}
