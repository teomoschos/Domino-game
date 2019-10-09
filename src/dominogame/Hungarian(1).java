
package dominogame;


import java.util.Scanner;


/**Η κλαση αυτη,Hungarian,υλοποιει την παραλλαγη Ουγγρικο του παιχνιδιου domino.
 * Στην παραλλαγη αυτη ο παιχτης παιζει εναντιον ενως Bot και προσπαθει να συγκεντρωσει
 * πρωτος 100 ποντους.Ξεκινα ο παιχτης με το μεγαλυτερο διπλο ωσπου να μην μπορει να τοποθετησει
 * αλλα,στην συνεχει παιζει ο αλλος παιχτης,μεχρι κανεις να μην μπορει να τοποθετησει αλλα.
 * Ο παιχτης με τους λιγοτερους ποντους στο τελος του γυρου κερδιζει τους ποντους του αντιπαλου του
 * Σε περιπτωση ισων ποντων στο τελος του γυρου οι ποντοι προστιθενται και στους δυο παιχτες.
 *@author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ (ΑΕΜ 2980)
 *@author ΜΙΧΑΗΛ ΒΛΑΧΟΣ (ΑΕΜ 2879)
 */
public class Hungarian {
   private Stack stack;
   private Board board;
   private Player human;
   private Bot bot;
   private int plays;
   private Scanner scanner;
   /**Ο κατασκευαστης δημιουργει ενα αντικειμενο της Stack απο το οποιο οι παιχτες θα 
    * τραβουν τα πλακιδια τους.Δημιουργει ενα ταμπλο τυπου Board και εναν παιχτη Player 
    * και ενα Bot.
    * 
    */
   Hungarian(){
       stack=new Stack(true);
       board=new Board();
       human=new Player();
       bot=new Bot();
       plays=-1;
       scanner=new Scanner(System.in);
   }
   /**
    * Η μεθοδος,HungarianStart,αρχικα καλει την μεθοδο dealTiles για να μοιραασει
    * τα πλακιδια στους παιχτες.Στην συνεχει καλει την μεθοδο playsFirst για βρει
    * ποιος παιχτης ξεκιναει πρωτος.Οσο υπαρχει διαθεσιμη κινηση καλει την μεθοδο
    * play.Στο τελος καλει τις μεθοδους updatePoints,updateMessage,nextRound 
    * για να ανανεωθουν οι ποντοι,ο χρηστης με ενα μηυνμα και ο επομενος γυρος αντιστοιχα.
    * Εκτελει την παραπανω διαδικασια μεχρι καποιος να κερδισει.
    * 
    */
    public void HungarianStart(){
        do
       {
           dealTiles();         
           plays=playsFirst();
           while (moveExists())
           {
             play();
           }
           updatePoints();
           updateMessage();
           nextRound();
       } while (!Won());
        finalmessage();
    }     
    /**
     * Η μεθοδος,nextRound, επαναδημιουργει το stack με τα πλακιδια και το ταμπλο
     * καθως και το εμφανιζει.
     */
    private void nextRound(){
       stack=new Stack(true);
       board=new Board();
       board.showBoard();
   }

    /**
     * Η μεθοδος,dealTiles,μοιραζει τα πλακιδια απο το stack στα χερια των παιχτων
     */
    private void dealTiles(){
        human.setHand(stack.drawTiles(12));
        bot.player.setHand(stack.drawTiles(12));
   }
   /**
    * Η μεθοδος,playsFirst,αναλογα με το ποιος εχει το μεγαλυτερο διπλο 
    * πλακιδιο επιστρεφει το ποιος παιχτης παιζει πρωτος
    * (0 για τον χρηστη και 1 για το Bot)
    * @return ποιος παιχτης παιζει πρωτος
    */
    private int playsFirst(){
       int max=human.maxDouble();
           if (bot.player.maxDouble()>max)
           {
               System.out.printf("Bot plays first.%n");
               return 1;
           }
        System.out.printf("You play first.%n");
       return 0;
       }
    /**
     * Η μεθοδος,minPoints,επιστρεφει ποιος παιχτης εχει τους λιγοτερους
     * ποντους στο χερι του.Αν εχουν τους ιδιους ποντους επιστρεφεται -1.
     * Αν ο χρηστης εχει λιγοτερους ποντους επιστρεφεται 0.Διαφορετικα επιστρεφεται 1.
     * 
     * @return ποιος παιχτης εχει λιγοτερους ποντους
     */
    private int minPoints(){
       int min=human.sumHand();
           if (bot.player.sumHand()<min)
           {
              return 1;
           }
           if (bot.player.sumHand()==min)
           {
               return -1;
           }
       return 0;
   }
 
    /**
     * Η μεθοδος,play,αναλογα με  ποιανου παιχτη σειρα ειναι καλειται και η ανιστοιχη μεθοδος
     * για να ζητηθει εισοδος απο τον καταλληλο παιχτη μεχρι να μην εχει αλλη κινηση ο παιχτης
     * αυτος και να παιξει ο επομενος παιχτης
     */
    private void play(){
                  switch (plays) {
                     case 0:
                     {
                         System.out.printf("Your turn...%n");
                         System.out.printf("Βοt has : "+bot.player.getHand().size()+" tiles%n");
                         while (human.hasMove(board)>-1)
                         {                       
                             humanPlay();
                         }
                      plays=1;
                      break;
                     }
                     case 1:
                     {
                       System.out.printf("Bot playing...%n");
                       while (bot.player.hasMove(board)>-1)
                       {
                        bot.botMove(board);
                       }
                      board.showBoard();
                      plays=0;
                      break;
                     }
             }
           }  
    
    /**
     * Η μεθοδος,humanPlay,καλειται οταν ειναι η σειρα το χρηστη να παιξει και του εμφανιζει
     * το χερι του και τον ταμπλο και του ζητα ποιο απο τα πλακιδια του θελει να παιξει μεχρι να παρει
     * μια επιτρεπτη απαντηση.
     */
    private void humanPlay(){
       System.out.printf("Bot has "+bot.player.getHand().size()+" tiles");
       System.out.printf("%n %n");
       human.showHand();
       boolean fits=false;
       System.out.printf("Select the domino you want to play :");
       int choise=scanner.nextInt();
       Tile tile=new Tile(-1,-1);
       while (!fits)
       {
       while (choise<1 || choise>human.getHand().size())
        {
          System.out.printf("Wrong input.%n");
          System.out.printf("Select the domino you want to play :");
          choise=scanner.nextInt();
        }
       tile=human.getHand().get(choise-1);
       if (board.tileFits(tile)>0)
           fits=true;
       else 
       {
           System.out.printf("Tile does not fit to the board.%n");
           System.out.printf("Select the domino you want to play :");
           choise=scanner.nextInt();
       }
          
       }
       board.addTile(tile);
       human.removeFromHand(choise-1);
       board.showBoard();
       
   }
 /**
  * Η μεθοδος,updatePoints,καλει την μεθοδοο minPoints για να δει ποιος παιχτης κερδισε τον γυρο,
  * αναλογα με το αποτελεσμα της προστιθενται ο ποντοι στον νικητητη του γυρου.Σε περιπρτωση ισοπαλιας
  * στον γυρο και οι δυο παιχτες παιρνουν τους ποντους.
  */
    private void updatePoints(){
        int winsround=minPoints();
           switch (winsround) {
               case -1:
               {
                   human.addPoints(bot.player.sumHand());  
                   bot.player.addPoints(human.sumHand());
                   break;
               }
               case 0:
               {
                   human.addPoints(bot.player.sumHand());
                   break;
               }
               case 1:
               {
                   bot.player.addPoints(human.sumHand());
                   break;
               } 
           }
    }
    /**
     * Η μεθοδος,updateMessage,εμφανιζει οτι ενας γυρος μολις τελιωσε καθως και ενημερωνει
     * τον χρηστη για τους ποντους του και τους ποντους του Bot
     */
    private void updateMessage(){
           System.out.printf("%n%nRound over.%n");
           System.out.printf("You have "+human.getPoints()+" points.%n");
           System.out.printf("Bot has "+bot.player.getPoints()+" points.%n%n");
}
   /**
    * Η μεθοδος,moveExists,επιστρεφει μια λογικη τιμη για το
    * αν ενας απο τους παιχτες εχει καποια διαθεσιμη κινηση.
    * @return αν υπαρχει κινηση
    */
    private boolean moveExists(){
        return (human.hasMove(board)>-1 || bot.player.hasMove(board)>-1);
    }
   
    /**
     * Η μεθοδος,Won,επιστρεφει μια λογικη τιμη για το αν ενας απο τους παιχτες εχει
     * υπερβει τους 100 ποντους.
     * @return αν καποιος παιχτης ξεπερασε τους 100 ποντους
     */
    private boolean Won(){
        return (human.getPoints() > 100 || bot.player.getPoints() > 100);
    }
    /**
     * Η μεθοδος,finalmessage,ενημερωνει τον παιχτη για το ποιος νικησε το παιχνιδι
     */
    private void finalmessage(){
        if (human.getPoints()>bot.player.getPoints())
        {
             System.out.printf("%n%nYou won :)%n");
             System.out.printf("%n%nYou scored "+human.getPoints()+" points.%n");
             System.out.printf("%n%nBot scored "+bot.player.getPoints()+" points.%n");
             
        }
        else if (human.getPoints()<bot.player.getPoints())
        {
             System.out.printf("%n%nYou lost :( %n");
             System.out.printf("%n%nYou scored "+human.getPoints()+" points.%n");
             System.out.printf("Bot scored "+bot.player.getPoints()+" points.%n");
              
        }
        else
        {
           System.out.printf("%n%nThe match was tie!!%n");
           System.out.printf("%n%nYou both scored "+human.getPoints()+" points.%n");     
        }
    }
}

