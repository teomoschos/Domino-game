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
public class PlayerTest {
    

    /**
    * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        Player player = new Player();
        ArrayList<Tile> expResult = new ArrayList<>();
        ArrayList<Tile> result = player.getHand();
        assertEquals(expResult, result);
        
        Stack stack=new Stack(false);
        Tile tile=new Tile(0,0);
        player.setHand(stack.drawTiles(1));
        ArrayList<Tile> exphand=new ArrayList<>();
        exphand.add(tile);
        boolean expResult2=true;
        boolean result2;
        result2=(player.getHand().get(0).getHead()==exphand.get(0).getHead() && player.getHand().get(0).getTail()==exphand.get(0).getTail());
        assertEquals(expResult2, result2);
        
        
    }

    /**
     * Test of sumHand method, of class Player.
     */
    @Test
    public void testSumHand() {
        Player player = new Player();
        int expResult = 0;
        int result = player.sumHand();
       assertEquals(expResult, result);
      
       
       Tile tile=new Tile(2,3);
       Tile tile2=new Tile(4,5);
       ArrayList<Tile> temp=new ArrayList<>();
       temp.add(tile);
       temp.add(tile2);
       player.setHand(temp);
       int expResult2 = 14;
       int result2 = player.sumHand();
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of setHand method, of class Player.
     */
    @Test
    public void testSetHand() {
        ArrayList<Tile> x = new ArrayList<>();
        Player player = new Player();
        player.setHand(x);
        ArrayList<Tile> expResult= new ArrayList<>();
        ArrayList<Tile> result=player.getHand();
        assertEquals(expResult,result);
        
       Tile tile=new Tile(3,5);
       ArrayList<Tile> temp=new ArrayList<>();
       temp.add(tile);
       player.setHand(temp);
       boolean expResult2=true;
       boolean result2=(player.getHand().get(0).getHead()==3 && player.getHand().get(0).getTail()==5);
       assertEquals(expResult2,result2);
       
       
        
        
    }

    /**
     * Test of addPoints and getPoints methods, of class Player.
     */
    @Test
    public void testAddAndGetPoints() {
        Player player = new Player();
        int expResult = 0;
        int result = player.getPoints();
        assertEquals(expResult, result);
        
        
        player.addPoints(10);
        int expResult2 = 10;
        int result2 = player.getPoints();
        assertEquals(expResult2, result2);

    }



    /**
     * Test of removeFromHand method, of class Player.
     */
    @Test
    public void testRemoveFromHand() {
        Player player = new Player();
        boolean expResult = false;
        boolean result = player.removeFromHand(0);
        assertEquals(expResult, result);
        
        Stack stack=new Stack(false);
        player.setHand(stack.drawTiles(2));
        player.removeFromHand(0);
        ArrayList <Tile> temp=player.getHand();
        Tile tile=new Tile(0,1);
        
        boolean expResult2=true;
        boolean result2=(player.getHand().get(0).getHead()==0 && player.getHand().get(0).getTail()==1);
        assertEquals(expResult2, result2);
                
        
        
        
    }

    /**
     * Test of maxDouble method, of class Player.
     */
    @Test
    public void testMaxDouble() {
        Player player = new Player();
        int expResult = -1;
        int result = player.maxDouble();
        assertEquals(expResult, result);
        
        Stack stack=new Stack(false);
        player.setHand(stack.drawTiles(28));
        int expResult2=6;
        int result2=player.maxDouble();
         assertEquals(expResult2, result2);
    
        
    }

    /**
     * Test of maxSum method, of class Player.
     */
    @Test
    public void testMaxSum() {
        Player player = new Player();
        int expResult = -1;
        int result = player.maxSum();
        assertEquals(expResult, result);
        
        Stack stack=new Stack(false);
        player.setHand(stack.drawTiles(28));
        int expResult2=12;
        int result2=player.maxSum();
         assertEquals(expResult2, result2);
    }
    
}
