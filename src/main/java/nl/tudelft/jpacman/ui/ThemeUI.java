package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeUI extends JPanel {
    int i = 0;

    // private final Map<String, ImageIcon> imageMap;
    public ThemeUI() {

        JPanel buttonPanel = new JPanel();
        JPanel themetitle = new JPanel();

        setLayout(new GridLayout(2, 2));

    }

    public void addThemeButton(String pathIcon, ActionListener action) {
        ImageIcon icon = new ImageIcon(pathIcon);
        JButton button = new JButton(icon);
        button.addActionListener(action);

        add(button);

    }
}
