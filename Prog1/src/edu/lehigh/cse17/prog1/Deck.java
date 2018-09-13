
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lehigh.cse17.prog1;
import java.util.*;
/**
 *
 * @author christophermallalieu
 */
public class Deck {
    
    private Card[] cards = new Card[52];
    private int nextIndex;
    private int counter = 0;
    
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 14; j++) {
                cards[counter] = new Card(i,j);
                counter++;
            }
    }
   }
    public void shuffle() {
        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            int r = rand.nextInt(51) + 1;
            Card temp = cards[0];
            cards[0] = cards[r];
            cards[r] = temp;
        }
        nextIndex = 0;
    }
    public Card dealCard() {
        Card nextCard = cards[nextIndex];
        nextIndex++;
        return nextCard;
    }
    public int getCardsRemaining () {
        int cardsRemaining = 52 - nextIndex;
        return cardsRemaining; 
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + cards + '}';
    }
}
