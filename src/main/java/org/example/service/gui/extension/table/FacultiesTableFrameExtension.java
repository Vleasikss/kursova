package org.example.service.gui.extension.table;

import org.example.model.Faculty;
import org.example.service.gui.extension.table.converter.FacultiesTableConverter;

import java.util.List;

public class FacultiesTableFrameExtension extends TableFrameExtension<Faculty> {

    public FacultiesTableFrameExtension(List<Faculty> faculties) {
        super(new FacultiesTableConverter(), faculties);
    }
}
