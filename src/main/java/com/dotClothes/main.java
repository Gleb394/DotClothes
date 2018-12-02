package com.dotClothes;

import com.dotClothes.imp.ImpCustomerDao;
import com.dotClothes.model.Customer;

import java.util.GregorianCalendar;

/**
 * Created by Gleb on 12.07.18.
 */
public class main {

    public static void main(String[] args) {

        Customer customer = new Customer("gleb", "tar", "(097)999-69-36", "sdff", "man", "password", "ddd", new GregorianCalendar());

        //Address address = new Address("fff", "fff", "vvv");

        ImpCustomerDao impCustomerDao = new ImpCustomerDao();

        //ImpAddressDao impAddressDao = new ImpAddressDao();

        impCustomerDao.add(customer);

        //impAddressDao.add(address);
        System.out.println("OK");

        //System.out.println(impCustomerDao.get(1));
    }

}
