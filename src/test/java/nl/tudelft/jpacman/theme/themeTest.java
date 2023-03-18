package nl.tudelft.jpacman.theme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

public class themeTest {
    PacManSprites p = new PacManSprites();

    @Test
    public void testSelectThemeJapan() {
        ThemeSet jp = ThemeSet.valueOf("Temple1");
        assertEquals(jp, ThemeSet.Temple1);
    }

    @Test
    public void testSelectThemeHalloween() {
        ThemeSet h = ThemeSet.valueOf("Temple2");
        assertEquals(h, ThemeSet.Temple2);
    }

    @Test
    public void testSelectThemeCity() {
        ThemeSet c = ThemeSet.valueOf("Temple3");
        assertEquals(c, ThemeSet.Temple3);
    }

    @Test
    public void testSelectThemeDefault() {
        ThemeSet de = ThemeSet.valueOf("DEFAULT");
        assertEquals(de, ThemeSet.DEFAULT);
    }

}
