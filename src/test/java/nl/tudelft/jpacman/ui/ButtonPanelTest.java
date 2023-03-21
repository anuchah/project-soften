package nl.tudelft.jpacman.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

class ButtonPanelTest {
    private Map<String, Action> buttons;
    private JFrame parent;
    private ButtonPanel buttonPanel;

    @BeforeEach
    void setUp() {
        buttons = new HashMap<>();
        parent = new JFrame();
        buttonPanel = new ButtonPanel(buttons, parent);
    }

    @Test
    void testAddButton() {
        Action action = new Action() {
            @Override
            public void doAction() {
                System.out.println("Button clicked!");
            }
        };
        buttons.put("Click me", action);
        buttonPanel.add(new JButton("Click me"));

        Assertions.assertEquals(buttons.size(), buttonPanel.getComponentCount());
    }
}
