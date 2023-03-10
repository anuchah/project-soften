package nl.tudelft.jpacman.game;

import java.util.ArrayList;
import java.util.List;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.theme.ThemeSet;

/**
 * A game with one player and a single level.
 *
 * @author Jeroen Roosen
 */
public class SinglePlayerGame extends Game {

    /**
     * The player of this game.
     */
    private final Player player;

    /**
     * The level of this game.
     */
    private List<Level> listlevel;

    private Level level;
    private int MAP_NUMBER = 0;
    private Launcher launcher = new Launcher();
    public ThemeSet theme = ThemeSet.HALLOWEEN;

    /**
     * Create a new single player game for the provided level and player.
     *
     * @param player
     *                        The player.
     * @param level
     *                        The level.
     * @param pointCalculator
     *                        The way to calculate points upon collisions.
     */
    protected SinglePlayerGame(Player player, List<Level> level, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert level != null;

        this.player = player;
        listlevel = level;

        this.level = listlevel.get(MAP_NUMBER);
        this.level.registerPlayer(player);
    }

    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }

    public void nextState() {
        MAP_NUMBER++;
        if (MAP_NUMBER > 4) {
            MAP_NUMBER = 0;
            reSetLevel();
        }
        this.level.removeObserver(this);
        this.level = listlevel.get(MAP_NUMBER);
        this.level.registerPlayer(player);

    }

    @Override
    public void levelWon() {
        this.setWon(true);
        nextState();
        stop();

    }

    @Override
    public void levelLost() {
        this.setLost(true);
        stop();

    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public void reStart() {
        reSetLevel();
        player.setAlive(true);
        MAP_NUMBER = -1;
        reSetScore();
        nextState();

    }

    @Override
    public void reSetScore() {
        player.reSetScore();
    }

    public void reSetLevel() {
        listlevel = launcher.makeLevel(theme);
    }

    @Override
    public int getScore() {
        return player.getScore();
    }

    public void setTheme(ThemeSet themeSet) {
        theme = themeSet;
        reSetLevel();
        reStart();
    }

}
