package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.theme.CustomFont;

/**
 * A panel consisting of a column for each player, with the numbered players on
 * top and their respective scores underneath.
 *
 * @author Jeroen Roosen
 *
 */
public class ScorePanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The map of players and the labels their scores are on.
     */
    private final Map<Player, JLabel> scoreLabels;

    /**
     * The default way in which the score is shown.
     */
    public static final ScoreFormatter DEFAULT_SCORE_FORMATTER = (Player player) -> String.format("Score: %3d",
            player.getScore());

    /**
     * The way to format the score information.
     */
    private ScoreFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;

    private String mapName = "";
    private BufferedImage backgroundImage;
    private BufferedImage btnImage;
    private JLabel stage;

    private CustomFont customFont = new CustomFont();

    /**
     * Creates a new score panel with a column for each player.
     *
     * @param players The players to display the scores of.
     *
     */
    public ScorePanel(List<Player> players) {
        assert players != null;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 75));

//        font
        customFont.setSizeFont(18f);
        Font font = customFont.fontFormat();

        for (int i = 1; i <= players.size(); i++) {
            JLabel player = new JLabel("Player " + i, JLabel.CENTER);
            // player.setForeground(Color.WHITE);
            // add(player, BorderLayout.LINE_START);
            player.setFont(font);
        }
        stage = new JLabel("Stage: " + mapName);
        stage.setFont(font);
        stage.setForeground(Color.WHITE);
        stage.setBorder(BorderFactory.createEmptyBorder(10, 100, 0, 0));
        add(stage, BorderLayout.LINE_START);

        scoreLabels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel scoreLabel = new JLabel("0", JLabel.CENTER);
            scoreLabel.setFont(font);
            scoreLabel.setForeground(Color.WHITE);
            scoreLabels.put(player, scoreLabel);
            add(scoreLabel, BorderLayout.CENTER);
        }
        // setBackground(new Color(51, 51, 51));
        setBackground("src/main/resources/Theme/banner1.png");
    }

    /**
     * Refreshes the scores of the players.
     */
    public void refresh() {
        for (Map.Entry<Player, JLabel> entry : scoreLabels.entrySet()) {
            Player player = entry.getKey();
            String score = "";
            if (!player.isAlive()) {
                score = "You died. ";
            }
            score += scoreFormatter.format(player);
            entry.getValue().setText(score);
        }
    }

    /**
     * Provide means to format the score for a given player.
     */
    public interface ScoreFormatter {

        /**
         * Format the score of a given player.
         * 
         * @param player The player and its score
         * @return Formatted score.
         */
        String format(Player player);
    }

    /**
     * Let the score panel use a dedicated score formatter.
     * 
     * @param scoreFormatter Score formatter to be used.
     */
    public void setScoreFormatter(ScoreFormatter scoreFormatter) {
        assert scoreFormatter != null;
        this.scoreFormatter = scoreFormatter;
    }

    public void addPauseButton(JButton btnPauseGame) {
        add(btnPauseGame, BorderLayout.LINE_END);
    }

    // Show State name
    public void setMapName(String mapName) {
        this.mapName = mapName;
        stage.setText("Stage: " + mapName);

    }

    public void setBackground(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
