
package dominogame;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Η κλαση αυτη,Solo1,υλοποιει την παραλλαγη Solo1 του παιχνιδιου domino.
 * Στην παραλλαγη αυτη ο παιχτης  παιζει μονος του και προσπαθει να τοποθετησει 
 * ολα τα πλακιδια.Τα πλακιδια τοποθετονυται σε σχημα ορθογωνιο ,διαστασης
 * 4x7 και εμφανιζονται στο παιχτη.Ο παιχτης ξεκινα να παιζει το κανονικο παιχνιδι ντομινο
 * παιρνοντας παντα ενα απο τα 4 διαθεσιμα πλακιδια που βρισκονται δεξιοτερα σε καθε σειρα.
 * Συνεχει να παιζει μεχρι να τοποθετησει ολα τα ντομινο η να μη μπορει να τοποθετησει αλλο.
 * @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Solo1 {
   private ArrayList <ArrayList<Tile>> tiles;
   private Stack stack;
   private Board board;
   private Player player;
   private Scanner scanner;
    /**
     * Ο κατασκευαστης δημιουργει ενα αντικειμενο τυπου stack το οποιο θα γεμισει  την δομη
     * που χρησιμοποιεται για την αποθηκευση ολων των διαθεσιμων πλακιδιων.Δημιουργει ενα ταμπλο τυπου 
     * board στο οποιο θα τοποθετουνται τα πλακιδια καθως και ενα Player.Αφου δημιουργηθει
     * η δομη που περιεχει ολα τα πλακιδια καλειται η μεθος setAvailable που οριζει
     * τα διαθεσιμα πλακιδια προς τοποθετηση.
     */
    Solo1(){
       stack=new Stack(true);
       board=new Board();
       tiles=new ArrayList<>();
       player=new Player();
       scanner=new Scanner(System.in);
       for (int i=0;i<4;i++)
        {
          tiles.add(stack.drawTiles(7)); 
        }
       setAvailable();
   }
   /**
    * Η μεθοδος αυτη,Solo1Start,οσο ο παιχτης μπορει να τοποθετησει καποιο απο 
    * τα διαθεσιμα πλακιδια καλει τις μεθοδους showTiles και getMove.Τελος οταν
    * δεν υπαρχει αλλη διαθεσιμη κινηση καλειται η μεθοδος finalmessage
    */
    public void Solo1Start(){
        while (player.hasMove(board)>-1)
        {
        showTiles();
        getMove();
       }
        finalmessage();
    }
    /**
     * Η μεθοδος αυτη,setAvailabe,θετει ως χερι του παιχτη τα 4 δεξιοτερα 
     * πλακιδια απο την καθε σειρα διαθεσιμων πλακιδιων.
     */
    private void setAvailable(){
        ArrayList <Tile> x=new ArrayList<>();
        for (int i=0;i<4;i++)
        {
            if (tiles.get(i).size()>0) 
            x.add(tiles.get(i).get(tiles.get(i).size() -1));
        }
        player.setHand(x);
    }
    
    /**
     * Η μεθοδους αυτη,getMove,ρωταει τον χρηστη ποιο πλακιδιο θελει να τοποθετησει
     * και στην συνεχεια καλει την μεθοδο playtile με τηνανιστοιχη επιλογη.Αναλογα με 
     * το αποτελεσμα της μεθοδου εκτελειται μια διαφορετικη ενεργεια.
     * Αν η επιλογη του χρηστη ειναι μη επιτρεπτη εμφανιζεται το ανιστοιχο μηνυμα σφαλματος.
     * Αν το πλακιδιο εχει τοποθετηθει αυξανει τους ποντους του παιχτη κατα 1.
     * (οπου οι ποντοι εκφραζουν τα ποσα πλακιδια εχουν τοποθετηθει επιτυχως)
     */
    private void getMove(){
        int choise=scanner.nextInt();
        int x=playTile(choise);
        if (x<1 && player.hasMove(board)>-1)
        {
          if (x==-1)
          System.out.printf("Input out of boundaries.%n");  
          else
          System.out.printf("Tile does not fit to the board.%n"); 
              
        }
        else
        {
            player.addPoints(1);
        }
    }
     /**
      * Η μεθοδος αυτη,playTile,δεχεται ως ορισμα εναν ακεραιο n που εκφραζει
      * το πλακιδιου που θελει να τοποθετησει ο παιχτης.Αν η τιμη ειναι εκτος οριων
      * επιστρεφεται η τιμη -1.Αν το πλακιδιο μπορει να τοποθετηθει τοτε αφαιρεται 
      * απο τα διαθεσιμα πλακιδια και καλειται η μεθοδος setAvailable και τελος επιστρεφεται
      * η τιμη 2.Αν το πλακιδιο δε μπορει να τοποθετηθει επιστρεφεται 0.
      * @param n η σειρα του πλακιδιο προς τοποθεσηση
      * @return το αποτελεσμα της επιλογης του παιχτη
      */   
    private int playTile(int n){
     if (n<=0 || n>=5 || tiles.get(n-1).isEmpty())
         return -1;
     Tile temp=tiles.get(n-1).get(tiles.get(n-1).size() -1);
     if (board.addTile(temp))
     {
       tiles.get(n-1).remove(tiles.get(n-1).size()-1);
       setAvailable();
       return 2;
     }
     return 0;
}
 
     /**
      * Η μεθοδος,showTiles,εμφανιζει στον παιχτη ολα τα πλακιδια που δεν εχουν τοποθετηθει
      * καθως και την τρεχουσα κατατασταση του ταμλο.Και εμφανιζει στον χρηστη μηνυμα για 
      * να δωσει την επομενη επιλογη πλακιδιου.
      */
    private void showTiles(){
         board.showBoard();
        System.out.printf("%nSelect the raw of the domino you want to play :  %n");
        for (int i=0;i<4;i++)
        {
           System.out.printf((i+1)+" :");
           for (int j=0;j<tiles.get(i).size();j++)
            {
                System.out.printf(" ("+ tiles.get(i).get(j).getHead()+"," + tiles.get(i).get(j).getTail()+")");
            }
           System.out.printf("%n");
        }
         System.out.printf("%nYour choise :");
 }
 
    /**
     * Η μεθοδος,finalmessage,εμφανιζει στον χρηστη ενα τελικο μηνυμα.
     * Αν ο χρηστης εχει βαλει ολα τα πλακιδια του εμφανιζεται καταλληλο μηνυμα
     * ,διαφορετικα του εμφανιζει ποια πλακιδια δεν χρησιμοποιησε και την τελικη
     * μορφη του ταμπλο.
     */
    private void finalmessage(){
     int temp=player.getPoints();
     if (temp ==28)
      System.out.printf("You won!! :)  %nAll dominons were used.%n %n %n");
     else
     {
     System.out.printf("You lose :( %nFinal Board : %n");
        board.showBoard();
        System.out.printf("%nDominos not used :  %n");
        for (int i=0;i<4;i++)
        {
            System.out.printf((i+1)+" :");
           for (int j=0;j<tiles.get(i).size();j++)
            {
                System.out.printf(" ("+ tiles.get(i).get(j).getHead()+"," + tiles.get(i).get(j).getTail()+")");
            }
           System.out.printf("%n"); 
        }
 }
 }
    

}