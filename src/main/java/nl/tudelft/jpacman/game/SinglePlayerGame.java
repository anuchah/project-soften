package nl.tudelft.jpacman.game;

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

    private Level level;

    private Launcher launcher = new Launcher();
    public ThemeSet theme = ThemeSet.ORIGINAL;
    private int mapNum = 0;

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
    protected SinglePlayerGame(Player player, Level level, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert level != null;

        this.player = player;
        this.level = level;

        this.level.registerPlayer(player);
    }

    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }

    @Override
    public void levelWon() {
        this.setWon(true);

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
        startGame(mapNum);
        player.setAlive(true);
        reSetScore();

    }

    @Override
    public void reSetScore() {
        player.reSetScore();
    }

    private void startGame(int mapNum) {
        level = launcher.makeLevel(theme, mapNum);
        level.registerPlayer(player);
        level.addObserver(this);

    }

    @Override
    public int getScore() {
        return player.getScore();
    }

    public void setTheme(ThemeSet themeSet) {
        theme = themeSet;
        startGame(mapNum);
        reStart();
    }

    public void setMap(int mapnum) {
        this.mapNum = mapnum;

    }

}
