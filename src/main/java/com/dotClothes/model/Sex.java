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
@Table(name = "Sex")
public class Sex extends Model {

    @Column(name = "name_sex")
    String nameSex;

    public Sex() {
        super();
    }

    public Sex(Long id) {
        super(id);
    }
}
