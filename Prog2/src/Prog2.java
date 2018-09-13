/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author christophermallalieu
 */
public class Prog2 {
    public static void main (String[] args) {
    StringBuilder builder = new StringBuilder(); 
    String line; //string that contains text file
    try {
        BufferedReader input = new BufferedReader (new FileReader(args[0])); //command arg
        while ((line = input.readLine()) != null) { //imports text
        builder.append(line); //creates string with spaces
        builder.append(' ');
    }
  } catch (IOException ex) { //catches error
      System.out.println(ex.getMessage());
  }
  String builderString = builder.toString();
  System.out.println (builderString);
    //GunningFog g = new GunningFog(builderString); //creates object 
    //System.out.println (g.calculateIndex(builderString)); //prints index
    
    }
}
