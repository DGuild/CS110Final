public class Player{

   private String name;
   private Hand playerDeck;
   private DiscardPile discardPile;
   
   public Player(String name){
      setName(name);
      this.playerDeck = new Hand();
      this.discardPile = new DiscardPile();
   }
   
   public String getName(){
      return this.name;
   }
   
   public Hand getHand(){
      return playerDeck;
   }
   
   public DiscardPile getDiscardPile(){
      return discardPile;
   }

   public void setName(String name){
      this.name = name;
   }
   
   public void setHand(Deck d){
      this.playerDeck = new Hand(d);
   }
   
   
}