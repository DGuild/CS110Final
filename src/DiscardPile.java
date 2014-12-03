import java.util.*;
public class DiscardPile extends Deck{
   
   public DiscardPile(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   }
   
   public void clear(){
      ArrayList<Card> c = new ArrayList<Card>(0);
      super.setCards(c);
   }
   
}