package cs1302.ce23;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Some starter code for practicing with streams. This class
 * creates a random {@code List} of {@code Employee} objects.
 * Streams can be used to process the elements of the list
 * efficiently with less code than loops.
 */
public class StreamPractice {

    private static int employeeCounter = 1;
    private static final int NUM_EMPLOYEES = 10;
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        //Generate some employees
        for(int i = 0; i < NUM_EMPLOYEES; i++) {
            employees.add(genEmployee());
        } // for

        //Print the information about the employees
        for(Employee e: employees) {
            System.out.println(e);
            System.out.println("==========");
        }

        /**
         * An employee’s net income is defined as their gross income 
         * minus their deductions. For example, an employee with a
         * gross income of 100 and two deductions {0.1, 0.25} has a
         * net income of 100 − 100(0.1 + 0.25) = 65. Write a code snippet
         * that, given a java.util.List of Employee objects called array, 
         * prints the sum of the net incomes for all high earning level 2
         * employees using the Java Stream API. A high earning employee
         * is one with a net income exceeding 100,000. You may
         * write extra methods, if needed. You may not use loops.
         */

        //Your code here

    } // main

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

} // StreamPractice
