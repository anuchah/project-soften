package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.theme.ThemeSet;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    private final JButton btnPauseButton = new JButton();
    private final DialogPause dialogPause = new DialogPause(this);
    private final JButton btnContinue = new JButton();
    private final JButton btnBackhome = new JButton();

    /**
     * The panel displaying the game.
     */
    private final BoardPanel boardPanel;

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
    private CardLayout cardLayout = new CardLayout();
    // create a panel to hold the cards
    private JPanel cardPanel = new JPanel();
    // create a panel to hold the buttons
    private JPanel buttonPanel = new JPanel();
    // create two buttons to switch between cards
    private ThemeSet themeSet = ThemeSet.DEFAULT;
    private JPanel homePanel = new JPanel();
    private JLabel title = new JLabel("PacMan");
    private final Game game;
    private JPanel GamePlay = new JPanel();

    private HomeUI homeUI = new HomeUI();
    // create btn home conection to Gameplay
    private JButton btnStart = new JButton(new ImageIcon("src\\main\\resources\\button\\startbutton.png"));
    private JButton btnMapBack = new JButton();
    private JButton btnThemeBack = new JButton();

    private ThemeUI themeUI = new ThemeUI();
    Timer timer;
    private JDialog dialogDead;

    JDialog dialogWon;
    private LostPage LostPage = new LostPage();
    private WinPage WinPage = new WinPage();
    // Lost Page
    JButton lostbackhomeButton = new JButton();
    JButton restartButton = new JButton();

    // win page
    JButton winbackhomeButton = new JButton();

    JButton btnTheme = new JButton();

    // Map Select UI
    private MapSelectUI mapSelectUI = new MapSelectUI();
    private String mapName;
    private JButton map0 = new JButton("map 0");
    private JButton map1 = new JButton("map 1");
    private JButton map2 = new JButton("map 2");
    private JButton map3 = new JButton("map 3");
    private JButton map4 = new JButton("map 4");

    DialogCountDown countdown;

    public PacManUI(Game game, final Map<String, Action> buttons,
            final Map<Integer, Action> keyMappings,
            ScoreFormatter scoreFormatter) {

        assert game != null;
        assert buttons != null;
        assert keyMappings != null;
        this.game = game;

        btnContinue.setIcon(new ImageIcon("src/main/resources/button/resumebtn.png"));
        btnBackhome.setIcon(new ImageIcon("src/main/resources/button/quit1.png"));
        dialogPause.addBackhomeButton(btnBackhome);
        dialogPause.addContinueButton(btnContinue);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // addCard Layout to Card Panel
        cardPanel.setLayout(cardLayout);
        setTitle("Pac-Man Game");
        ImageIcon icon = new ImageIcon("src/main/resources/button/pacmanIcon.png");
        setIconImage(icon.getImage());

        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        JPanel buttonPanel = new ButtonPanel(buttons, this);

        scorePanel = new ScorePanel(game.getPlayers());
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }
        btnPauseButton.addActionListener(this);
        scorePanel.addPauseButton(btnPauseButton);
        btnBackhome.addActionListener(this);
        btnContinue.addActionListener(this);
        // Crete GamePlayUI
        boardPanel = new BoardPanel(game, buttons);
        GamePlay.setLayout(new BorderLayout());
        boardPanel.setOpaque(false);
        GamePlay.add(scorePanel, BorderLayout.NORTH);
        GamePlay.add(boardPanel, BorderLayout.CENTER);
        boardPanel.setBackground(ThemeSet.DEFAULT.getPathBackgroundGamplay());

        btnStart.setBackground(new Color(0, 0, 0, 0));

        // create btn home conection to seclecttheme
        themeUI.addThemeButton("src\\main\\resources\\button\\og.png", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                scorePanel.setFontColor(Color.WHITE);
                themeSet = ThemeSet.DEFAULT;
                setAllTheme();
                cardLayout.show(cardPanel, "home");

            }
        }, 1, 0);
        themeUI.addThemeButton("src\\main\\resources\\button\\" + 2 + ".png", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                scorePanel.setFontColor(Color.BLACK);
                themeSet = ThemeSet.Temple1;
                setAllTheme();
                cardLayout.show(cardPanel, "home");
            }
        }, 1, 1);
        themeUI.addThemeButton("src\\main\\resources\\button\\" + 3 + ".png", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                scorePanel.setFontColor(Color.BLACK);
                themeSet = ThemeSet.Temple2;
                setAllTheme();
                cardLayout.show(cardPanel, "home");
            }
        }, 1, 2);
        themeUI.addThemeButton("src\\main\\resources\\button\\" + 4 + ".png", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                scorePanel.setFontColor(Color.WHITE);
                themeSet = ThemeSet.Temple3;
                setAllTheme();
                cardLayout.show(cardPanel, "home");
            }
        }, 2, 0);
        themeUI.addThemeButton("src\\main\\resources\\button\\" + 5 + ".png", new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                scorePanel.setFontColor(Color.BLACK);
                themeSet = ThemeSet.Temple4;
                setAllTheme();
                cardLayout.show(cardPanel, "home");
            }
        }, 2, 1);
        btnThemeBack.addActionListener(this);
        themeUI.backBtn("src/main/resources/button/backbtn.png", btnThemeBack, 3, 1);

        // add BTN to lost page
        restartButton.addActionListener(this);
        LostPage.addButton("src/main/resources/button/restartbtn.png", restartButton, 1, 0);
        lostbackhomeButton.addActionListener(this);
        LostPage.addButton("src/main/resources/button/quit1.png", lostbackhomeButton, 2, 0);
        // add btn to win page
        winbackhomeButton.addActionListener(this);
        WinPage.addButton("src/main/resources/button/quit1.png", winbackhomeButton, 1, 2);
        // setBackground btn HomeUI
        btnStart.setIcon(new ImageIcon("src\\main\\resources\\button\\startbutton.png"));
        btnTheme.setIcon(new ImageIcon("src\\main\\resources\\Theme\\buttontheme.png"));
        btnPauseButton.setIcon(new ImageIcon("src/main/resources/button/plausebutton.png"));
        btnPauseButton.setOpaque(false);
        btnPauseButton.setBorderPainted(false);
        btnPauseButton.setFocusPainted(false);
        btnPauseButton.setContentAreaFilled(false);

        btnTheme.setFocusPainted(false);
        btnTheme.setMargin(new Insets(400, 0, 5, 0));
        btnStart.addActionListener(this);
        btnTheme.addActionListener(this);
        btnMapBack.addActionListener(this);

        map1.addActionListener(this);
        map4.addActionListener(this);
        map3.addActionListener(this);
        map2.addActionListener(this);
        map0.addActionListener(this);

        mapSelectUI.addMapButton("src/main/resources/stage/s1.png", map0, 1, 0);
        mapSelectUI.addMapButton("src/main/resources/stage/s2.png", map1, 1, 1);
        mapSelectUI.addMapButton("src/main/resources/stage/s3.png", map2, 1, 2);
        mapSelectUI.addMapButton("src/main/resources/stage/s4.png", map3, 2, 0);
        mapSelectUI.addMapButton("src/main/resources/stage/s5.png", map4, 2, 1);
        // add Back to home button in Map Select
        mapSelectUI.backBtn("src/main/resources/button/backbtn.png", btnMapBack, 3, 1);

        homeUI.setBackground(ThemeSet.DEFAULT.getPathBackgroundHome());
        homeUI.addButton(btnTheme);
        homeUI.addButton(btnStart);
        cardPanel.add(homeUI, "home");
        cardPanel.add(mapSelectUI, "map select");
        cardPanel.add(GamePlay, "gameplay");
        cardPanel.add(themeUI, "theme");
        cardPanel.add(LostPage, "lost");
        cardPanel.add(WinPage, "win");
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
    public void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();

        // check Game Lost
        if (game.isLost()) {
            LostPage.setScore(game.getScore());
            cardLayout.show(cardPanel, "lost");
            game.setLost(false);

        }
        if (game.isWon()) {
            WinPage.setScore(game.getScore());
            cardLayout.show(cardPanel, "win");
            game.setWon(false);

        }

    }

    public String getSelectedMapName() {
        return mapName;
    }

    // Handle Button
    @Override
    public void actionPerformed(ActionEvent e) {
        // start btn
        if (e.getSource() == btnStart) {
            cardLayout.show(cardPanel, "map select");
        }
        // btnTheme
        else if (e.getSource() == btnTheme) {
            cardLayout.show(cardPanel, "theme");
        } else if (e.getSource() == btnMapBack) {
            cardLayout.show(cardPanel, "home");
        } else if (e.getSource() == btnThemeBack) {
            cardLayout.show(cardPanel, "home");
        }
        // GoHome
        else if (e.getSource() == winbackhomeButton) {
            game.reStart();
            cardLayout.show(cardPanel, "home");
        }
        // restart
        else if (e.getSource() == restartButton) {
            cardLayout.show(cardPanel, "gameplay");
            game.reStart();
            CountdownToStart(3000, game);

        }
        // back
        else if (e.getSource() == lostbackhomeButton) {
            game.reStart();
            cardLayout.show(cardPanel, "home");

        }
        // map
        else if (e.getSource() == map0) {
            mapName = "Maha-Ud";
            scorePanel.setMapName(mapName);
            game.setMap(0);
            game.reStart();

            cardLayout.show(cardPanel, "gameplay");
            CountdownToStart(5000, game);

        } else if (e.getSource() == map1) {
            mapName = "Takrut Ton";
            scorePanel.setMapName(mapName);
            game.setMap(1);
            game.reStart();
            cardLayout.show(cardPanel, "gameplay");
            CountdownToStart(5000, game);

        } else if (e.getSource() == map2) {
            mapName = "Chatra Phet";
            scorePanel.setMapName(mapName);
            game.setMap(2);
            game.reStart();

            cardLayout.show(cardPanel, "gameplay");
            CountdownToStart(5000, game);
        } else if (e.getSource() == map3) {
            mapName = "Phokkasub";
            scorePanel.setMapName(mapName);
            game.setMap(3);
            game.reStart();
            cardLayout.show(cardPanel, "gameplay");
            CountdownToStart(5000, game);
        } else if (e.getSource() == map4) {
            mapName = "Praphutnimit";
            scorePanel.setMapName(mapName);
            game.setMap(4);
            game.reStart();

            cardLayout.show(cardPanel, "gameplay");
            CountdownToStart(5000, game);
        }
        // pause
        else if (e.getSource() == btnPauseButton) {
            game.stop();

            dialogPause.Visible();
            if (countdown.isRun()) {
                countdown.stopTime();
            }

        } else if (e.getSource() == btnContinue) {
            dialogPause.Disible();
            if (!countdown.isRun() && countdown.getCount() != 0) {
                countdown.startTime();
            } else {
                this.requestFocus();
                game.start();
            }
        } else if (e.getSource() == btnBackhome) {
            countdown.Dispose();
            game.stop();
            dialogPause.Disible();
            cardLayout.show(cardPanel, "home");

        }

    }

    private void CountdownToStart(int time, Game game) {
        // Check if a countdown dialog is already visible
        if (countdown != null) {
            countdown.setCount(time / 1000);
            countdown.setLocationRelativeTo(this);
            countdown.Visible();

        } else {
            countdown = new DialogCountDown(this, time, game);
            countdown.setLocationRelativeTo(this);
            countdown.Visible();

        }

    }

    private void setAllTheme() {
        game.setTheme(themeSet);
        homeUI.setBackground(themeSet.getPathBackgroundHome());
        boardPanel.setBackground(themeSet.getPathBackgroundGamplay());
        WinPage.setBackground(themeSet.getPathBackgroundWin());
        LostPage.setBackground(themeSet.getPathBackgroundLost());
        scorePanel.setBackground(themeSet.getPathBanner());
        dialogPause.setBackground(themeSet.getPathPause());
        btnPauseButton.setIcon(new ImageIcon(themeSet.getPathPauseBtn()));
        btnContinue.setIcon(new ImageIcon(themeSet.getPathResumeBtn()));
        btnBackhome.setIcon(new ImageIcon(themeSet.getPathQuitBtn()));
        restartButton.setIcon(new ImageIcon(themeSet.getPathRestartBtn()));
        lostbackhomeButton.setIcon(new ImageIcon(themeSet.getPathQuitBtn()));
        winbackhomeButton.setIcon(new ImageIcon(themeSet.getPathQuitBtn()));
    }

}
