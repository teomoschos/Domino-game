
package dominogame;

import java.util.Random;

/**
 *Η συγκεκριμενη κλαση,κλαση Bot,υλοποιει εναν εικονικο παιχτη (bot) 
 * ο οποιος παιζει με τον χρηστη σε διαφορες παραλλαγες.Για την υλοποιηση
 * του χρησιμοποειται και ενα αντικειμενο τυπου Player. 
 * @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Bot {
    public Player player;
    private Random random;
    /**
     *Ο κατατασκευαστης δημιουργει εναν νεο παικτη player και μια τυχαια 
     * μεταβλητη random.
     */
    Bot(){
        player=new Player();
        random=new Random();
    }

/**
 * Η συγκεκριμενη μεθοδος botMove,δεχεται ως ορισμα ενα αντικειμενο τυπου
 * Board το οποιο αναπαριστα την τρεχουσα κατασταση του ταμπλο.Στη συνεχεια
 * ελεγχεται αν o παιχτης bot μπορει να τοποθετησει καποιο πλακιδιο και το τοποθετει.
 * Αν το πλακιδιο μπορει να τοποθετηθει και στις δυο ακρες του ταμπλο τοτε τοποθετειται
 * τυχαια σε μια απο αυτες.Αν δεν υπαρχει διαθεσιμο πλακιδιο τοτε δεν γινεται καμια αλλαγη.
 * @param board το τρεχων ταμπλο
 */
public void botMove(Board board){
       int pos=player.hasMove(board);
        if (pos>-1)
        {
          Tile tile=player.getHand().get(pos);
          int times=board.tileFits(tile);
          if (times==2)
          {
              boolean x=random.nextBoolean();
              if (x)
              board.addToFirst(tile);
              else
              board.addToLast(tile);
          }
          else
              board.addTile(tile);
          player.removeFromHand(pos);
        } 
}

}


