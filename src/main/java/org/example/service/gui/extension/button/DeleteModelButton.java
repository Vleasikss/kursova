package org.example.service.gui.extension.button;

import org.example.model.BasicModel;
import org.example.service.gui.tab.FrameTab;

import javax.swing.*;
import java.awt.*;

public class DeleteModelButton<T extends BasicModel> extends JButton {

    private static final String DEFAULT_DELETE_BUTTON_TITLE = "delete";

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
