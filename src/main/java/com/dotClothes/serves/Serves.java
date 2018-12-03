package com.dotClothes.serves;

import com.dotClothes.model.Model;

import java.util.List;

/**
 * Created by Gleb on 02.12.18.
 */
public interface Serves<T extends Model, Id> {

    void save(T t);

    T getById (Id id);

    void remove(T t);

    List<T> getAll();

}
