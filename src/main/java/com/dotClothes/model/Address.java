package com.dotClothes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Address")
public class Address extends Model {


    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Customer", referencedColumnName = "Id_customer")
    private Customer customer;

    public Address(){
      super();
    }

    public Address(Long id){
        super(id);
    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
