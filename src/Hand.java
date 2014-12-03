import java.util.*;
public class Hand extends Deck{

   public Hand(Deck d){
      super.setCards(d.getCards());
   }
   
   public Hand(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   
   }
   
   public Card playCard(){
      Card card = super.removeCard();
      return card;
   
   }
}