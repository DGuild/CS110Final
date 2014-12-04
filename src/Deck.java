/**
* Represents a Deck as a list of Cards
*/
import java.util.Random;
import java.util.ArrayList;

public class Deck{

   private ArrayList<Card> cards;
   private int size;
   
   /**
   * Constructs a standard 52 card deck as a list of Card objects
   */
   public Deck(){
      this.cards = new ArrayList<Card>();
      this.buildDeck();
   }
   
   /**
   * Generates 52 unique cards and adds them to cards
   */
   public void buildDeck(){
      cards.clear();
      for(Suit suit : Suit.values()){
         for(int i = 1; i < 14; i++){
            Card c =  new Card(i, suit);
            cards.add(c);
         }
      }
      
   }
   
   /**
   * Randomizes the order Cards in the Deck
   */
   public void shuffle(){
      Card temp;
      int max = cards.size();
      Random rand = new Random();
      
      //For each position in the deck,
      //grab a random card and put it there
      for(int i = 0; i < max; i++){
         int index = rand.nextInt(max - i) + i;
         Card c = cards.get(index);//changes index-1 to just index
         temp = cards.get(i);
         cards.set(i, c);
         cards.set(index, temp);
         
      }
   }
   
   /**
   * Inserts a card into the deck
   * @param c The Card to be added
   */
   public void addCard(Card c){
      cards.add(c);
   }
   
   /**
   * Removes top card from the deck and returns the Card object
   * @return The removed card
   */
   public Card removeCard(){
      Card card = cards.get(0);
      cards.remove(0);
      return card;
      
   }
   
   /**
   * Returns the number of cards in the Deck
   * @return The number of Cards in the Deck
   */
   public int getSize(){
      return cards.size();
   }
   
   /**
   * Returns the ArrayList of Card objects
   * @return the Cards in the Deck
   */
   public ArrayList<Card> getCards(){
      return cards;
   }
   
   /**
   * Sets a Deck equal to a pre-existing ArrayList of Cards
   * @param c An ArrayList of Cards
   */
   public void setCards(ArrayList<Card> c){
      this.cards = c;
   }
   
   /**
   * Returns a Card given a (zero-based) position in the Deck
   * @param i The position in the Deck
   * @return The Card at position i
   */
   public Card getCard(int i){
      return cards.get(i);
   }
   
   
   /**
   * Prints to the console the Rank and Suit of each Card in the Deck
   */
   public void printDeck(){
      for(Card c: cards){
         System.out.print("" + c.getRank() + " " + c.getSuit());
      }
   }
   
   /**
   * Checks if the Deck is empty
   * @return True is deck has no cards
   */
   public boolean isEmpty(){
      if(cards.size() == 0) return true;
      return false;
   }  

}