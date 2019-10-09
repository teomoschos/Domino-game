
package dominogame;

import java.util.Scanner;

/**
 *Η συγκεκριμενη κλαση ,κλαση UserInterface,πραγματοποιει την αλλιλεπιδραση 
 * του χρηστη με το περιβαλλον παιχνιδιου.Μεσω ενος μενου επιλογων,του δινει 
 * την δυνατοτητα να επιλεξει ποιο απο τα δυο παιχνιδια,Hungarian ή Solo1,θα παιξει
 * καθως και την επιλογη να ολοκληρωσει την διαδικασια του παιχνιδιου.
 *@author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ (ΑΕΜ 2980)
 *@author ΜΙΧΑΗΛ ΒΛΑΧΟΣ (ΑΕΜ 2879)
 */
public class UserInterface {
    Scanner scanner;
    int choise;
    UserInterface(){
     scanner=new Scanner(System.in);
     choise=-1;
    }
    

/**
 * Η συγκεκριμενη μεθοδος start,δινει στον χρηστη την δυνατοτητα επιλογων,για τα 
 * αντιστοιχα παιχνιδια.Αρχικα, μεσω της μεθοδου showMenu ο χρηστης βλεπει τις επιλογες 
 * τις οποιες εχει,και στη συνεχεια μεσω των μεθοδων getChoise και playChoise ,
 * ο χρηστης διαλεγει το παιχνιδι το οποιο θα παιξει,καθως και το ποτε θα σταματησει να παιζει.
 */
public void start(){
    do {
      showMenu();  
      getChoise();
      playChoise();
    } while (choise!=0);

}
/**
 * Η συγκεκριμενη μεθοδος showMenu,δειχνει στον χρηστη τις επιλογες,τις 
 * οποιες εχει στην διαθεση του.Πιο συγκεκριμενα ,ο χρηστης εχει 3 επιλογες ,οι
 * οποιες ειναι να επιλεξει το Ουγγρικο παιχνιδι,να επιλεξει το Solo1 παιχνιδι
 * και να επιλεξει να βγει απο το αντιστοιχο παιχνιδι το οποιο επελεξε και ουσιαστικα 
 * να τερματησει το προγραμμα.
 */
private void showMenu(){
   System.out.printf("%nSelect the type of domino game you want to play.%n");
   System.out.printf("1.Solo1%n");
   System.out.printf("2.Hungarian (versus 1 Bot)%n");
   System.out.printf("%n0.Exit%n");
   System.out.printf("Type:");
}

/**
 * Η συγκεκριμενη μεθοδος getChoise,επιστρεφει την επιλογη του χρηστη.
 * Ακριβεστερα,ελεγχει εαν η επιλογη του χρηστη ειναι μεσα στα επιτρεπτα ορια 
 * επιλογων και εφοσον το κανει αυτο μεσω της showMenu,δειχνει στον χρηστη
 * τις επιλογες που εχει ,ζητοντας επειτα καθε φορα απο τον χρηστη μια νεα επιλογη,
 * επιστρεφοντας καθε φορα την επιλογη του.
 * @return choise η εκαστοτε επιλογη του χρηστη.
 */
private int getChoise(){
 choise=scanner.nextInt();
 while (choise<0 || choise>2)
    {
      showMenu(); 
      choise=scanner.nextInt();
    }
 return choise;
}
/**
 * Η συγκεκριμενη μεθοδος playChoise,επιτελει την αναλογη διαδικασια ,
 * αναλογα με την επιλογη του χρηστη.Εαν ο χρηστης δωσει την επιλογη 1,τοτε 
 * μεσω ενος αντικειμενου solo1 τυπου Solo1 , που δημιουργουμαι  χρησιμοποιουμαι την 
 * Solo1Start για να ξεκινησουμε το παιχνιδι Solo1.Σε περιπτωση που ο χρηστης
 * δωσει την επιλογη 2,τοτε παλι μεσω ενος αντικειμενου hungarian τυπου Hungarian ,
 * που δημιουργουμε χρησιμοποιουμε την HungarianStart για να ξεκινησουμε το 
 * παιχνιδι Hungarian.Τελος,εαν ο χρηστης δωσει την επιλογη 0,τοτε εμφανιζουμε ενα 
 * καταλληλο μυνημα τερματισμου του παιχνιδιου.
 */
private void playChoise(){
    switch (choise) {
        case 1:
        {
          System.out.printf("%nLoading Solo1...%n%n");
          Solo1 solo1=new Solo1();
          solo1.Solo1Start();
          break;
        }
        case 2:
        {
          System.out.printf("%nLoading Hungarian...%n%n");
          Hungarian hungarian=new Hungarian();
          hungarian.HungarianStart();
          break;
        }
        case 0:
        {
            System.out.printf("%nExiting game...%n");
        }
    }
    
}

}