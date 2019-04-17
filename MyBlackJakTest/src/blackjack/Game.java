/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author bohunk
 */
public class Game {
    
    public void play()
    {
        
    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle(); 
    
    Deck playerDeck = new Deck();
    Deck dealerDeck = new Deck();
    
     double playerMoney = 200.0;
        boolean endRound; // for scip round after fail 
        int response;
        double playerBet;
        
        Scanner userInput = new Scanner(System.in);
        
        //System.out.println(playingDeck);
        //Menu
        while (playerMoney > 0)
        {
             System.out.println("You have $" + playerMoney + " today \n How much would you like to bet?"+"\n");
             playerBet = userInput.nextDouble();
             while (playerBet > playerMoney)  // check if player still have money
             {
                 System.out.println("You don't have that much money =(");
                 //break;
                 System.out.println("You have $" + playerMoney + " today \n How much would you like to bet?"+"\n");
                 playerBet = userInput.nextDouble();
             }
                    
             playerDeck.draw(playingDeck); // take 2 cards for the player
             playerDeck.draw(playingDeck);
             
             dealerDeck.draw(playingDeck); // take 2 cards for the dealer
             dealerDeck.draw(playingDeck);
             endRound = false;
             while(true)
             {
                 //for Player
                 System.out.println("Your cards are: " + "\n" + playerDeck.toString());
                 System.out.println("Value of your cards: " + playerDeck.cardsValue());
                 
                 //for Dealer
                 System.out.println("\nDealers cards are: " + "\n\n" + dealerDeck.getCard(0).toString()
                         + " \n\n\t\t\t ♠ ♥ ♣ ♦ {^Guess WHAT?^} ♠ ♥ ♣ ♦ \n");
                 
                 //Time to choice
                 System.out.println("\t Press '0' to Stay with your Cards \n\t\t or 1' to Take one more: ");
                 response = userInput.nextInt();
                 
                 //Hit case
                 if (response == 1)
                 {
                     playerDeck.draw(playingDeck);
                     System.out.println("\t You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                     //More than 21
                     if (playerDeck.cardsValue()>21)
                     {
                         System.out.println("\n\t Value of cards: " + playerDeck.cardsValue() + " points");
                         System.out.println("You loose your $"+playerBet);
                         playerMoney -= playerBet;
                         endRound = true;
                         break;                                                                                                                                                                                                                                                                                                                                                                                                                     
                         
                     }
                 }
                 if(response == 0)
                 {
                     break;
                 }
             }
             
             System.out.println("\nDealer cards is: " + dealerDeck.toString());
             //more dealers cards
              while( (dealerDeck.cardsValue() < 16) && endRound == false) 
             {
                 dealerDeck.draw(playingDeck);
                 System.out.println("Dealer draws a: " + dealerDeck.getCard(dealerDeck.deckSize()-1 ).toString() );
                                  
             }
             System.out.println("Dealer got: " + dealerDeck.cardsValue() + " points"); //dealer`s total
             //compare scores
             if ( (playerDeck.cardsValue() == 21 )
                     && endRound == false)
             {
                 System.out.println("You are the WINNER!!!");
                 playerMoney +=playerBet;
                 endRound=true;
             }
       
             
             //PC loose
             if ( (dealerDeck.cardsValue() > 21 && endRound == false) )
             {
                 System.out.println(" You are the WINNER!!!"); 
                 playerMoney += playerBet;
                 endRound = true;
                 
             }
              if ( (dealerDeck.cardsValue() > playerDeck.cardsValue() )
                     && endRound == false)
             {
                 System.out.println("Dealer WINNER!!!");
                 playerMoney -=playerBet;
                 endRound=true;
             }
             if ( ( playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) 
             {
                 System.out.println(" You are the WINNER!!!"); 
                 playerMoney += playerBet;
                 endRound = true;
             }
             if ( (playerDeck.cardsValue() == dealerDeck.cardsValue() ) && endRound == false)
             {
                 System.out.println("nobody won =( \n Play Again ;)");
             }
             
             
             
            /* else if (endRound == false)
             {
                 System.out.println( "Dealer WINNER!!!");
                 playerMoney -= playerBet;
                 endRound = true;
             }*/
             playerDeck.moveAllToDeck(playingDeck);
             dealerDeck.moveAllToDeck(playingDeck);
        }       
    }
    
    public void displayRules()
    {
        System.out.println("Welcome to BlackJack Game!");
        
        System.out.println("To win this game you need: "
                +"\n\t" +"- make 21 points"
                +"\n\t" +"- make less than 21 points but more than the dealer’s"
                +"\n" +"Each card is nominal number. Jack, Queen and Queen are equal to 10 points."
                + "\n Ace is equal to 11 or 1 point (if you have already scored more than 10)"
                +"\n\n"+ " -  *  -  *  -  *  -  *  - \n\n");
    }
    
}
