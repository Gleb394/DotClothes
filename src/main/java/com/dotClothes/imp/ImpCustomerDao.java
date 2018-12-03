package com.dotClothes.imp;

import com.dotClothes.dao.CustomerDao;
import com.dotClothes.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class ImpCustomerDao extends AbstractDao<Customer> implements CustomerDao {

}
