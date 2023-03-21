package nl.tudelft.jpacman.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LostPageTest {

    private LostPage lostPage;

    @BeforeEach
    void setUp() {
        lostPage = new LostPage();
    }

    @Test
    void testAddButton() {
        JButton restartButton = new JButton("Restart");
        JButton quitButton = new JButton("Quit");

        lostPage.addButton("src/main/resources/button/restartbutton.png", restartButton, 1, 0);
        lostPage.addButton("src/main/resources/button/quitbutton.png", quitButton, 1, 1);

        JPanel buttonPanel = (JPanel) lostPage.getComponent(0);
        assertNotNull(buttonPanel);
        assertEquals(2, buttonPanel.getComponentCount());

        JButton firstButton = (JButton) buttonPanel.getComponent(0);
        assertNotNull(firstButton);
        assertEquals(restartButton, firstButton);

        JButton secondButton = (JButton) buttonPanel.getComponent(1);
        assertNotNull(secondButton);
        assertEquals(quitButton, secondButton);
    }

    @Test
    void testSetScore() {
        int score = 1000;
        lostPage.setScore(score);

        JPanel scorePanel = (JPanel) lostPage.getComponent(1);
        assertNotNull(scorePanel);
        assertEquals(1, scorePanel.getComponentCount());

        String expectedLabelText = "Your score: " + score;
        String actualLabelText = scorePanel.getComponent(0).getName();
        assertEquals(expectedLabelText, actualLabelText);
    }

    @Test
    void testFrame() {
        JFrame frame = new JFrame("Lost Page Test");
        frame.add(lostPage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);

        assertEquals("Lost Page Test", frame.getTitle());
        assertEquals(lostPage, frame.getContentPane().getComponent(0));
        assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
        assertEquals(800, frame.getWidth());
        assertEquals(800, frame.getHeight());
        assertEquals(true, frame.isVisible());
    }
}
