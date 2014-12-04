import java.util.Scanner;
public class Game{
   private Player player;
   private Player computer;
   private Deck deck;
   private int rounds;
   private Player winner;
   
   public Game(Player p1, Player p2, Deck d){
      this.player = p1;
      this.computer = p2;
      this.deck = d;
   }
  
   public void playRound(){
      
      discardToHand();
      Card playerCard = player.getHand().playCard();
      Card computerCard = computer.getHand().playCard();
      
      //If players card is bigger, they get the cards
      //If computers card is bigger, it gets the cards
      //Otherwise, go to war
      if(playerCard.getRank() > computerCard.getRank()){
         player.getDiscardPile().addCard(playerCard);
         player.getDiscardPile().addCard(computerCard);
      } else if (playerCard.getRank() < computerCard.getRank()){
         computer.getDiscardPile().addCard(playerCard);
         computer.getDiscardPile().addCard(computerCard);
      } else{
         Player warWinner = war();//go to war
         //allocate cards to winner
         if (warWinner == player){
            player.getDiscardPile().addCard(playerCard);
            player.getDiscardPile().addCard(computerCard);
         }
         if (warWinner == computer){
            computer.getDiscardPile().addCard(playerCard);
            computer.getDiscardPile().addCard(computerCard);
         }
      }
   }
   
   public Player war(){
      
      System.out.println("You go to war!");
      
      discardToHand();//check if either discard pile needs to be shuffled into hand
      Card firstPlayerCard = player.getHand().playCard();
      Card firstComputerCard = computer.getHand().playCard();
      discardToHand();//check if either discard pile needs to be shuffled into hand
      Card secondPlayerCard = player.getHand().playCard();
      Card secondComputerCard = computer.getHand().playCard();
      
      if(secondPlayerCard.getRank() > secondComputerCard.getRank()){
         player.getDiscardPile().addCard(firstPlayerCard);
         player.getDiscardPile().addCard(firstComputerCard);
         player.getDiscardPile().addCard(secondPlayerCard);
         player.getDiscardPile().addCard(secondComputerCard);
         return player;
      }
      else if (secondPlayerCard.getRank() < secondComputerCard.getRank()){
         computer.getDiscardPile().addCard(firstPlayerCard);
         computer.getDiscardPile().addCard(firstComputerCard);
         computer.getDiscardPile().addCard(secondPlayerCard);
         computer.getDiscardPile().addCard(secondComputerCard);
         return computer;
      } 
      else{
         return war();
      }
   }
   
   public boolean hasWinner(){
      if(winner != null)
          return true;
      else return false;
   }
   
   public Player getWinner(){
      return winner;
   }
   
   public Player getPlayer(){
      return this.player;
   }
   
   public Player getComputer(){
      return this.computer;
   }
   
   public Deck getDeck(){
      return this.deck;
   }
   
   public void setWinner(){
      if(player.getHand().getSize() == 0 && player.getDiscardPile().getSize() == 0){
         winner = computer;
      } else if (computer.getHand().getSize() == 0 && computer.getDiscardPile().getSize() == 0){
         winner = player;
      } else{
         ;
      }
   }
   
   public void cutDeck(Deck d, Player p1, Player p2){
      for(int i = 0; i < d.getSize()/2; i++){
         Card c = d.getCard(i);
         p1.getHand().addCard(c);
      }
      
      for(int i = d.getSize()/2; i < d.getSize(); i++){
         p2.getHand().addCard(d.getCard(i));
      }
   }
   
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