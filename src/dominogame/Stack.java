
package dominogame;

import java.util.ArrayList;
import java.util.Collections;
/**
 *Η συγκεκριμενη καλση ,κλαση Stack,υλοποιει μια στοιβα απο ντομινο 
 * ,η οποια υλοποιεται με ενα ArrayList απο αντικειμενα tile,
 * απο την οποια οι παιχτες τραβουν πλακιδια για παιξουν καποια 
 * παραλλαγη.
 * @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Stack {
    private  ArrayList<Tile> tiles;
    /**
     * Η συγκεκριμενη μεθοδος,αποτελει τον κατασκευαστη της συγκεκριμενης 
     * κλασης Stack ,και δημιουργει ενα ArrayList με τις τιμες ενως
     * σετ 28 πλακιδιων και στην συνέχεια αναλογα με την τιμη της λογικης
     * μεταβλτητης shuffle ειτε ανακατέβει τα πλακιδια  με τη χρηση της μεθοδου ShufflesStack
     * ,είτε αφηνει τα πλακιδια με τη σειρα που κατασκευαστηκαν
     */
    Stack(boolean shuffle){
       tiles=new ArrayList<>();
       Tile temp;
       for (int i=0;i<7;i++)
         {
          for (int j=i;j<7;j++)
            {
             temp=new Tile(i,j);
             tiles.add(temp); 
            } 
         }
       if (shuffle)
       ShuffleStack();
      }
      /**
       * Η συγκεκριμενη μεθοδος ShuffleStack,δεχεται μια λογικη μεταλβητη και αναλογα 
       * με την τιμη της ειτε θα ανακατευει στη στοιβα,δηλαδη θα ανατοποθετει την σειρα
       * των πλακιδιων τα οποια βρισκονται τοποθετημενα μεσα στην
       * δομη του ΑrrayList,δηλαδη του σωρου των πλακιδιων που εχουμε,ή
       * θα την επιστεφει κανονικα χωρις ανακατεμα.
       */
    private void ShuffleStack(){
        Collections.shuffle(tiles);
    }
       /**
        * Η συγκεκριμενη μεθοδος Remove,πραγματοποιει την αφαιρεση 
        * ενος πλακιδιου απο την υπαρχουσα στοιβα πλακιδιων.Αν η αφαιρεση
        * ηταν επιτυχης επιστρεφη την λογικη τιμη true ,σε διαφορετικη 
        * περιπτωση επιστρεφει false
        * @return αν ηταν επιτυχης η αφαιρεση
        */
    private boolean Remove(){
        if (tiles.size()>0)
        {
         tiles.remove(0);
         return true;
        }
       return false;
    }
    /**
     * Η συγκεκριμενη μεθοδος drawTiles,δεχεται τον αριθμο πλακιδιων 
     * που επιθυμει να τραβηξει ο παιχτης,τραβωντας παντα απο την 
     * κορυφη της στοιβας,και επιστρεφει ενα ArrayList απο tiles με οσα πλακιδια ζητησε.
     * @param n πληθος των πλακιδιων που θελει να τραβηξει ο παιχτης.
     * @return hand αποτελει το συνολο πλακιδιων που διαθετει ο παιχτης.
     */
    public ArrayList<Tile> drawTiles(int n){
        ArrayList<Tile> hand=new ArrayList<>();
        if (n==0)
            return null;
        for (int i=0;i<n & tiles.size()>0;i++)
        {
            hand.add(getFirst());
            Remove();
        }
        return hand;
    }
    /**
     * Η συγκεκριμενη μεθοδος getFirst,επιστρεφει το πρωτο πλακιδιο της
     * στοιβας.Αν η στοιβα ειναι άδεια επιστρεφει null
     * @return το πρωτο στοιχειο της στοιβας
     */
    private Tile getFirst(){
        if (tiles.size()>0)
        {
            return tiles.get(0);
        }     
        return null;
    }
   
}
