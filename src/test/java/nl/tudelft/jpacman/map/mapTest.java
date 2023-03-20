package nl.tudelft.jpacman.map;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.MapSelectUI;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class mapTest {

    Launcher map = new Launcher();
    MapSelectUI ui = new MapSelectUI();

    @Test
    public void testFistMap(){
        assertEquals("/board0.txt", map.getLevelMap(0));
    }
    @Test
    public void testSecondMap(){
        assertEquals("/board1.txt", map.getLevelMap(1));
    }
    @Test
    public void testSecMap(){
        assertEquals("/board2.txt", map.getLevelMap(2));
    }
    @Test
    public void testThirdMap(){
        assertEquals("/board3.txt", map.getLevelMap(3));
    }
    @Test
    public void testFourthMap(){
        assertEquals("/board4.txt", map.getLevelMap(4));
    }

    @Test
    public void testButton(){

    }


}
