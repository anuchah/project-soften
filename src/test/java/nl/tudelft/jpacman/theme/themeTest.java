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
        ThemeSet jp = ThemeSet.valueOf("JAPAN");
        assertEquals(jp,ThemeSet.JAPAN);
    }
    @Test
    public void testSelectThemeHalloween() {
        ThemeSet h = ThemeSet.valueOf("HALLOWEEN");
        assertEquals(h,ThemeSet.HALLOWEEN);
    }
    @Test
    public void testSelectThemeCity() {
        ThemeSet c = ThemeSet.valueOf("CITY");
        assertEquals(c,ThemeSet.CITY);
    }
    @Test
    public void testSelectThemeDefault() {
        ThemeSet de = ThemeSet.valueOf("DEFAULT");
        assertEquals(de,ThemeSet.DEFAULT);
    }

}
