package nl.tudelft.jpacman.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;

public class MapSelectUI extends JPanel {
    private BufferedImage backgroundImage;
    private JButton btnBack = new JButton(new ImageIcon("src\\main\\resources\\button\\startbutton.png"));

    public MapSelectUI() {
        setBackground("src/main/resources/stage/stage.png");
        setUI();

        // showTopic();
    }

    public void setUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);

    }

    public void backBtn(String pathIcon, JButton btn, int row, int column) {
        ImageIcon icon = new ImageIcon(pathIcon);

        btn.setPreferredSize(new Dimension(100, 50));
        btn.setIcon(icon);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = column;
        c1.gridy = row;
        c1.insets = new Insets(20, 20, 20, 0);
        add(btn, c1);
    }

    public void setBackground(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMapButton(String pathIcon, JButton btn, int row, int column) {

        ImageIcon icon = new ImageIcon(pathIcon);

        btn.setPreferredSize(new Dimension(150, 150));
        btn.setIcon(icon);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = column;
        c1.gridy = row;
        c1.insets = new Insets(20, 20, 20, 0);
        add(btn, c1);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
