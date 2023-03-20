package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DialogPause extends JDialog {
    private BufferedImage bg;

    public DialogPause(JFrame owner) {
        super(owner);
        this.setLayout(new GridBagLayout());

        JLabel popup = new JLabel("Pause");
        Font font = new Font("Serif", Font.BOLD, 20);
        popup.setFont(font);
        setDefaultCloseOperation(DialogPause.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(owner);
        // Add the label above the first button
        GridBagConstraints cl = new GridBagConstraints();
        cl.gridx = 0;
        cl.gridy = 0;

        this.add(popup, cl);

        // Set the dialog size and visibility
        this.setSize(300, 200);
        setBackground("src/main/resources/Theme/popup/popog.png");

        owner.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                int x = owner.getLocation().x + (owner.getWidth() - getWidth()) / 2;
                int y = owner.getLocation().y + (owner.getHeight() - getHeight()) / 2;
                setLocation(x, y);
            }
        });
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
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(btn, c1);
    }

}
