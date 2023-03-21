package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.theme.CustomFont;

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
    ImageIcon icon = new ImageIcon();
    DialogPausePanel panel = new DialogPausePanel();

    public DialogPause(JFrame owner) {
        super(owner);
        panel.setLayout(new GridBagLayout());

        JLabel space1 = new JLabel();
        JLabel space2 = new JLabel();

        setDefaultCloseOperation(DialogPause.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(owner);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(15, 15, 15, 15);
        panel.add(space1, c1);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(15, 15, 15, 15);
        panel.add(space2, c2);
        setContentPane(panel);
        setBackground("src/main/resources/Theme/popup/popog.png");
        // Set the dialog size and visibility
        this.setSize(300, 200);
        panel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        owner.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                int x = owner.getLocation().x + (owner.getWidth() - getWidth()) / 2;
                int y = owner.getLocation().y + (owner.getHeight() - getHeight()) / 2;
                setLocation(x, y);
            }
        });

    }

    public void setBackground(String imagePath) {
        panel.setBackground(imagePath);

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
        c1.gridy = 3;
        c1.insets = new Insets(5, 5, 5, 5);
        btn.setOpaque(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(btn, c1);

    }

    public void addBackhomeButton(JButton btn) {
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 4;
        c1.insets = new Insets(5, 5, 5, 5);
        btn.setOpaque(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(btn, c1);

    }

    private class DialogPausePanel extends JPanel {
        private ImageIcon background;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
        }

        public void setBackground(String path) {
            background = new ImageIcon(path);

        }

    }

}
