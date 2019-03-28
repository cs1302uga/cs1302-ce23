# cs1302-ce23 - Java Stream API

> "Swims upstream because downstream is too mainstream"
> **-Salmon**

This first part of this exercise lets students experience creating a Maven project for an existing set of 
source code files. The remainder of the exercise focusses on using the Java Stream API to solve problems
more concisely and clearly.

## References and Prerequisites

* [Baeldung: Introduction to Java 8 Streams](https://www.baeldung.com/java-8-streams-introduction)
* [CSCI 1302 Maven Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Nike server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Nike into a subdirectory called `cs1302-ce23`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce23.git
   ```

1. Change into the `cs1302-ce23` directory that was just created and look around. There are couple
   files distributed with the exercise, but they are not organized! That's intentional. 
   Continue on to the [Exercise Steps](#exercise-steps) below.
   
### Exercise Steps

The starter code isn't organized properly! Instead of manually creating a default package
for the compiled code, let's 
[use Maven to create a project directory](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)
instead. Here, the term "project" informally refers to a collection of Java files and a POM organized / used 
by Maven.

1. Using Maven, create a project subdirectory for this exercise called `cs1302-ce23-mvn` with a primary 
   package called `cs1302.ce23`. In your notes, write down the full command that you used to accomplish 
   this.

1. Change into the `cs1302-ce23-mvn` directory that you just created using Maven, then update the POM
   so that the project works with Java 8. After that, use Git to track the `pom.xml`, then commit
   it to the repository.
   
1. Delete the Maven-generated driver (i.e., `src/main/java/cs1302/ce23/App.java`) and the unit test files 
   (i.e., everything under `src/test/java`), then move the `.java` files provided with the exercise into
   their proper locations under `src/main/java` according to their package statements. Take special
   care to use `git mv` instead of just `mv` when moving the files so that Git can still keep track
   of them! Once everything is in place, stage and commit the changes that you've made so far.
   
1. **Next, use Maven to compile the code.** We hope that you notice that you 
   did not need to manually compile the files according their dependencies -- Maven did it for you!
   
1. Run the `cs1302.ce23.StreamPractice` class. 

   1. Run using `java`. Be sure to specify the class path correctly based on the
      output provided by Maven during its `compile` phase.
      
   1. Run using `mvn` and the `exec:java` phase. See the 
      [CSCI 1302 Maven Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)
      for an example. When using the `exec:java` phase, Maven automagically adds everything to the
      class path, including JAR files for dependencies specified in `pom.xml`.
      
   If it worked, you will see the output from 10 
   randomly created `Employee` objects' `toString` method. We will use these objects to practice with 
   Java streams in the next checkpoint. Congratulations on creating a Maven project for a set of 
   existing source code files!
  
**CHECKPOINT**

Now that our code compiles and runs, let's practice with the Java Stream API. You should not use loops unless
a step explicitly asks you to use loops.

1. Print all level 3 employees --  each on one line.

1. Print the individual gross incomes of all employees that have a gross income greater than 
   200K -- each on their own line, prefixed with a `$` and formatted to display two digits after
   the decimal. For convenience, you might use the 
   [`String.format`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#format-java.lang.String-java.lang.Object...-)
   that works like `printf` but returns a `String`. 

1. Write a static method in the `StreamPractice` class called `getNetIncome` that takes an `Employee` reference
   as a parameter and returns the net income for the specified employee.  An employee’s net income is defined as
   their gross income minus the sum of their deductions. 
   
1. Print the individual net incomes of all employees -- each on their own line, 
   prefixed with a `$` and formatted to display two digits after the decimal.
   You should use the `getNetIncome` method that you wrote in the previous step.
   
**CHECKPOINT**

1. **TRICKY:** Write code that prints the sum of the net incomes for all high earning level 2 employees using the Java 
   Stream API. A high earning employee is one with a net income exceeding 100,000. You may write extra methods, 
   if needed. **Again, no loops.**

1. Sure, streams can be tricky at first but they are an extremely powerful tool. Now, try to write a solution 
   to the previous step using loops (no streams). Don't call any methods that use streams in your solution to 
   this step. Which solution do you prefer?

1. **THIS WOULD BE A GOOD TEST QUESTION:** Consider your stream-based solution to the previous questions. If a question 
   requires both a `map` and a `filter`, answer the following questions related to that code in your notes:
      * Would it be possible to change the order of the calls to `map` and `filter`? This may require other modifications
        to work properly.
      * If you can change the order, explain how this might impact overall processing time for that operation.

**CHECKPOINT**  

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>

