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
public class BoardTest {
    
    /**
     * Test of addTile method, of class Board.
     */
    @Test
    public void testAddTile() {
        Tile tile = new Tile(5,4);
        Board board = new Board();
        boolean expResult = true;
        boolean result = board.addTile(tile);
        assertEquals(expResult, result);
        
        tile=new Tile(6,3);
        boolean expResult2 = false;
        boolean result2 = board.addTile(tile);
        assertEquals(expResult2, result2);
        
        
        tile=new Tile(4,3);
        boolean expResult3 = true;
        boolean result3 = board.addTile(tile);
        assertEquals(expResult3, result3);
        
        
    }

    /**
     * Test of tileFits method, of class Board.
     */
    @Test
    public void testTileFits() {
        Tile tile = new Tile(1,3);
        Board board = new Board();
        int expResult = 1;
        int result = board.tileFits(tile);
        assertEquals(expResult, result);
        
        
        tile = new Tile(3,2);
        int expResult2=1;
        int result2=board.tileFits(tile);
        assertEquals(expResult2, result2);
        
        
        tile=new Tile(1,5);
        board.addTile(tile);
        tile=new Tile (1,6);
        board.addTile(tile);
        tile=new Tile(6,5);
        int expResult3=2;
        int result3=board.tileFits(tile);
        assertEquals(expResult3, result3);
        

        
        
    }



}
