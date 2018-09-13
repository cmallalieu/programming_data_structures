package prog3;

/*
CSE 17
Christopher Mallalieu
cpm220
Employee salary calculator
*/
import java.io.*;
import java.util.*;
/**
 *
 * @author christophermallalieu
 */
public class Prog3 {
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
  //System.out.println (builder.toString());
  
  String textString = builder.toString(); 
  String[] textArray = textString.split("\\s+"); //fills array with words
  String[] typeArray = new String[textArray.length / 5]; //initializes arrays for factory perameters
  String[] nameArray = new String[textArray.length / 5];
  int[] hourArray = new int[textArray.length / 5];
  double[] wageArray = new double[textArray.length / 5];
  double[] salaryArray = new double[textArray.length / 5];
  
  int j = 0;
  for (int i = 1; i < textArray.length + 1; i += 5) { //fills type array
      typeArray[j] = textArray[i];
      j++;
  }
  
  j = 0;
  for (int k = 0; k < textArray.length; k += 5) { //fills name array
      nameArray[j] = textArray[k];
      j++;
  }
  
  j = 0;
  for (int l = 2; l < textArray.length; l += 5) { //fills hour array
      hourArray[j] = Integer.parseInt(textArray[l]);
      j++;
  }
  
  j = 0;
  for (int m = 3; m < textArray.length; m += 5) { //fills wage array
      wageArray[j] = Double.parseDouble(textArray[m]);
      j++;
  }
  
  j = 0;
  for (int n = 4; n < textArray.length; n += 5) { //fills saalary array
      salaryArray[j] = Double.parseDouble(textArray[n]);
      j++;
  }
  
  List <Employee> emps = new ArrayList<>(); //creates arraylist for employee objects
  System.out.printf ("%-12s %-12s %-12s %-12s \n", "Name", "Type", "Hours", "Total Pay"); //formats print
  double totalMoney = 0;
  for (int o = 0; o < nameArray.length; o++) {
      
      Employee e = Employee.factory (nameArray[o], typeArray[o], hourArray[o], wageArray[o], salaryArray[o]); //creates employees from the factory
      emps.add(e);

        System.out.printf ("%-12s ", e.getName()); //prints in format
        System.out.printf ("%-12s ", e.getType());
        System.out.printf ("%5s ", e.getHours());
        System.out.printf ("%16s \n", e.totalPay());
        totalMoney += e.totalPay(); //coutns total money
  }
  
  System.out.printf ("%48s \n", totalMoney); //prints total money

    }
}
