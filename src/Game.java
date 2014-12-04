/**
* Represents a Game of War with two players, a Deck of cards, and a winner
*/
import java.util.Scanner;
public class Game{
   private Player player;
   private Player computer;
   private Deck deck;
   private Player winner;
   
   /**
   * Constructs a game given two Players and a Deck of cards
   *@param p1 The human player
   *@param p2 The computer player
   *@param d The Deck
   */
   public Game(Player p1, Player p2, Deck d){
      this.player = p1;
      this.computer = p2;
      this.deck = d;
   }
   
   /**
   * Checks if the Game has a winner
   @return True if there is a winner. False otherwise.
   */
   public boolean hasWinner(){
      if(winner != null)
          return true;
      else return false;
   }
   
   /**
   * Returns the winner of the game
   @return The Player that won the game
   */
   public Player getWinner(){
      return winner;
   }
   
   /**
   * Returns the human Player
   @return The human Player
   */
   public Player getPlayer(){
      return this.player;
   }
   
   /** 
   * Returns the computer Player
   * @return the computer Player
   */
   public Player getComputer(){
      return this.computer;
   }
   
   /**
   * Returns the Game's deck
   * @return the Deck
   */
   public Deck getDeck(){
      return this.deck;
   }
   
   /**
   * Checks if either player is out of cards. If so, declares the other
   * player the winner.
   * @return The Player that won
   */
   public void setWinner(){
      if(player.getHand().getSize() == 0 && player.getDiscardPile().getSize() == 0){
         winner = computer;
      } else if (computer.getHand().getSize() == 0 && computer.getDiscardPile().getSize() == 0){
         winner = player;
      } else{
         ;
      }
   }
   
   /**
   * Evenly divides the Deck to the Hands of the two Players
   * @param d The Game's Deck
   * @param p1 The human Player
   * @param p2 The computer Player
   */
   public void cutDeck(Deck d, Player p1, Player p2){
      for(int i = 0; i < d.getSize()/2; i++){
         Card c = d.getCard(i);
         p1.getHand().addCard(c);
      }
      
      for(int i = d.getSize()/2; i < d.getSize(); i++){
         p2.getHand().addCard(d.getCard(i));
      }
   }
   
   /**
   * If Hands are empty, Places the Cards in each Player's
   * Hand from their Discard Piles
   */
   public void discardToHand(){
      //if any hands are empty, shuffle discard pile and put it in hand
      if(player.getHand().isEmpty()){
         player.getDiscardPile().shuffle();
         player.setHand(player.getDiscardPile());
         player.getDiscardPile().clear();
      }
      if(computer.getHand().isEmpty()){
         computer.getDiscardPile().shuffle();
         computer.setHand(computer.getDiscardPile());
         computer.getDiscardPile().clear();
      }
   }
   
   
}