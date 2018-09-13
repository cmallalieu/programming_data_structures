/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progec;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author christophermallalieu
 */
public class Thesaurus {
    
    private Map<String, ArrayList<String>> synonyms = new HashMap<>(); //creates hashmap for thesaurus 
    
    public Thesaurus (String fileName) { //constructor to import file and fill hashmap
        String text;
        try {
            BufferedReader inputFile = new BufferedReader (new FileReader (fileName)); //creates bufferedReader object
            while ((text = inputFile.readLine()) != null) { //reads file one line at a time
                String[] lineWords = text.split(","); //splits line into words
                ArrayList <String> synonymList = new ArrayList<>();
                for (int i = 1; i < lineWords.length; i++) { //adds synonyms of a single word to synonymList
                    synonymList.add(lineWords[i]);
                }
                synonyms.put(lineWords[0], synonymList); //adds synonymList to hashmap
            }
        } catch (IOException ex) { //catches IOException if file cant be read
            System.out.println(ex.getMessage());
        }
    }
    
    public List<String> getSynonyms (String lookupWord) throws ThesaurusException { //gets the synonym list from a single lookupWord
        
        if (synonyms.get(lookupWord) != null){ // returns list of synonyms
            return synonyms.get(lookupWord);
        } else {
            throw new ThesaurusException("Lookup Word not in Dictionary"); //throws exception if the word is not in the dictionary
        }
    }
}
