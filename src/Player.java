/**
* Represents a Player in War
*/
public class Player{

   private String name;
   private Hand playerDeck;
   private DiscardPile discardPile;
   
   /**
   * Constructs a Player given a name
   * @param name The Player's name
   */
   public Player(String name){
      setName(name);
      this.playerDeck = new Hand();
      this.discardPile = new DiscardPile();
   }
   
   /**
   * Returns the Player's name
   * @return the Player's name
   */
   public String getName(){
      return this.name;
   }
   
   /**
   * Returns the Player's hand
   * @return the Player's hand
   */
   public Hand getHand(){
      return playerDeck;
   }
   
   /**
   * Returns the Player's DiscardPile
   * @return the Player's DiscardPile
   */ 
   public DiscardPile getDiscardPile(){
      return discardPile;
   }

   /**
   * Sets the Players name to the given String
   * @param name The name of the Player
   */
   public void setName(String name){
      this.name = name;
   }
   
   /**
   * Sets the Player's hand to the given Deck
   * @param d The Deck
   */
   public void setHand(Deck d){
      this.playerDeck = new Hand(d);
   }
   
   
}