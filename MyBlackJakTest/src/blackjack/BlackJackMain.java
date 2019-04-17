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
public class BlackJackMain {
    
    public static void main(String args[])
    {       
        Game game = new Game();
        
        game.play();
       
         System.out.println("\n" + "<> Game is over! <>");
         
    }  
    
}
