package nl.tudelft.jpacman.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WinPageTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Win Page Test");
        WinPage winPage = new WinPage();
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        winPage.addButton("src/main/resources/icons/restart.png", button1, 1, 0);
        winPage.addButton("src/main/resources/icons/exit.png", button2, 1, 1);
        winPage.setScore(1000);
        frame.setContentPane(winPage);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

