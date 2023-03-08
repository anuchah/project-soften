package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeUI {
        int i=0;
        private static JPanel panel;
        //private final Map<String, ImageIcon> imageMap;
        public ThemeUI() {

            JPanel buttonPanel = new JPanel();
            JPanel themetitle = new JPanel();

            JButton[] buttons = new JButton[3];
            panel = new JPanel(new GridLayout(2, 2));
            String[] b = {"Japan", "Halloween", "City"};
            ImageIcon[] images = {new ImageIcon("resources/Theme/japan.jpg"),
                new ImageIcon("resources/Theme/hallow.jpg"),
                new ImageIcon("resources/Theme/neon.jpg")};

            for (int i = 0; i < buttons.length; i++) {

                buttons[i] = new JButton(b[i], images[i]);
                buttons[i].setActionCommand(b[i]);
                buttons[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String choice = e.getActionCommand();
                        JOptionPane.showMessageDialog(null, "Theme: " + choice);
                    }
                });


                panel.add(buttons[i]);
            }
    }
}
