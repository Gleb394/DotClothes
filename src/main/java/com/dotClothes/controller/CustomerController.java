package com.dotClothes.controller;

import com.dotClothes.model.Customer;
import com.dotClothes.serves.CustomerServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServes customerServes;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView vm) {
        vm.setViewName("login");
        vm.addObject("Customer", new Customer());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "Customer") Customer customer, ModelAndView vm) {
        return customerServes.getByEmail(customer.getEMail())
                .map(r -> customerServes.verifyPassword(r, customer))
                .filter(Optional::isPresent)
                .map(r -> {
                    vm.setViewName("home");
                    return vm;
                })
                .orElseGet(() -> {
                   vm.setViewName("login");
                   return vm;
                });
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("register");
        vm.addObject("Customer", new Customer());
        return vm;
    }
}