package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

//import javafx.scene.layout.Background;

import javax.swing.*;
//import net.bytebuddy.asm.Advice.This;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.theme.ThemeSet;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen
 *
 */
public class PacManUI extends JFrame implements ActionListener {

    /**
     * Default serialisation UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The desired frame rate interval for the graphics in milliseconds, 40
     * being 25 fps.
     */
    private static final int FRAME_INTERVAL = 40;

    /**
     * The panel displaying the player scores.
     */
    private final ScorePanel scorePanel;

    /**
     * The panel displaying the game.
     */
    private final BoardPanel boardPanel;

    public static String BACKGROUND_PATH = "src\\main\\resources\\Theme\\background0.jpg";
    public static String BOARDBACKGROUND_PATH = "src\\main\\resources\\Theme\\black.jpg";

    /**
     * Creates a new UI for a JPacman game.
     *
     * @param game
     *                       The game to play.
     * @param buttons
     *                       The map of caption-to-action entries that will appear
     *                       as
     *                       buttons on the interface.
     * @param keyMappings
     *                       The map of keyCode-to-action entries that will be added
     *                       as key
     *                       listeners to the interface.
     * @param scoreFormatter
     *                       The formatter used to display the current score.
     * 
     * 
     * 
     */

    // create a card layout
    CardLayout cardLayout = new CardLayout();
    // create a panel to hold the cards
    JPanel cardPanel = new JPanel();
    // create a panel to hold the buttons
    JPanel buttonPanel = new JPanel();
    // create two buttons to switch between cards

    JPanel homePanel = new JPanel();
    JLabel title = new JLabel("PacMan");
    final Game game;
    JPanel GamePlay = new JPanel();
    HomeUI homeUI = new HomeUI();
    ThemeUI themeUI = new ThemeUI();

    JButton btnStart = new JButton();
    JDialog dialogDead;
    // custom dialog dead
    JButton backButton = new JButton("Back");
    JButton restartButton = new JButton("Restart");
    JButton homeButton = new JButton("Exit");
    JButton btnTheme = new JButton();
    // custom dialog dead

    public PacManUI(Game game, final Map<String, Action> buttons,
            final Map<Integer, Action> keyMappings,
            ScoreFormatter scoreFormatter) {

        assert game != null;
        assert buttons != null;
        assert keyMappings != null;
        this.game = game;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // addCard Layout to Card Panel
        cardPanel.setLayout(cardLayout);

        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        JPanel buttonPanel = new ButtonPanel(buttons, this);

        scorePanel = new ScorePanel(game.getPlayers());
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }
        // Crete GamePlayUI
        boardPanel = new BoardPanel(game);
        GamePlay.setLayout(new BorderLayout());
        boardPanel.setOpaque(false);
        GamePlay.add(buttonPanel, BorderLayout.SOUTH);
        GamePlay.add(scorePanel, BorderLayout.NORTH);
        GamePlay.add(boardPanel, BorderLayout.CENTER);
        boardPanel.setBackground(BOARDBACKGROUND_PATH);

        // create btn home conection to Gameplay
        JButton btnStart = new JButton(new ImageIcon("src\\main\\resources\\button\\startbutton.png"));
        btnStart.setBackground(new Color(0, 0, 0, 0));
        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

                cardLayout.show(cardPanel, "gameplay");
            }

        });
        // create btn home conection to seclecttheme


        // create btn home conection to seclecttheme
        themeUI.addThemeButton("src\\main\\resources\\Theme\\default.jpg", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Theme: " + ThemeSet.DEFAULT);
                game.setTheme(ThemeSet.DEFAULT);
                BACKGROUND_PATH = "src\\main\\resources\\Theme\\background0.jpg";
                homeUI.setBackground(BACKGROUND_PATH);
                boardPanel.setBackground(BOARDBACKGROUND_PATH);
                cardLayout.show(cardPanel, "home");
            }

        }, 1, 0);
        themeUI.addThemeButton("src\\main\\resources\\Theme\\background" + 1 + ".jpg", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Theme: " + ThemeSet.HALLOWEEN);
                game.setTheme(ThemeSet.HALLOWEEN);
                BACKGROUND_PATH = "src\\main\\resources\\Theme\\background1.jpg";
                homeUI.setBackground(BACKGROUND_PATH);
                boardPanel.setBackground(BACKGROUND_PATH);
                cardLayout.show(cardPanel, "home");
            }

        }, 1, 1);
        themeUI.addThemeButton("src\\main\\resources\\Theme\\background" + 2 + ".jpg", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Theme: " + ThemeSet.JAPAN);
                game.setTheme(ThemeSet.JAPAN);
                BACKGROUND_PATH = "src\\main\\resources\\Theme\\background2.jpg";
                homeUI.setBackground(BACKGROUND_PATH);
                boardPanel.setBackground(BACKGROUND_PATH);
                cardLayout.show(cardPanel, "home");
            }
        }, 2, 0);
        themeUI.addThemeButton("src\\main\\resources\\Theme\\background" + 3 + ".jpg", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Theme: " + ThemeSet.CITY);
                game.setTheme(ThemeSet.CITY);
                BACKGROUND_PATH = "src\\main\\resources\\Theme\\background3.jpg";
                homeUI.setBackground(BACKGROUND_PATH);
                boardPanel.setBackground(BACKGROUND_PATH);
                cardLayout.show(cardPanel, "home");
            }
        }, 2, 1);
        // setBackground btn HomeUI
        btnStart.setIcon(new ImageIcon("src\\main\\resources\\button\\startbutton.png"));
        btnTheme.setIcon(new ImageIcon("src\\main\\resources\\Theme\\buttontheme.png"));

        btnStart.setBackground(new Color(0, 0, 0, 0));
        btnTheme.setBackground(new Color(0, 0, 0, 0));
        btnStart.setOpaque(true);
        btnTheme.setOpaque(true);
        btnStart.addActionListener(this);
        btnTheme.addActionListener(this);

        homeUI.setBackground(BACKGROUND_PATH);
        homeUI.addButton(btnTheme);
        homeUI.addButton(btnStart);
        cardPanel.add(homeUI, "home");
        cardPanel.add(GamePlay, "gameplay");
        cardPanel.add(themeUI, "theme");
        add(cardPanel);
        pack();

    }

    /**
     * Starts the "engine", the thread that redraws the interface at set
     * intervals.
     */
    public void start() {
        setVisible(true);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
    }


    /**
     * Draws the next frame, i.e. refreshes the scores and game.
     */
    private void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();
        if (game.isLost()) {
            game.setLost(false);
            dialogDead = new JDialog();
            dialogDead.setLayout(new BorderLayout());
            dialogDead.add(new JLabel("You Dead ", SwingConstants.CENTER), BorderLayout.NORTH);
            dialogDead.add(new JLabel("Your Score :  " + game.getScore(), SwingConstants.CENTER), BorderLayout.CENTER);
            // Create a JPanel for the buttons
            JPanel buttonPanel1 = new JPanel();
            dialogDead.setSize(300, 200);
            // Set the location of the dialog
            dialogDead.setLocationRelativeTo(this);
            // Create a JButton for restarting
            homeButton.addActionListener(this);
            buttonPanel1.add(restartButton);
            buttonPanel1.add(homeButton);
            dialogDead.add(buttonPanel1, BorderLayout.SOUTH);

            restartButton.addActionListener(this);
            dialogDead.setVisible(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            cardLayout.show(cardPanel, "gameplay");
        } else if (e.getSource() == btnTheme) {
            cardLayout.show(cardPanel, "theme");
        } else if (e.getSource() == homeButton) {
            game.reStart();
            dialogDead.setVisible(false);
            cardLayout.show(cardPanel, "home");
            dialogDead.removeAll();
        } else if (e.getSource() == restartButton) {
            dialogDead.setVisible(false);
            game.reStart();
            dialogDead.removeAll();
        } else if (e.getSource() == backButton) {
            game.reStart();
            dialogDead.setVisible(false);
            cardLayout.show(cardPanel, "home");
            dialogDead.removeAll();
        }

    }
}
