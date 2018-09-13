
/*
CSE 17
Christopher Mallalieu
cpm220
Synonyms and rhyme finder
*/
package progec;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author christophermallalieu
 */
public class ProgEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //creates scanner object
        boolean keepGoing = true;
        String rootWord = "";
        String rhymeWord = "";
        
        while (keepGoing == true) { //restarts program when finished 
            boolean rootBool;
            do { // do while to get root word as a string
                System.out.print ("Enter a root word: ");
                rootBool = scan.hasNextDouble(); //returns false if the input is a string
                rootWord = scan.next();
                if (rootWord.isEmpty()) {
                System.exit(0);
                }
                if (rootBool == true) {
                    System.out.print ("Incorrect input must be a string. "); //prints error and asks again 
                }
            }  while (rootBool == true);



            boolean rhymeBool;

            do { //do while to get rhyme word as string 
                System.out.print ("Enter a rhyme word: ");
                rhymeBool = scan.hasNextDouble(); //returns false if input is a string
                rhymeWord = scan.next();
                if (rhymeBool == true) {
                    System.out.print ("Incorrect input must be a string. "); //prints error message if not a string
                }
            } while (rhymeBool == true);

            boolean degreeBool;
            String degreeString;
            do { //do while to check for digit input 
                System.out.print ("Enter a degree: ");
                degreeBool = scan.hasNextInt();
                degreeString = scan.next();
                if (degreeBool == false) {
                    System.out.print ("Incorrect input must be an integer. "); //prints error if input is not an int
                }
            } while (degreeBool == false);
        
            PronouncingDictionary dict = new PronouncingDictionary ("cmudictEDIT.txt", "cmudictphones.txt"); // creates PronouncingDictionary object
            List<String> finalList = new ArrayList<>();
           try { //creates final list in try catch block
                finalList = dict.findRhymingSynonyms(rootWord, rhymeWord, Integer.valueOf(degreeString));
            } catch (ThesaurusException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.print("Synonyms: "); //prints out formatted list
            for (String s: finalList) {
                System.out.print (s + ", ");
            }
            System.out.println();
        }
    }
}
