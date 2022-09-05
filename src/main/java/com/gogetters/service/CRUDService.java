package com.gogetters.service;

import java.util.List;

public interface CRUDService<T>{

    T findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    long deleteById(Long id);

}
