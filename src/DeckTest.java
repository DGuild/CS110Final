public class DeckTest{

   public static void main(String[] args){
      Deck d = new Deck();
      
      d.printDeck();
      
      System.out.println(d.getSize());
      
      Card topCard = d.removeCard();
      
      System.out.println("" + topCard.getSuit() + topCard.getRank());  
      
      d.shuffle();
      d.printDeck();
      
   }

}