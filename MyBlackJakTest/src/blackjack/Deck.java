/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bohunk
 */
public class Deck {
    
    private ArrayList<Card> cards;
    
    private int thisDeckSize;
    private int totalValue = 0;
    private int aces;
    
    public Deck(){
        this.cards = new ArrayList<Card>(); // to keep all 52 cards
    }
    
    public void createFullDeck()
    {
        for (Card.Suit cardSuit : Card.Suit.values())
        {
            for(Card.Value cardValue : Card.Value.values())
            {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
            
    }
    public void shuffle()
    {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i=0;i<originalSize;i++)
        {
            randomCardIndex = random.nextInt((this.cards.size()-1-0)+1)+0;
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards=tmpDeck;
        
    }
    
    public void removeCard(int i)
    {
        this.cards.remove(i);
    }
    public Card getCard(int i)
    {
        return this.cards.get(i);
    }
     public void addCard(Card addCard)
     {
         this.cards.add(addCard);
     }
     
     public void draw(Deck comingFrom)
     {
         this.cards.add(comingFrom.getCard(0));
         comingFrom.removeCard(0);
     }
     
     public int cardsValue()
     {
         totalValue = 0;
         aces = 0;
         
         for(Card aCard : this.cards)
         {
             switch(aCard.getValues())
             {
                 case TWO: totalValue +=2;
                 break;
                 case THREE: totalValue +=3;
                 break;
                 case FOUR: totalValue +=4;
                 break;
                 case FIVE: totalValue +=5;
                 break;
                 case SIX: totalValue +=6;
                 break;
                 case SEVEN: totalValue +=7;
                 break;
                 case EIGHT: totalValue +=8;
                 break;
                 case NINE: totalValue +=9;
                 break;
                 case TEN: totalValue +=10;
                 break;
                 case JACK: totalValue +=10;
                 break;
                 case QUEEN: totalValue +=10;
                 break;
                 case KING: totalValue +=10;
                 break;
                 case ACE: aces +=1;
                 break;
             }
         }
         for (int i=0; i<aces; i++) // logic for Ace(1 or 10)
         {
             if (totalValue>10)
             {
                 totalValue+=1;
             }
             else
             {
                 totalValue+=11;
             }
         }
         return totalValue;
     }
     
     public int deckSize()
     {
         return this.cards.size();
     }
     
     public void moveAllToDeck(Deck moveTo) // move all card back
     {
         thisDeckSize = this.cards.size();
         
         for (int i=0; i<thisDeckSize; i++)
         {
             moveTo.addCard(this.getCard(i) );
             
         }
         for (int i=0; i< thisDeckSize; i++)
         {
             this.removeCard(0);
         }
     }
    
    
    @Override
    public String toString()
    {
        String cardListOutput = "";
        for(Card aCard : this.cards)
        {
            cardListOutput += "\n " + aCard.toString() + "\n";
        }
        return cardListOutput;        
    }
    
    
}
