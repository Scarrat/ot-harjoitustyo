
package dg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class playerTest {
    Player p;

    @Before
    public void setUp() {
        p = new Player();
    }

    @Test
    public void healthGoDown() {
        p.healthChange(-3);
        assertEquals(p.getHealth(), 7);
    }

    @Test
    public void healthGoUp() {
        p.healthChange(-3);
        p.healthChange(2);
        assertEquals(p.getHealth(), 9);
    }

    @Test
    public void setLocWorks() {
        p.setLoc(3, 2);
        assertEquals(p.getX(), 3);
        assertEquals(p.getY(), 2);
    }
}
