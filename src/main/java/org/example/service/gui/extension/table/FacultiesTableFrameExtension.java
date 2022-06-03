package org.example.service.gui.extension.table;

import org.example.model.Faculty;
import org.example.service.gui.extension.table.converter.FacultiesTableConverter;

import java.util.List;

/**
 * Realization of {@link TableFrameExtension} for showing a table of {@link Faculty}
 */
public class FacultiesTableFrameExtension extends TableFrameExtension<Faculty> {

    public FacultiesTableFrameExtension(List<Faculty> faculties) {
        super(new FacultiesTableConverter(), faculties);
    }
}
