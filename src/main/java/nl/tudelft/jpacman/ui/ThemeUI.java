package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeUI extends JPanel {
    int i = 0;

    // private final Map<String, ImageIcon> imageMap;
    public ThemeUI() {

        Container c = getContentPane();
        JPanel buttonPanel = new JPanel();
        JPanel themetitle = new JPanel();

        JPanel topic = new JPanel();

        setLayout(new GridLayout(3, 2, 48, 48));

        JLabel topictheme = new JLabel();
        topictheme.setIcon(new ImageIcon("src/main/resources/Theme/buttontheme.png"));

        JLabel space = new JLabel();
        add(topictheme);
        add(space);

    }

    private Container getContentPane() {
        return null;
    }

    public void addThemeButton(String pathIcon, ActionListener action) {
        ImageIcon icon = new ImageIcon(pathIcon);
        JButton button = new JButton(icon);
        button.addActionListener(action);

        add(button);

    }
}