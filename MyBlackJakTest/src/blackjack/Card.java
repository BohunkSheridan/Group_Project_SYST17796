/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author bohunk
 */



public class Card {
    
    public enum Suit {
    HEARTS, SPADES, CLUBS, DIAMONDS
    
}
    public enum Value { // TWO - King(10 points)/Ace 11 or 1(if Scores > 10)
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING,ACE     
}
    
    private Suit suit;
    private Value value;
    
    public Card( Suit suit, Value value)
    {
        this.value=value;
        this.suit=suit;
    }
    
    @Override
    public String toString()
    {
        return "\t" + this.value.toString() + "   of \t" +  "♠ ♥ ♣ ♦ "+this.suit.toString() +  " ♠ ♥ ♣ ♦";
    }
    
    public Value getValues(){
        return this.value;
    }
}
