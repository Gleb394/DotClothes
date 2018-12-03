package com.dotClothes.serves;

import com.dotClothes.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerServes extends Serves<Customer, Long> {

    Optional<Customer> getByEmail(String email);

    Optional<Customer> verifyPassword(Customer email, Customer customer);

}
