import java.util.Scanner;

public class WarDriver{

   public static void main(String[] args){
   
      
         //Create the game and its components
         
         Player player = new Player("");
         Player computer = new Player("Computer");
         Deck deck = new Deck(); //creates a 52 card deck
         Game game = new Game(player, computer, deck);
         game.showGUI();
         System.out.println("Now playing war");
         
         //Create variables to access parts of game
         player = game.getPlayer();
         computer = game.getComputer();
         deck = game.getDeck();
         
         //Name the player
         Scanner keyboard = new Scanner(System.in);
         System.out.println("What is your name? ");
         String name = keyboard.nextLine();
         player.setName(name);
         
         //Generate and split the deck
         deck.shuffle();
         game.cutDeck(deck, player, computer);
         
         //Play rounds until there is a winner
         while(!game.hasWinner()){
            System.out.printf("Players Hand Size: %d   Computers Hand Size: %d \nPlayers Discard Size: %d    Computers Discard Size: %d \n", player.getHand().getSize(), computer.getHand().getSize(), player.getDiscardPile().getSize(), computer.getDiscardPile().getSize());
            System.out.println("Press any key to play next round");
            keyboard.nextLine();
            game.playRound();
            game.setWinner();
            
         }
         if(game.getWinner() == player){
            System.out.println("Congratulations, you won!");
         }
         else{
            System.out.println("Sorry, you lost");
         }
      }


}
