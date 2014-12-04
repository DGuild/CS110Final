/**
* A subclass of Deck. Represents a player's discard pile
* in a game of War
*/
import java.util.*;
public class DiscardPile extends Deck{
   
   /**
   * Constructs a discard pile as an empty list of cards
   */
   public DiscardPile(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   }
   
   /**
   * Empties the Discard Pile
   */
   public void clear(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   }
   
}