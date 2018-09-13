

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christophermallalieu
 */
public class GunningFog {
    
    private String text = null;
    
    public GunningFog (String text) { //constructor
        this.text = text;
    }
    
    public double calculateIndex (String inputText) {
        
        StringBuilder textBuilder = new StringBuilder(inputText);
        double sentenceCount = 0;
        
        for (int i = 0; i < textBuilder.length(); i++) { //deletes punctuation
            if (textBuilder.charAt(i) == '.') {
                textBuilder.deleteCharAt(i);
                sentenceCount++;
            }
            if (textBuilder.charAt(i) == ',') {
                textBuilder.deleteCharAt(i);
            }
            if (textBuilder.charAt(i) == '?') {
                textBuilder.deleteCharAt(i);
                sentenceCount++;
            }
            if (textBuilder.charAt(i) == ':') {
                textBuilder.deleteCharAt(i);
            }
            if (textBuilder.charAt(i) == ';') {
                textBuilder.deleteCharAt(i);
            }
            if (textBuilder.charAt(i) == '!') {
                textBuilder.deleteCharAt(i);
                sentenceCount++;
            }
        }
        String cleanText = textBuilder.toString(); //converts builder to string
        String[] textArray = cleanText.split("\\s+"); //enters words into array
        
        double wordCount = 0;
        double complexWordCount = 0;
        
        for (int j = 0; j < textArray.length; j++) { //counts complex words
            wordCount++;
            Word w = new Word(textArray[j]);
            if (w.isComplex(textArray[j])) {
                complexWordCount++;
            }
        }
        
        double fogIndex = .4 * ((wordCount / sentenceCount) + 100 * (complexWordCount / wordCount)); //calculates fog index
        return fogIndex;
    }
}
