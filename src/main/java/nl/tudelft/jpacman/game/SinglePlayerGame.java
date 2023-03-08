package nl.tudelft.jpacman.game;

import java.util.List;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.points.PointCalculator;

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
    private final List<Level> listlevel;

    private Level level;
    private int MAP_NUMBER = 0;

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
        this.listlevel = level;
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
        }
        this.level.removeObserver(this);
        this.level = listlevel.get(MAP_NUMBER);
        this.level.registerPlayer(player);

    }

    @Override
    public void levelWon() {

        nextState();
        stop();

    }

    @Override
    public void levelLost() {

        stop();

    }

    @Override
    public Level getLevel() {
        return this.level;
    }

}
