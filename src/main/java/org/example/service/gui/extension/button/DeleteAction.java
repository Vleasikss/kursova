package org.example.service.gui.extension.button;

import org.example.model.BasicModel;

/**
 * Functional interface for applying some Delete Actions for {@link T}
 * @param <T> Model to Delete
 */
@FunctionalInterface
public interface DeleteAction<T extends BasicModel> {

    boolean apply(T t);
}
