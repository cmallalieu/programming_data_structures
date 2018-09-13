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
public class HourlyEmployee extends Employee {
    
    private double wage; //hourly field

    public HourlyEmployee(double wage, String name, String hours) { //hourly constructor
        super(name, hours);
        this.wage = wage;
    }
    
    @Override
    public String getType() {
    return "Hourly";
}
    @Override
    public double totalPay() {
        double hoursDouble = Double.parseDouble(hours);
        double hourlyWage = wage * hoursDouble;
        return hourlyWage;
    }
}
