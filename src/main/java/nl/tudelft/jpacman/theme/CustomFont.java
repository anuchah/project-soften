package nl.tudelft.jpacman.theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomFont {

    private static final String fileName = "src/main/resources/fonts/crackman.front.ttf";
    private static final String fileName2 = "src/main/resources/fonts/PixeloidMono-VGj6x.ttf";
    private float sizeFont = 14f;

    private Font customFont;

    public CustomFont() {
        super();
    }

    public Font fontFormat(){
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fileName2));
            customFont = customFont.deriveFont(getSizeFont());

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        }catch (FontFormatException ignored){

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customFont;
    }

    public float getSizeFont(){
        return sizeFont;
    }

    public void setSizeFont(float sizeFont){
        this.sizeFont = sizeFont;
    }


}
