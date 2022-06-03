package org.example.service.gui.extension;

import java.awt.*;

/**
 * Abstraction over Component which uses for applying Components in more functional way
 */
@FunctionalInterface
public interface FrameExtension {

    /**
     * @return Component
     */
    Component apply();

}
