package com.DotClothes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Order")
public class Order extends Model {

    @Column(name = "address_delivery")
    private String addressDelivery;
    @Column(name = "payment")
    private String payment;
    @Column(name = "comment")
    private String comment;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private int phone;
    @Column(name = "email")
    private String eMail;
    @Column(name = "created")
    private GregorianCalendar created;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Customer", referencedColumnName = "Id_customer")
    private Customer customer;

    public Order() {
        super();
    }

    public Order(Long id) {
        super(id);
    }
}
