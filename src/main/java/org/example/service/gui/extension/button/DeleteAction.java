package org.example.service.gui.extension.button;

/**
 * Functional interface for applying some Delete Actions for {@link T}
 * @param <T> Model to Delete
 */
@FunctionalInterface
public interface DeleteAction<T> {

    boolean apply(T t);
}
