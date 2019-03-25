package cs1302.ce23;

import cs1302.Utility;
import java.util.Arrays;

/**
 * A class representing an employee at a company. Each employee has an associated 
 * name, level, gross pay, and a set of deductions.
 *
 * An employee's level indicates their rank within the company. A higher level is a 
 * higher rank.
 *
 * An employee's deductions are the values that are subtracted from their paycheck.
 */
public class Employee {

    private String name;
    private int level;
    private double[] deductions;
    private double gross;

    private static int employeeCounter = 1;

    /**
     * Constructs an {@code Employee} object.
     *
     * @param name the name of the employee.
     * @param level the level of the employee.
     * @param deductions an array of deductions from the employee's paycheck.
     * @param gross the employee's gross pay.
     * @throws NullPointerException if {@code deductions} is null.
     */
    public Employee(String name, int level, double[] deductions, double gross) {
        Utility.nullCheck("Employee Constructor", deductions);

        this.name = name;
        this.level = level;
        this.deductions = Arrays.copyOf(deductions, deductions.length);
        this.gross = gross;
    } // Employee

    /**
     * Returns the name of this {@code Employee}
     *
     * @return the name of the employee.
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Returns the gross pay of this {@code Employee}
     *
     * @return the gross pay of the employee.
     */
    public double getGross() {
        return gross;
    } // getGross

    /**
     * Returns the deductions of this {@code Employee}
     *
     * @return the deductions of the employee.
     */
    public double[] getDeductions() {
        return Arrays.copyOf(deductions, deductions.length);
    } // getDeductions

    /**
     * Returns the level of this {@code Employee}
     *
     * @return the level of the employee.
     */
    public int getLevel() {
        return level;
    } // getLevel

    /**
     * Returns a {@code String} representation of this 
     * {@code Employee} object in the format:
     *
     * <pre>{@code <Employee Name>
     * Level: <level>
     * Gross Pay: $<gross pay>
     * Deductions: 
     * 	 $<deduction1>
     * 	 $<deduction2>
     *	 ...}</pre>
     */
    public String toString() {
        String rc = name + "\n";
        rc += String.format("Level: %1d \n", level);
        rc += String.format("Gross Pay: $%.2f \n",  gross);
        rc += "Deductions: \n";
        for(double d: deductions) {
            rc += String.format("\t $%.2f\n", d) ;
        } // for
        return rc;
    } // toString

    /**
     * Generates a random employee object. The employee objects
     * are named "Employee" followed by an increasing numerical value
     * starting at 1. The first employee will be "Employee1" then
     * "Employee2" and so on.
     * The level is set to a random number between 1 and 5 (inclusive).
     * Gross salary is a random double between 100K and 1M
     * The number of deductions is between 1 and 5 (inclusive) and each
     * deduction is between 1K and 5K.
     * @return the generated {@code Employee} object.
     */
    public static Employee genEmployee() {

        String name = "Employee" + employeeCounter;
        employeeCounter++;

        int level = (int)(Math.random() * 5) + 1;

        double gross = (Math.random() * 500000) + 50000;

        int numDeductions = (int)(Math.random() * 5) + 1;
        double[] deductions = new double[numDeductions];
        for (int i = 0; i < numDeductions; i++) {
            deductions[i] = Math.random() * 5000 + 1000;
        } // for
        
        return new Employee(name, level, deductions, gross);
        
    } // genEmployee

} // Employee
