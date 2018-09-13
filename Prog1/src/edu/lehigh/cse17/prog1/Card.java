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
public class Card {
    public static final int CLUBS = 0;
    public static final int HEARTS = 1;
    public static final int SPADES = 2;
    public static final int DIAMONDS = 3;
    public static final int TWO = 0;
    public static final int THREE = 1;
    public static final int FOUR = 2; 
    public static final int FIVE = 3; 
    public static final int SIX = 4; 
    public static final int SEVEN = 5; 
    public static final int EIGHT = 6;
    public static final int NINE = 7; 
    public static final int TEN = 8; 
    public static final int JACK = 9; 
    public static final int QUEEN = 10; 
    public static final int KING = 11; 
    public static final int ACE = 12;
    private int suit;
    private int rank;
    
    private final String[] suitArray;
    private final String[] rankArray = {"c","h","s","d"};

    public Card(int suit, int rank) {
        this.suitArray = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuitName() {
        return suit;
    }

    public int getRankName() {
        return rank;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", rank=" + rank + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.suit;
        hash = 97 * hash + this.rank;
        return hash;
    }
    
}
