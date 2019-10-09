
package dominogame;

import java.util.ArrayList;

/**
 *Η συγκεκριμενη κλαση ,κλαση Player,διαχειριζεται το χερι ενως παιχτη
 * με την χρηση της δομης ArrayList με αντικειμενα τυπου tile και και
 * διαχειριζεται τους ποντους του παιχτη.
 * 
 * 
 * @author  ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Player {
    private ArrayList<Tile> hand;
    private int points; 
    /**
     * Ο κατασκευαστης δημιουργει ενα νεο χερι για τον παιχτη και μηδενιζει 
     * τους αρχικους ποντους του παιχτη.
     */
    Player(){
        hand=new ArrayList<>();
        points=0;
    }
    /**
     * Η μεθοδος,getHand,επιστρεφει το τρεχων χερι(hand) του παιχτη.
     * @return hand το χερι του παιχτη.
     */
    public ArrayList<Tile> getHand(){
        return hand;
    }
    
    /**
     * Η μεθοδος,sumHand,επιστρεφει το αθροισμα των πλακιδιων του χεριου (hand) του παιχτη.
     * @return sum το αθροισμα των πλακιδιων του χεριου του παιχτη.
     */
    public int sumHand(){
        int sum=0;
        for (Tile tile : hand)
        {
          sum+=tile.tileSum();
        }
        return sum;
    }
    
    /**
     *  Η μεθοδος,setHand,δεχεται ως ορισμα ενα ArrayList απο tile
     * και το αναθετει στο χερι (hand) του παιχτη.
     * @param x το χερι που θα ανατεθει στο παιχτη.
     */
    public void setHand(ArrayList <Tile> x){
        hand=x;
    }
    /**
     *  Η μεθοδος,showHand,εμφανιζει το τρεχων χερι του παιχτη.
     */
    public void showHand(){
        System.out.printf("Current Hand :");
        for (Tile tile : hand)
        {
            System.out.printf(" ("+tile.getHead()+","+tile.getTail()+") ");
        }
        System.out.printf("%n                 ");
        for(int i=1;i<=hand.size();i++)
        {
          if (i<9)
          System.out.printf(i+".     ");  
          else
           System.out.printf(i+".    ");     
        }
        System.out.printf("%n");
    }
    /**
     * Η μεθοδος,getPoints,επιστρεφει τους ποντους του παιχτη.
     * @return points οι ποντοι το παιχτη.
     */     
    public int getPoints(){
        return points;
    }
    
    /**
     * Η μεθοδος,addPoints,δεχεται ως ορισμα εναν ακεραιο x και
     * τον προσθετει στους ποντους του παιχτη.
     * @param x η αυξηση στους ποντους του παιχτη.
     */
    public void addPoints(int x){
       points+=x;
    }
     /**
      * Η μεθοδος,hasMove,δεχεται ως ορισμα μια μεταβλητη τυπου Board
      * που αναπαριστα το τρεχων ταπμλο και ελεχγει αν υπαρχει καποια
      * διαθεσιμη κινηση στο χερι του παιχτη ,και στην περιπτωση 
      * που υπαρχει επιστρεφει τη θεση της,διαφορετικα -1.
      * @param board το τρεχων ταμπλο
      * @return τη θεση πλακιδιου που μπορει να τοπεθετηθει
      */
    public int hasMove(Board board){
        int pos=0;
        for (Tile tile : hand)
        {
            if (board.tileFits(tile)>0)
                return pos;
            pos++;
        }
        return -1;
    }
    /**
     * Η μεθοδος,removeFromHand,δεχεται ως ορισμα μια ακεραια θεση n 
     * και αν αυτη ειναι στα ορια του χεριου του παιχτη αφαιρεθει το 
     * αντιστοιχο πλακιδιο απο χερι του παιχτη.Και επιστρεφει αν η
     * αφαιρεση ηταν επιτυχης η οχι.
     * @param n η θεση προς αφαιρεση
     * @return αν ηταν επιτυχης η αφαιρεση
     */
    public boolean removeFromHand(int n){
      if (n<0 || n>hand.size()-1)
          return false;
      hand.remove(n);
          return true;
 }
 /**
  * Η μεθοδος αυτη,maxDouble,επιστρεφει την τιμη του μεγιστου διπλου πλακιδιου
  * στο χερι του παιχτη ,αν ο παιχτης δεν εχει κανεναν διπλο επιστρεφεται η τιμη -1.
  * @return max το μεγιστο διπλο το παιχτη
  */
    public int maxDouble(){
     int max=-1;
     for(Tile tile : hand)
     {
         if(tile.isDouble() && tile.getHead()>max)
             max=tile.getHead();
             
     }
  return max;
 }
 /**
  * Η μεθοδος αυτη,maxSum,επιστρεφει την τιμη του μεγιστου αθροισματος απο τα
  * πλακιδια που βρισκονται στο χερι του παιχτη.
  * @return max το μεγιστο αθροισμα πλακιδιου στο  χερι του παιχτη
  */
    public int maxSum(){
     int max=-1;
     for(Tile tile : hand)
     {
         if(tile.tileSum()>max)
             max=tile.getHead()+tile.getTail();
             
     }
  return max;
 }

}
