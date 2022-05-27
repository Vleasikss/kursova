package org.example.service.db.dao;

import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface DatabaseHelper<T, ID> {

    List<T> findAll();

    boolean insert(T t);

    boolean deleteById(ID id);

    Optional<Student> findById(ID id);


}
