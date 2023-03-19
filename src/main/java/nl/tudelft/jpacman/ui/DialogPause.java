package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DialogPause extends JDialog{
    private BufferedImage bg;

    public DialogPause() {

        this.setLayout(new GridBagLayout());

        /*JLabel label = new JLabel("Pause Game");

        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Serif", Font.BOLD, 20);
        label.setFont(font);*/
        JLabel popup = new JLabel("Pause");
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        // Add the label above the first button
        GridBagConstraints cl = new GridBagConstraints();
        cl.gridx = 0;
        cl.gridy = 0;

        this.add(popup, cl);

        // Set the dialog size and visibility
        this.setSize(300, 200);
    }

    public void setBackground(String imagePath) {
        try {
            bg = ImageIO.read(new File(imagePath));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Visible() {
        setVisible(true);
    }

    public void Disible() {
        setVisible(false);
    }

    public void addContinueButton(JButton btn) {
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 2;
        c1.insets = new Insets(5, 5, 5, 5);
        btn.setOpaque(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        this.add(btn, c1);
    }

    public void addBackhomeButton(JButton btn) {
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 3;
        c1.insets = new Insets(5, 5, 5, 5);
        btn.setOpaque(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        this.add(btn, c1);
    }

}