import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WarGUI extends JFrame{
   private Game game;
   private JLabel j1;
   private JLabel j2;
   private JLabel j3;
   private JLabel j4;
   private JLabel j5;
   private JLabel j6;
   private JLabel j7;
   private JButton j8;
   private JLabel j9;
   
   public WarGUI(){
        setLayout(new GridLayout(0,3));
        
        Player player = new Player("Your Name");
        Player computer = new Player("Computer");
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
        this.getContentPane().add(new JLabel("Weclome to War"));
        
        j3 = new JLabel();
        this.getContentPane().add(j3);
        
        j4 = new JLabel();
        j4.setIcon(new ImageIcon("../img\\back.jpg"));
        this.getContentPane().add(j4);
        
        j5 = new JLabel();
        this.getContentPane().add(j5); 
        
        j6 = new JLabel();
        j6.setIcon(new ImageIcon("../img\\back.jpg"));
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
            
            //Compare cards and move to appropriate pile
            if(playerCardsInPlay.get(0).getRank() > computerCardsInPlay.get(0).getRank()){
               //Give player the cards
               ;
            }
            else if (playerCardsInPlay.get(0).getRank() < computerCardsInPlay.get(0).getRank())
               //Give computer the cards
               ;
            //Or Go to war
            else{
               ;
            }
         }
         //If winner
         else{
            //Create a pop up box declaring winner
         }
      }
   }
   
}