package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeUI extends JPanel {
    int i = 0;
    private JLabel topictheme;

    public ThemeUI() {

        setUI();
        //showTopic();
    }

    public void setUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        topictheme = new JLabel(new ImageIcon("src/main/resources/Theme/buttontheme.png"));
        add(topictheme, c);

        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);
    }

    public void addThemeButton(String pathIcon, ActionListener action, int row, int column) {

        ImageIcon icon = new ImageIcon(pathIcon);

        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(300, 100));
        button.addActionListener(action);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = column;
        c1.gridy = row;
        c1.insets = new Insets(20, 20, 20, 0);
        add(button, c1);

    }
}
