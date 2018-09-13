/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog3;
        /**
 *
 * @author christophermallalieu
 */
public abstract class Employee {
    
    protected String name; //employee fields
    protected String hours;

    public Employee(String name, String hours) { //employee constructor
        this.name = name;
        this.hours = hours;
    }
    
    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }
    
    public abstract String getType();
    public abstract double totalPay();
    
    public static Employee factory (String name, String type, int hours, double wage, double salary) { //creates salried and hourlyemployees
       
        String lowerType = type.toLowerCase();
        String hourString = Integer.toString(hours);
        
        try { //try block for exception 
            switch (lowerType) { //switch to determine if its a salaried employee or hourly
                case "salaried":
                    return new SalariedEmployee(salary, name, hourString);
                case "hourly":
                    return new HourlyEmployee(wage, name, hourString);
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) { //catches exception 
          System.out.println (ex.getMessage());
          return null;
       }
    }
}
