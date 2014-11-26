import java.util.Random;
import java.util.ArrayList;

public class Deck{

   private ArrayList<Card> cards;
   private int size;
   
   public Deck(){
      this.cards = new ArrayList<Card>();
      this.buildDeck();
   }
   
   public void buildDeck(){
      cards.clear();
      for(Suit suit : Suit.values()){
         for(int i = 1; i < 14; i++){
            Card c =  new Card(i, suit);
            cards.add(c);
         }
      }
      
   }
   
   public void shuffle(){
      Card temp;
      int max = cards.size();
      Random rand = new Random();
      
      //For each position in the deck,
      //grab a random card and put it there
      for(int i = 0; i < max; i++){
         int index = rand.nextInt(max - i) + i;
         Card c = cards.get(index - 1);
         temp = cards.get(i);
         cards.set(i, c);
         cards.set(index, temp);
         
      }
   }
   
   public void addCard(Card c){
      cards.add(c);
   }
   
   public Card removeCard(){
      Card card = cards.get(0);
      cards.remove(0);
      return card;
   }
   
   public int getSize(){
      return cards.size();
   }
   
   public void printDeck(){
      for(Card c: cards){
         System.out.print("" + c.getRank() + " " + c.getSuit());
      }
   }

}