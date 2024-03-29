
package dominogame;

/**
 *Η συγκεκριμενη κλαση ,κλαση Tile ,αναφερεται στα πλακιδια των  παιχνιδιων, 
 * και πιο συγκεκριμενα αναφερεται στους δυο αριθμους του καθε πλακιδιου (head και tail) ,
 * τα οποια τα χρησιμοποιουμαι στα αντιστοιχα παιχνιδια.
 * 
 @author ΜΟΣΧΟΣ ΘΕΟΔΩΡΟΣ
 @author ΜΙΧΑΗΛ ΒΛΑΧΟΣ
 */
public class Tile {
    private int head;
    private int tail;
    
   /**
    * Ο κατασκευαστης δεχεται δυο αριθμους n1 και n2 και τους αναθέτει 
    * στο head και το tail του πλακιδιου αντιστοιχα
    * @param n1 ο αριστερος αριθμος του πλακιδιου
    * @param n2 ο δεξιος αριθμος του πλακιδιου
    */
    public Tile(int n1,int n2)
    {
        head=n1;
        tail=n2;
    }
    /**
     *Η συγκεκριμενη μεθοδος getHead,επιστρεφει την τιμη  της  αριστερης πλευρας του πλακιδιου.
     * @return head αριστερη πλευρα του πλακιδιου.
     */
    public int getHead(){
        return head;
    }
    /**
     * Η συγκεκριμενη μεθοοδος getTail,επιστρεφει την τιμη  της δεξιας πλευρας του πλακιδιου.
     * @return δεξια πλευρα του πλακιδιου.
     */
    public int getTail(){
        return tail;
    }
    /**
     * Η συγκεκριμενη μεθοδος tileSum,επιστρεφει το αθροισμα των τιμων , των δυο πλευρων ενος πλακιδιου.
     * @return αθροισμα πλευρων πλακιδιου.
     */
    public int tileSum(){
        return head+tail;
    }
    /**
     * Η συγκεκριμενη μεθοδος ,ελεγχει αν ενα πλακιδιο ειναι διπλο 
     * δηλαδη αν το head ισουται με το tail και επιστρεφει το αποτελεσμα του ελεχγου
     * @return head ειναι ιδιο με το tail
     */
    public boolean isDouble(){
        return head==tail;
    }
    /**Η συγκεκριμενη μεθοδος flipNumbers,υλοποιει την περιστροφη 
     * ενος πλακιδιου με την βοήθεια μιας μεταβλητης temp και 
     * αντιμεταθετει τις τιμες head και tail.
     */
    public void flipNumbers(){
        int temp=head;
        head=tail;
        tail=temp;
        
    }
}
