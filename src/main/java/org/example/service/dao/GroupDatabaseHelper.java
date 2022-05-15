package org.example.service.dao;

import org.example.model.Group;

import java.util.List;

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
}
