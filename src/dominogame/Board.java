
package dominogame;

import java.util.LinkedList;
import java.util.Scanner;

/*** Η συγκεκριμενη κλαση,κλαση Board,υλοποιει το ταμπλο των παιχνιδιων
 * πανω στο οποιο οι παιχτες τοποθετουν τα πλακιδια τους βασει της συνθηκης
 * της παραλλαγης που παιζουν.Αυτο επιτυχγανεται με την χρηση μια 
 * LinkedList απο tile την οποια χειριζεται.
 * @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ 
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Board {
    private final LinkedList <Tile> board;
    /**
     * Ο κατασκευαστης της κλασης δημιουργει μια καινουργια LinkedList απο tiles
     */
    Board(){
        board=new LinkedList<>();
    }
    /**
     * Η μεθοδος αυτη ,addTile,δεχεται ενα πλακιδιο tile και
     * επειτα απο μια σειρα ελεχγων σχετικα με το αν μπορει να τοποθετηθει
     * το δωθεν πλακιδιο στο ταμπλο (ειτε στην αρχη ειτε στο τελος) επιστρεφει την 
     * αντισχοιχη λογική τιμη και συχρωνος τοποθετει το πλακιδιο στο ταμπλο.Αν το πλακιδιο μπορει 
     * να τοποθετηθει και απο τις δυο πλευρες δινεται η επιλογη στον χρηστη για το που 
     * να τοποθετηθει.Αν το ταμπλο ειναι αδειο το πλακιδιο τοποθειται.
     * @param tile το πλακιδιο προς τοποθετηση
     * @return αν ηταν επιτυχης η τοποθετηση του πλακιδιου
     */
    public boolean addTile(Tile tile){
       if (board.isEmpty())
       {
           board.add(tile);
           return true;
       }
       int times=tileFits(tile);
       if (times==2)
       {
         int choise=fitsBothMenu();
         if (choise==1)
         {
             addToFirst(tile);
             return true;
         }
         else if(choise==2)
         {
             addToLast(tile);
             return true;
         }
         
       }
       else if (times==1)
       {
           boolean x=addToFirst(tile);
           if (!x)
               addToLast(tile);
           return true;
       }
       return false;

 } 
    /**
     * * Η μεθοδος αυτη ,tileFits,δεχεται ενα πλακιδιο tile και
     * επειτα απο μια σειρα ελεχγων επιστρεφει το πληθος των
     * πλευρων του πλακιδιου που μπορουν να τοποθετηθουν στο ταμπλο.
     * Αν το ταμπλο ειναι αδειο επιστρεφεται η τιμη 1.Και αν το πλακιδιο
     * δεν μπορει να τοποθετηθει πουθενα επιστρεφεται η τιμη 0.
     * @param tile το πλακιδιο προς ελεγχο
     * @return το πληθος των πλευρων του πλακιδιου που μπορουν να τοποθετηθουν στο ταμπλο
     */
   
    public int tileFits(Tile tile){
       if (board.isEmpty())
       {
           return 1;
       }
      Tile temp1 = board.getFirst();
      Tile temp2=board.getLast();
      if (temp1.getHead()==tile.getHead() || temp1.getHead()==tile.getTail() 
              || temp2.getTail()==tile.getHead() || temp2.getTail()==tile.getTail())
      {
        if ( (temp2.getTail()==tile.getTail() && temp1.getHead()==tile.getHead() ) 
                || (temp2.getTail()==tile.getHead() && temp1.getHead()==tile.getTail() ) ) 
          {
               if (tile.getHead()!=tile.getTail()) 
               {
                   return 2;
               }
           }
        return 1;
      }
      return 0;
 }
 
    /**
     * Η μεθοδος αυτη ,addToFirst,δεχεται ενα πλακιδιο tile και
     * επειτα απο μια σειρα ελεχγων σχετικα με το αν μπορει να τοποθετηθει
     * το δωθεν πλακιδιο στην αρχη του ταμπλο ,τοτε το τοποθετει και επιστρφει
     * την λογικη τιμη true ,σε καθε αλλη περιπτωση επιστρεφει false
     * @param tile το πλακιδιο προς τοποθετηση στην αρχη του ταμπλο
     * @return αν το πλακιδιο τοποθετηθηκε
     */
    public boolean addToFirst(Tile tile){
           Tile temp;
           temp=getFirstTile();
                if (temp.getHead()==tile.getHead())
                    {
                     tile.flipNumbers();
                     board.addFirst(tile);
                     return true;
                    }
                  else if (temp.getHead()==tile.getTail())
                    {
                      board.addFirst(tile);
                      return true;
                    }
        return false;
   }
   
        /**
     * Η μεθοδος αυτη ,addToLast,δεχεται ενα πλακιδιο tile και
     * επειτα απο μια σειρα ελεχγων σχετικα με το αν μπορει να τοποθετηθει
     * το δωθεν πλακιδιο στο τελος του ταμπλο ,τοτε το τοποθετει και επιστρφει
     * την λογικη τιμη true ,σε καθε αλλη περιπτωση επιστρεφει false
     * @param tile το πλακιδιο προς τοποθετηση στο τελος του ταμπλο
     * @return αν το πλακιδιο τοποθετηθηκε
     */
    public boolean addToLast(Tile tile){
           Tile temp;
           temp=getLastTile();
             if (temp.getTail()==tile.getHead())
             {
                 board.addLast(tile);
                 return true;
             }
             else if (temp.getTail()==tile.getTail())
             {
                 tile.flipNumbers();
                 board.addLast(tile);
                 return true;
             }
        return false;
   }
  /**
   * Η μεθοδος αυτη ,getFirstTile ,επιστρεφει το πρωτο πλακιδιο του ταμπλο.
   * Αν το ταμπλο ειναι αδειο επιστρεφει null
   * @return το πρωτο πλακιδιο του ταμπλο
   */
    private Tile getFirstTile(){
     if (!board.isEmpty())
         return board.getFirst();
     return null;
 }

   /**
   * Η μεθοδος αυτη ,getLast ,επιστρεφει το τελευταιο πλακιδιο του ταμπλο.
   *  Αν το ταμπλο ειναι αδειο επιστρεφει null
   * @return το τελευταιο πλακιδιο του ταμπλο
   */
    private Tile getLastTile(){
          if (!board.isEmpty())
         return board.getLast();
     return null;  
 }

    /**
     * Η μεθοδος αυτη ,showBoard,εμφανιζει τη τρεχουσα κατατασταση του 
     * ταμπλο.
     */
    public void showBoard(){
    int i;
    Tile tile;
    System.out.printf("Current board state :%n");
    for (i=0;i<board.size();i++)
    {
      tile=board.get(i);
      System.out.printf("-("+tile.getHead()+"," + tile.getTail() +")-");  
    }
    System.out.printf("%n%n");  
}

    /**
     *  Η μεθοδος αυτη ,fitsBothMenu,καλειται οταν ενα πλακιδιο μπορει να 
     * τοποθετηθει και στις δυο ακρες του ταμπλο και ζητα απο τον χρηστη
     * να του δωσει την πλευρα στην οποια θελει να το τοποθετησει.
     * @return choise η επιλογη του χρηστη
     */
    private int fitsBothMenu(){
        int choise;
        System.out.printf("Tile fits both ways.%n");
        System.out.printf("1.Add to First%n");
        System.out.printf("2.Add to Last%n");
        Scanner scanner=new Scanner(System.in);
        choise=scanner.nextInt();
        while (choise<1 || choise>2)
        {
         System.out.printf("Tile fits both ways.%n");
         System.out.printf("1.Add to First%n");
         System.out.printf("2.Add to Last%n");
         choise=scanner.nextInt();
        }    
        return choise;
    }

} 

   
 