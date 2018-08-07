package com.DotClothes.dao;

import com.DotClothes.model.Model;

import java.util.List;

/**
 * Created by Gleb on 21.05.18.
 */
public interface GenericDao<T extends Model> {

    void add(T model);

    void update(T model);

    Object get(long id);

    void remove(T model);

    List<T> getAll();

}
