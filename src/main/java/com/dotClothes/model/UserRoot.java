package com.dotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "User_root")
public class UserRoot extends Model {


    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public UserRoot() {
        super();
    }

    public UserRoot(Long id) {
        super(id);
    }
}
