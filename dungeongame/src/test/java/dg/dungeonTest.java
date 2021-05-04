package dg;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class dungeonTest {
   Dungeon d;
    @Before
    public void setUp() {
        d = new Dungeon();
    }
    
    @Test
    public void dungCorrectSize() {
        assertEquals(d.floor().length, 5);
    }
    
    @Test
    public void dungMovement() {
        
    }
}
