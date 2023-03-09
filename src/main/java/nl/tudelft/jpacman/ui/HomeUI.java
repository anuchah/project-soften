package nl.tudelft.jpacman.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import java.awt.*;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

public class HomeUI extends JPanel {

    // create a panel to hold the buttons
    JPanel buttonPanel = new JPanel();
    // create two buttons to switch between cards

    JLabel title = new JLabel("PacMan");
    ImageIcon background;
    JPanel logoPanel = new JPanel();
    JPanel miniPanel = new JPanel();
    JLabel logo = new JLabel();
    JLabel miniLogo = new JLabel();

    public HomeUI() {

        logoPanel.setBackground(new Color(0, 0, 0, 0));
        logo.setIcon((ResizeImage(new ImageIcon("src\\main\\resources\\logo.png"), 500, 400)));
        logoPanel.add(logo);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.gridx = 0; // start at column 0
        logoConstraints.gridy = 0; // start at row 0
        logoConstraints.gridwidth = 1; // span one column
        logoConstraints.gridheight = 1; // span one row
        logoConstraints.weightx = 1.0; // resize horizontally
        logoConstraints.weighty = 0.0; // do not resize vertically
        logoConstraints.anchor = GridBagConstraints.PAGE_START; // align at page start
        logoConstraints.fill = GridBagConstraints.HORIZONTAL; // fill horizontally
        this.setLayout(new GridBagLayout());
        add(logoPanel, logoConstraints);

    }

    public void start() {
        setVisible(true);
    }

    public void addButton(JButton btn) {
        buttonPanel.add(btn);
        buttonPanel.setBackground(new java.awt.Color(255, 0, 0, 0));
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0; // start at column 0
        buttonConstraints.gridy = 1; // start at row 1
        buttonConstraints.gridwidth = 1; // span one column
        buttonConstraints.gridheight = 1; // span one row
        buttonConstraints.weightx = 1.0; // resize horizontally
        buttonConstraints.weighty = 1.0; // resize vertically
        buttonConstraints.anchor = GridBagConstraints.CENTER; // align at center
        Component[] components = this.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                this.remove(buttonPanel);
                this.revalidate();
            }
        }
        this.add(buttonPanel, buttonConstraints);
    }

    public ImageIcon ResizeImage(ImageIcon image, int width, int hight) {

        Image img = image.getImage().getScaledInstance(width, hight, Image.SCALE_SMOOTH);

        return new ImageIcon(img);

    }

    @Override
    public void paintComponent(Graphics g) {
        // Call the super method
        super.paintComponent(g);
        // Draw the image icon on the panel
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public void setBackground(String path) {
        background = new ImageIcon(path);

    }

}
