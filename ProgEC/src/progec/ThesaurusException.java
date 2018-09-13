/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progec;

/**
 *
 * @author christophermallalieu
 */
public class ThesaurusException extends Exception {
    
    public ThesaurusException (String message) { //constructor for custom exception
        super(message); //sends custom error message
    }
}
