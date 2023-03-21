package nl.tudelft.jpacman.theme;

import static org.junit.Assert.*;

import java.awt.Font;

import org.junit.Before;
import org.junit.Test;

public class CustomFontTest {

    private CustomFont customFont;

    @Before
    public void setUp() {
        customFont = new CustomFont();
    }

    @Test
    public void testFontFormat() {
        float size = 20f;
        customFont.setSizeFont(size);
        Font font = customFont.fontFormat();
        assertNotNull(font);
        assertEquals(size, font.getSize(), 0);
    }
}

