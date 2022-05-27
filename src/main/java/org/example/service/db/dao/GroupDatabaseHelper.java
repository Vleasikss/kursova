package org.example.service.db.dao;

import org.example.model.Group;
import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public class GroupDatabaseHelper implements DatabaseHelper<Group, String> {

    //    todo
    @Override
    public List<Group> findAll() {
        return null;
    }

    //    todo
    @Override
    public boolean insert(Group group) {
        return false;
    }

    //    todo
    @Override
    public boolean deleteById(String s) {
        return false;
    }

    @Override
    public Optional<Student> findById(String s) {
        return Optional.empty();
    }
}
