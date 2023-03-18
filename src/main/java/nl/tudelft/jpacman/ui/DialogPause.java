package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class DialogPause extends JDialog {

    public DialogPause() {

        this.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Pause Game");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Serif", Font.BOLD, 20);
        label.setFont(font);

        // Add the label above the first button
        GridBagConstraints cl = new GridBagConstraints();
        cl.gridx = 0;
        cl.gridy = 0;

        this.add(label, cl);

        // Set the dialog size and visibility
        this.setSize(300, 200);

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
        this.add(btn, c1);
    }

    public void addBackhomeButton(JButton btn) {
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 3;
        c1.insets = new Insets(5, 5, 5, 5);
        this.add(btn, c1);
    }
}