
package dominogame;


/**
 *Η συγκεκριμενη κλαση,κλαση DominoGame,πραγματοποιει την 
 * εναρξη του αντιστοιχου παιχνιδιου,το οποιο θα επιλεξει
 * καθε φορα, να παιξει ο παικτης.
 * @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 * @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class DominoGame {

    /**
     * Η συγκεκριμενη μεθοδος main,δημιουργει ενα αντικειμενο ui τυπου 
     * UserInterface ,μεσω του οποιου χρησιμοποιειται η μεθοδος start,και ετσι
     * ουσιαστικα πραγματοποιειται η εναρξη του αντιστοιχου παιχνιδιου.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       UserInterface ui=new UserInterface();
       ui.start(); 

}
    


}