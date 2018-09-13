/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progec;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author christophermallalieu
 */
public class PronouncingDictionary {
    
    private Map<String, ArrayList<String>> wordList = new HashMap<>(); //creates hashmap to hold the word list
    private Map<String, Boolean> isVowel = new HashMap<>(); //creates hashmap to hold phoneme vowels
    
    public PronouncingDictionary (String wordListFile, String phonemeFile) { //constuctor that reads in files
        String wordText;
        String phonemeText;
        
        try {
            BufferedReader wordFile = new BufferedReader (new FileReader(wordListFile)); //creates bufferedreader object
            while ((wordText = wordFile.readLine()) != null) { //reads line by line
                if (wordText.startsWith(";;;") == false) { //does not take lines that start with ;;;
                    wordText = wordText.toLowerCase(); //converts to lowercase
                    String[] lineWords = wordText.split("\\s+"); //splits words into indecies 
                    ArrayList <String> phonemeList = new ArrayList<>();
                    for (int i = 1; i < lineWords.length; i++) { // adds each word to phonemeList
                        phonemeList.add(lineWords[i]);
                    }
                    wordList.put(lineWords[0], phonemeList); //adds each phonemeList to wordList map
                }
            }
            
            BufferedReader phonFile = new BufferedReader (new FileReader(phonemeFile)); //creates buffered reader object
            while ((phonemeText = phonFile.readLine()) != null) { //reads in file one line at a time
                phonemeText = phonemeText.toLowerCase(); //converts to lowerCase
                String[] lineWords = phonemeText.split("\\s+"); //splits words into indecied
                if (lineWords[1].equals("vowel")) { //if phoneme is a vowel, add to isVowel with value true
                    isVowel.put(lineWords[0], true);
                } else {
                    isVowel.put(lineWords[0], false); //if phoneme is not a vowel, add to isVowel with value false
                }
            }
        } catch (IOException ex) { //catch IOExcetion if the file cannot be found
            System.out.println (ex.getMessage());
        }
    }
    
    public int rhymePhoneCount (String word1, String word2) { //method to count how many matching phonemes there are
        ArrayList<String> wordArray1 = wordList.get(word1); //gets phoneme list from wordlist
        ArrayList<String> wordArray2 = wordList.get(word2);
        int vowelCount = 0;
        
        for (int i = 0; i < wordArray1.size(); i++) { //strips digits from phoneme list
            String phoneme = wordArray1.get(i).replaceAll("\\d*$", "");
            wordArray1.set(i, phoneme);
        }
        for (int j = 0; j < wordArray2.size(); j++) { //strips digits from phoneme list
            String phoneme = wordArray2.get(j).replaceAll("\\d*$", "");
            wordArray2.set(j, phoneme);
        }
        
        Collections.reverse(wordArray1); //reverses both wordArrays to read phoneme backwards
        Collections.reverse(wordArray2);
        
        int index = 0;
        for (String s: wordArray1) { //iterated through wordArray1 and counts how many phonemes match with each word in wordArray2
            if (s.equals(wordArray2.get(index)) && index < wordArray2.size()) {
                if (isVowel.get(s) && isVowel.get(wordArray2.get(index))) {
                    vowelCount++;
                }
            } else return vowelCount;
            index++;
        }
        return vowelCount; //returns number of common phonemes
    }
    
    public List<String> findRhymingSynonyms (String rootWord, String rhymeWord, int degree) throws ThesaurusException { //method to find final list
        Thesaurus thes = new Thesaurus("mthesaurEDIT.txt"); //creates Thesaurus object
        List<String> synonymList = thes.getSynonyms(rootWord); //gets synonyms for rootWord
        ArrayList<String> matchingWords = new ArrayList<>();
        
        for (String s: synonymList) { // iterates through all synonyms, passing them and the rhymeWord through rhymePhoneCount
            if (wordList.get(s) != null) {
                if (rhymePhoneCount(s, rhymeWord) >= degree) { //if there are mor phoneme matches than the degree, add to list
                    matchingWords.add(s); 
                }
            }
        }
        return matchingWords; //return final list
    }
}
