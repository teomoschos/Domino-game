/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominogame;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class TileTest {

    /**
     * Test of getHead method, of class Tile.
     */
    @Test
    public void testGetHead() {
        Tile tile=new Tile(3,6);
        int expResult = 3;
        int result =tile.getHead();
        assertEquals(expResult, result);
 
        
    }

    /**
     * Test of getTail method, of class Tile.
     */
    @Test
    public void testGetTail() {
        Tile tile=new Tile(2,4);
        int expResult = 4;
        int result =tile.getTail();
        assertEquals(expResult, result);
    }

    /**
     * Test of tileSum method, of class Tile.
     */
    @Test
    public void testTileSum() {
        Tile tile = new Tile(4,3);
        int expResult = 7;
        int result = tile.tileSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDouble method, of class Tile.
     */
    @Test
    public void testIsDouble() {
        Tile tile = new Tile(4,4);
        boolean expResult = true;
        boolean result = tile.isDouble();
        assertEquals(expResult, result);
        tile=new Tile(3,6);
        expResult = false;
        result = tile.isDouble();
        assertEquals(expResult, result);
    }

    /**
     * Test of flipNumbers method, of class Tile.
     */
    @Test
    public void testFlipNumbers() {
        Tile tile = new Tile (1,2);
        tile.flipNumbers();
        boolean result=(tile.getHead()==2 && tile.getTail()==1);
        boolean expResult=true;
        assertEquals(expResult,result);
    }
    
}
