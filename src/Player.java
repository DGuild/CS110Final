public class Player{

   private String name;
   private Deck playerDeck;
   private Deck discardPile;
   
   public Player(String name){
      this.name = name;
   }
   
   public String getName(){
      return this.name;
   }

   public void setName(String name){
      this.name = name;
   }
   
   public void setDeck(Deck d){
      this.playerDeck = d;
   }
   
   
}