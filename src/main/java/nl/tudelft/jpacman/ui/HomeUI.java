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
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import java.awt.*;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

public class HomeUI extends JPanel {

    JLabel title = new JLabel("PacMan");
    ImageIcon background;

    JPanel miniPanel = new JPanel();
    JLabel logo = new JLabel();
    JLabel miniLogo = new JLabel();

    public HomeUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        logo.setIcon((ResizeImage(new ImageIcon("src\\main\\resources\\logo.png"), 500, 400)));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(logo);

        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.gridx = 0; // start at column 0
        logoConstraints.gridy = 0; // start at row 0
        logoConstraints.gridwidth = 1; // span one column
        logoConstraints.gridheight = 1; // span one row
        logoConstraints.weightx = 1.0; // resize horizontally
        logoConstraints.weighty = 0.0; // do not resize vertically
        logoConstraints.anchor = GridBagConstraints.PAGE_START; // align at page start
        logoConstraints.fill = GridBagConstraints.HORIZONTAL; // fill horizontally

    }

    public void start() {
        setVisible(true);
    }

    public void addButton(JButton btn) {
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setContentAreaFilled(false);
        this.add(btn);
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
