/**
* Represents a player's hand in a game of war
*/
import java.util.*;
public class Hand extends Deck{

   /**
   * Constructs a Hand from a Deck of cards
   * @param d A Deck of Cards
   */
   public Hand(Deck d){
      super.setCards(d.getCards());
   }
   
   /**
   * Constructs an empty Hand
   */
   public Hand(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   
   }
   
   /**
   * Removes a card from the Hand and returns the Card object
   * @return The card that was removed from the hand
   */
   public Card playCard(){
      Card card = super.removeCard();
      return card;
   
   }
}