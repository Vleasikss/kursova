package org.example.service.gui.extension.button;

import org.example.model.BasicModel;
import org.example.service.gui.tab.FrameTab;

import javax.swing.*;
import java.awt.*;


/**
 * extension of JButton which contains an additional listener
 * per each {@link DeleteModelButton#DeleteModelButton(FrameTab, BasicModel, DeleteAction, String)} click
 * @param <T> Model to delete
 */
public class DeleteModelButton<T extends BasicModel> extends JButton {

    private static final String DEFAULT_DELETE_BUTTON_TITLE = "delete";

    /**
     * Creates a listener which calls {@link DeleteAction#apply(T)} per each button click
     * and reloads the page to update the page where delete is called
     *
     * @param frameTab Frame Tab to reload
     * @param model model to delete
     * @param deleteAction action to call
     * @param title button title
     */
    public DeleteModelButton(FrameTab frameTab, T model, DeleteAction<T> deleteAction, String title) {
        setText(title);
        setBackground(Color.RED);
        addActionListener(e -> {
            deleteAction.apply(model);
            frameTab.reload();
        });
    }

    public DeleteModelButton(FrameTab frameTab, T model, DeleteAction<T> deleteAction) {
        this(frameTab, model, deleteAction, DEFAULT_DELETE_BUTTON_TITLE);
    }

}
