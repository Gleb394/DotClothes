package com.DotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Color")
public class Color extends Model {

    @Column(name = "name_color")
    private String name_color;

    public Color() {
        super();
    }

    public Color(Long id) {
        super(id);
    }
}
