package com.dotClothes.imp;

import com.dotClothes.dao.AddressDao;
import com.dotClothes.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class ImpAddressDao extends AbstractDao<Address> implements AddressDao {
}
