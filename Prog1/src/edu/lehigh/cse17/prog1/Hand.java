/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lehigh.cse17.prog1;

/**
 *
 * @author christophermallalieu
 */
public class Hand {
    Card[] hand = new Card[5];
    
    public boolean addCard (Deck d) {
        for (int i = 0; i < 6; i++) {
            hand[i] = d.dealCard();
        }
        return false;
    }
    public Card lookup (int n) {
        
    }
}