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

    private static final int NUM_EMPLOYEES = 10;
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        // Generate employees
        for(int i = 0; i < NUM_EMPLOYEES; i++) {
            employees.add(Employee.genEmployee());
        } // for

        // Print information about the employees
        for(Employee e: employees) {
            System.out.println(e);
        } // for

        System.out.println("YOUR STUFF BELOW\n");
        
        // Your code here

        
    } // main

} // StreamPractice
