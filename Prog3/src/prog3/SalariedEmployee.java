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
public class SalariedEmployee extends Employee {
    
    private double salary; //salaried field

    public SalariedEmployee(double salary, String name, String hours) { //salaried constructor
        super(name, hours);
        this.salary = salary;
    }
    
    @Override
    public String getType() {
        return "Salaried";
    }
    
    @Override
    public double totalPay() {
        double totalSalary = salary / 52; 
        return totalSalary;
    }
}
