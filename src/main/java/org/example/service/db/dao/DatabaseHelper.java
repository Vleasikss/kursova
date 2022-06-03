package org.example.service.db.dao;

import org.example.model.BasicModel;

import java.util.List;

/**
 * Basic JDBC DAO interface
 * @see <a href="https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.html">DAO</a>
 * @param <T> Model
 * @param <ID> Model Identifier
 */
public interface DatabaseHelper<T extends BasicModel, ID> {

    /**
     * @return all founded {@link T} from database
     */
    List<T> findAll();

    /**
     * Inserts a {@link T} into database
     * @return true if insert is applied
     */
    boolean insert(T t);

    /**
     * Deletes a {@link T} by {@link ID} from database
     * @param id id to delete by
     * @return true if delete is applied
     */
    boolean deleteById(ID id);

}
