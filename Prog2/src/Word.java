

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.regex.*;
/**
 *
 * @author christophermallalieu
 */
public class Word {

    private String word = null;
    
    public Word (String word) { //consturctor
        this.word = word;
    }
    
    private int countSyllables(String inputWord) { //counts syllables
        
        int sylCount = 0;
        
        Pattern vowelPattern = Pattern.compile("(?i)[aeiou]"); //literal for vowels
        Pattern doubleVowel = Pattern.compile("(?i)[aeiou]+(?i)[aeiou]"); //literal for consecutive vowels
        Matcher vowelMatcher = vowelPattern.matcher(inputWord);
        Matcher doubleMatcher = doubleVowel.matcher(inputWord);
        
        while (vowelMatcher.find()) { //counts vowels
            sylCount++;
        }
        while (doubleMatcher.find()) { //counts double vowels
            sylCount--;
        }
        if (inputWord.endsWith("y")) { //accounts for ending in y
            sylCount--;
        }
        if (inputWord.endsWith("e")) { //accounts for ending in e
            sylCount--;
        }
        return sylCount;
    }
    
    public boolean isComplex (String inputWord) { //counts comlex words
        int sylCount = countSyllables(inputWord);
        if (inputWord.endsWith ("es") || inputWord.endsWith ("ed") || inputWord.endsWith ("ing")) {
            sylCount--;
        }
        return sylCount >= 3; //returns if the word is complex or not 
    }
}
