/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominogame;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class StackTest {
    

    /**
     * Test of drawTiles method, of class Stack.
     */
    @Test
    public void testDrawTiles() {
        Stack stack = new Stack(false);
        ArrayList<Tile> expResult = null;
        ArrayList<Tile> result = stack.drawTiles(0);
        assertEquals(expResult, result);
        
        
        stack=new Stack(false);
        Tile tile=new Tile(0,0);
        ArrayList<Tile> hand=stack.drawTiles(1);
        boolean expResult2=true;
        boolean result2;
        result2=(tile.getHead()==hand.get(0).getHead() && tile.getTail()==hand.get(0).getTail());
        assertEquals(expResult2, result2);
        
        

    }
    
}
