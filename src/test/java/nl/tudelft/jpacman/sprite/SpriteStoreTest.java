package nl.tudelft.jpacman.sprite;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class SpriteStoreTest {

    private SpriteStore spriteStore;
    private Map<String, Sprite> spriteMapMock;

    @Before
    public void setUp() {
        spriteStore = new SpriteStore();
        spriteMapMock = mock(HashMap.class);
    }

    @Test
    public void testLoadSprite() throws IOException {
        String resource = "/path/to/image.png";
        Sprite expectedSprite = mock(Sprite.class);
        spriteStore.spriteMap = spriteMapMock;

        // When sprite is not already loaded
        when(spriteMapMock.get(resource)).thenReturn(null);
        when(spriteStore.loadSpriteFromResource(resource)).thenReturn(expectedSprite);
        Sprite resultSprite = spriteStore.loadSprite(resource);

        assertEquals(expectedSprite, resultSprite);
        verify(spriteMapMock).put(resource, expectedSprite);

        // When sprite is already loaded
        reset(spriteMapMock);
        when(spriteMapMock.get(resource)).thenReturn(expectedSprite);
        resultSprite = spriteStore.loadSprite(resource);

        assertEquals(expectedSprite, resultSprite);
        verify(spriteMapMock, never()).put(any(), any());
    }

    @Test
    public void testCreateAnimatedSprite() {
        Sprite baseImage = mock(Sprite.class);
        int frames = 4;
        int delay = 100;
        boolean loop = true;

        AnimatedSprite animatedSprite = spriteStore.createAnimatedSprite(baseImage, frames, delay, loop);

        assertEquals(frames, animatedSprite.getNumberOfFrames());
        assertEquals(delay, animatedSprite.getDelay());
        assertEquals(loop, animatedSprite.isLooping());
    }
}

