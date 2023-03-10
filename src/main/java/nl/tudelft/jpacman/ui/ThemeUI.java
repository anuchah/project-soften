package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeUI extends JPanel {
    int i = 0;
    private JLabel topictheme;

    // private final Map<String, ImageIcon> imageMap;
    public ThemeUI() {
        setUI();
        showTopic();
    }

    public void setUI(){
        topictheme = new JLabel("", JLabel.CENTER);

        setLayout(new GridLayout(5,3,50,48));
        //setSize(20,100);
        setBackground(Color.BLACK);
    }

    public void showTopic(){
        topictheme.setIcon(new ImageIcon("src/main/resources/Theme/buttontheme.png"));
        add(topictheme);

    }

    public void addThemeButton(String pathIcon, ActionListener action) {
        ImageIcon icon = new ImageIcon(pathIcon);
        /*icon.getImage().getScaledInstance(1, 1, Image.SCALE_SMOOTH);
        icon.setImage(icon);*/
        JButton button = new JButton(icon);
        button.addActionListener(action);

        add(button);

    }
}
