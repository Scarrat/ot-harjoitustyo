package dg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kostajoo
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import dg.*;
public class dungeonTest {
    Dungeon dug;
    
    @Before
    public void setUp() {
        dug = new Dungeon();
    }
    
    @Test
    public void dungEntryCorrect() {
        int[][] arr = dug.floor();
        assertEquals(arr[4][2], 0);
    }
}
