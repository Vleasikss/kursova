package org.example.service.dao;

import java.util.List;

public interface DatabaseHelper<T, ID> {

    List<T> findAll();

    boolean insert(T t);

    boolean deleteById(ID id);


}
