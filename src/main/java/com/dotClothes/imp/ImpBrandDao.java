package com.dotClothes.imp;

import com.dotClothes.dao.BrandDao;
import com.dotClothes.model.Brand;
import org.springframework.stereotype.Repository;

@Repository
public class ImpBrandDao extends AbstractDao<Brand> implements BrandDao {
}
