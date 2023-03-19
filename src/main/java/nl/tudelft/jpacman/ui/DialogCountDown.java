package nl.tudelft.jpacman.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.*;

import nl.tudelft.jpacman.game.Game;

public class DialogCountDown extends JDialog {

    private Timer timer;
    private int count = 5;
    private JLabel label;

    public DialogCountDown(JFrame owner, double time, Game g) {
        super(owner);
        Game game = g;
        setUndecorated(true); // remove window decorations
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DialogCountDown.DO_NOTHING_ON_CLOSE);
        count = (int) (time / 1000);

        label = new JLabel(String.valueOf(count), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 130));
        label.setForeground(Color.WHITE);
        add(label);
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                System.out.print(count);
                label.setText(String.valueOf(count));
                if (count <= 0) {
                    timer.stop();
                    setVisible(false);
                    game.start();
                    owner.requestFocusInWindow();
                    count = (int) (time / 1000);
                    dispose();

                    ;

                }
            }
        });

        pack();

    }

    public void Visible() {
        setVisible(true);
        timer.start();
    }

    public void setCount(int count) {
        this.count = count;
        label.setText(String.valueOf(count));
    }

    public void Dispose() {
        dispose();
        timer.stop();
    }

}