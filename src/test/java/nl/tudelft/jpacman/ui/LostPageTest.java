package nl.tudelft.jpacman.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import nl.tudelft.jpacman.ui.LostPage;

public class LostPageTest {

    public static void main(String[] args) {
        LostPage lp = new LostPage();
        JButton btn1 = new JButton("Restart");
        JButton btn2 = new JButton("Quit");
        lp.addButton("src/main/resources/button/restartbutton.png", btn1, 1, 0);
        lp.addButton("src/main/resources/button/quitbutton.png", btn2, 1, 1);
        lp.setScore(1000);

        JFrame frame = new JFrame("Lost Page Test");
        frame.add(lp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

}
