package com.dotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Customer")
public class Customer extends Model {


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String eMail;
    @Column(name = "sex")
    private String sex;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Address> address = new HashSet<Address>();
    @Column(name = "password")
    private String password;
    @Column(name = "nick")
    private String nick;
    @Column(name = "token")
    private String token;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> order = new HashSet<Order>();

    public Customer(){
        super();
    }

    public Customer(Long id){
        super(id);
    }

    public Customer(String firstName, String lastName, String phone, String eMail, String sex, String password, String nick, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.eMail = eMail;
        this.sex = sex;
        this.password = password;
        this.nick = nick;
        this.token = token;
    }
}
