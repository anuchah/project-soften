package nl.tudelft.jpacman.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinPage extends JPanel {
    private BufferedImage backgroundImage;

    public WinPage(){
        setBackground("src/main/resources/theme/lostwin/win.png");
        setUI();
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

    public void setBackground(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addThemeButton(String pathIcon, ActionListener action, int row, int column) {

        ImageIcon icon = new ImageIcon(pathIcon);
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(150, 75));
        button.addActionListener(action);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = column;
        c1.gridy = row;
        c1.insets = new Insets(20, 20, 20, 0);
        add(button, c1);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
