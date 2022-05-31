package org.example.service.gui.extension;

import org.example.service.gui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;

public final class FrameExtensions {


    private static final Function<String, FrameExtension> JLabelBuilder = (text) -> {
        JLabel name = new JLabel(text);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        return () -> name;
    };

    private static final Supplier<FrameExtension> JTextFieldBuilder = () -> {
        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        return () -> tname;
    };

    public interface FrameConstructor {

        Component construct();

    }

    public static final class RegistrationFormConstructor implements FrameConstructor {

        private static final FrameExtension FormLabel = () -> {
            JLabel title = new JLabel("Registration Form");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(300, 30);
            title.setLocation(300, 30);
            return title;
        };

        private static final FrameExtension FirstNameLabel = JLabelBuilder.apply("First name");
        private static final FrameExtension FirstNameTextField = JTextFieldBuilder.get();

        private static final FrameExtension LastNameLabel = JLabelBuilder.apply("Last name");
        private static final FrameExtension LastNameTextField = JTextFieldBuilder.get();

        @Override
        public Component construct() {
            JPanel panel = new JPanel();
            panel.add(FirstNameLabel.apply());
            panel.add(FirstNameTextField.apply());

            panel.add(LastNameLabel.apply());
            panel.add(LastNameTextField.apply());
            return panel;
        }
    }

}
