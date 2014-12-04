import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.System;

public class WarGUI extends JFrame{
   private Game game;
   private Player player;
   private Player computer;
   private JLabel j1;
   private JLabel j2;
   private JLabel j3;
   private JLabel j4;
   private JLabel j5;
   private JLabel j6;
   private JLabel j7;
   private JButton j8;
   private JLabel j9;
   private ImageIcon back;
   
   public WarGUI(){
        setLayout(new GridLayout(0,3));
        back = new ImageIcon("../img\\back.jpg");
        
        player = new Player("Your Name");
        computer = new Player("Computer");
        Deck deck = new Deck(); //creates a 52 card deck
        game = new Game(player, computer, deck);
        
        //Create variables to access parts of game
        player = game.getPlayer();
        computer = game.getComputer();
        deck = game.getDeck();
        
        //Generate and split the deck
        deck.shuffle();
        game.cutDeck(deck, player, computer);
        
        j1 = new JLabel();
        j1.setIcon(new ImageIcon());
        this.getContentPane().add(j1);
        
        j2 = new JLabel("Welcome to War");
        this.getContentPane().add(new JLabel("Welcome to War"));
        
        j3 = new JLabel();
        this.getContentPane().add(j3);
        
        j4 = new JLabel(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
        j4.setIcon(back);
        this.getContentPane().add(j4);
        
        j5 = new JLabel();
        this.getContentPane().add(j5); 
        
        j6 = new JLabel(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
        j6.setIcon(back);
        this.getContentPane().add(j6);
        
        j7 = new JLabel("Player", SwingConstants.CENTER);
        this.getContentPane().add(j7);
        
        j8 = new JButton("Click to continues");
        j8.addActionListener(new ButtonListener());
        this.getContentPane().add(j8);
        
        
        JLabel j9 = new JLabel("Computer", SwingConstants.CENTER);
        this.getContentPane().add(j9);
   }
   
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         //Check if there is a winner
         //If no winner
         if(!game.hasWinner()){
            //Check if hands are empty and reshuffle discard pile if needed
            game.discardToHand();
            //Play top card from each hand
            ArrayList<Card> playerCardsInPlay = new ArrayList<Card>(0); //an array to keep track of cards "out on the table"
            ArrayList<Card> computerCardsInPlay = new ArrayList<Card>(0);
            playerCardsInPlay.add(game.getPlayer().getHand().playCard()); //plays the top card out on the table
            computerCardsInPlay.add(game.getComputer().getHand().playCard());
            //Display Cards
            j1.setIcon(new ImageIcon(playerCardsInPlay.get(0).getImgPath()));
            j3.setIcon(new ImageIcon(computerCardsInPlay.get(0).getImgPath()));
            j4.setText(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
            j6.setText(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
            
            //Pause the program so the player can see the cards
            
            //Compare cards and move to appropriate pile
            if(playerCardsInPlay.get(0).getRank() > computerCardsInPlay.get(0).getRank()){
               //Give player the cards
               for(Card c: playerCardsInPlay){
                  player.getDiscardPile().addCard(c);
               }
               for(Card c: computerCardsInPlay){
                  player.getDiscardPile().addCard(c);
               }
               j4.setText(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
               j6.setText(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
            }
            else if (playerCardsInPlay.get(0).getRank() < computerCardsInPlay.get(0).getRank()){
               //Give computer the cards
               for(Card c: playerCardsInPlay){
                  computer.getDiscardPile().addCard(c);
               }
               for(Card c: computerCardsInPlay){
                  computer.getDiscardPile().addCard(c);
               }
               j4.setText(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
               j6.setText(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
            }
            //Or Go to war
            else{
               boolean noWinner = true;
               while(noWinner){
                  //Check if hands are empty and reshuffle discard pile if needed
                  game.discardToHand();
                  //Play first cards
                  playerCardsInPlay.add(game.getPlayer().getHand().playCard()); //plays the top card out on the table
                  computerCardsInPlay.add(game.getComputer().getHand().playCard());;
                  //Display Back of Card
                  j1.setIcon(back);
                  j3.setIcon(back);
                  //Check if hands are empty and reshuffle discard pile if needed
                  game.discardToHand();
                  //Play second card
                  playerCardsInPlay.add(game.getPlayer().getHand().playCard()); //plays the top card out on the table
                  computerCardsInPlay.add(game.getComputer().getHand().playCard());;
                  //Display Cards
                  j1.setIcon(new ImageIcon(playerCardsInPlay.get(playerCardsInPlay.size()-1).getImgPath()));
                  j3.setIcon(new ImageIcon(computerCardsInPlay.get(computerCardsInPlay.size()-1).getImgPath()));
                  //Determine Winner
                  if(playerCardsInPlay.get(playerCardsInPlay.size()-1).getRank() > computerCardsInPlay.get(computerCardsInPlay.size()-1).getRank()){
                     //Allocate Cards
                     for(Card c: playerCardsInPlay){
                        player.getDiscardPile().addCard(c);
                     }
                     for(Card c: computerCardsInPlay){
                         player.getDiscardPile().addCard(c);
                      }
                     j4.setText(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
                     j6.setText(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
                     //Update noWinner
                     noWinner = false;
                  }
                  else if(playerCardsInPlay.get(playerCardsInPlay.size()-1).getRank() < computerCardsInPlay.get(computerCardsInPlay.size()-1).getRank()){
                     for(Card c: playerCardsInPlay){
                        computer.getDiscardPile().addCard(c);
                     }
                     for(Card c: computerCardsInPlay){
                        computer.getDiscardPile().addCard(c);
                     }
                     j4.setText(Integer.toString(player.getHand().getSize() + player.getDiscardPile().getSize()));
                     j6.setText(Integer.toString(computer.getHand().getSize() + computer.getDiscardPile().getSize()));
                     
                     noWinner = false;
                  }
                  //If no winner, loop repeats
               }
            }
            game.setWinner();
         }
         //If winner
         else{
            //Create a pop up box declaring winner
            JOptionPane winnerPopUp = new JOptionPane();
            winnerPopUp.showMessageDialog(null, "There is a winner", "End of Game!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
         }
      }
   }
   
}