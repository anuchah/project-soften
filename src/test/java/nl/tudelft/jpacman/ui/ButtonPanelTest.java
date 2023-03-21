package nl.tudelft.jpacman.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ButtonPanelTest {

    private Map<String, Action> buttons;
    private JFrame parent;
    private ButtonPanel buttonPanel;

    @BeforeEach
    void setUp() {
        buttons = Collections.singletonMap("Click me", () -> System.out.println("Button clicked!"));
        parent = new JFrame();
        buttonPanel = new ButtonPanel(buttons, parent);
    }

    @Test
    void testAddButton() {
        buttonPanel.add(new JButton("Click me"));
        assertEquals(buttons.size(), buttonPanel.getComponentCount());
    }
}
