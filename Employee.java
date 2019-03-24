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
    
} // Employee
