# cs1302-ce23 - Java Stream API

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> "I swim upstream because downstream is too mainstream"
> **--Salmon**

This first part of this exercise lets students experience creating a Maven project for an existing set of 
source code files. The remainder of the exercise focuses on using the Java Stream API to solve problems
more concisely and clearly.

## Course-Specific Learning Outcomes
* **LO5.b:** (Partial) Utilize a build tool such as Maven or Ant to create and manage a
complex software solution involving external dependencies.
* **LO7.b:** Use stream-like operations (e.g., map, reduce, and filter in the Java Stream API) as an 
alternative to iteration in solving problems. Observe the difference between resulting implementations.

## References and Prerequisites

* [Baeldung: Introduction to Java 8 Streams](https://www.baeldung.com/java-8-streams-introduction)
* [CSCI 1302 Maven Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce23`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce23.git
   ```

1. Change into the `cs1302-ce23` directory that was just created and look around. There are couple
   files distributed with the exercise, but they are not organized! That's intentional. 
   Continue on to the [Exercise Steps](#exercise-steps) below.
   
## Exercise Steps

### Checkpoint 1 Steps

The starter code isn't organized properly! Instead of manually creating a default package
for the compiled code, let's 
[use Maven to create a project directory](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)
instead. Here, the term "project" informally refers to a collection of Java files and a POM organized / used 
by Maven.

1. Using Maven, create a project subdirectory for this exercise called `cs1302-ce23-mvn` with a primary 
   package called `cs1302.ce23`. Once this command completes successfully, you will have a `cs1302-ce23-mvn`
   subdirectory contained within your original `cs1302-ce23` directory. In your notes, write down the full 
   command that you used to accomplish this.

1. Change into the `cs1302-ce23-mvn` directory that you just created using Maven, then update the POM
   so that the project works with Java 8. After that, use Git to track the `pom.xml`, then commit
   it to the repository.
   
1. Delete the Maven-generated driver (i.e., `src/main/java/cs1302/ce23/App.java`) and the unit test files 
   (i.e., you can remove the entire `src/test` subdirectory), then move (using `git mv`) the `.java` files 
   provided with the exercise into their proper locations under `src/main/java` according to their package 
   statements. Take special care to use `git mv` instead of just `mv` when moving the files so that Git 
   can still keep track of them! 
   * Once everything is in place, stage and commit the changes that you've made so far. At this point, executing
     `git status` should say "nothing to commit (working directory clean)".
   
1. **Next, use Maven to compile the code.** We hope that you notice that you 
   did not need to manually compile the files according their dependencies -- Maven did it for you!
   
1. Run the `cs1302.ce23.StreamPractice` class in the two ways explained below. Make sure to write the 
   full execution command in your notes. 

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
  
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

Now that our code compiles and runs, let's practice with the Java Stream API. **You should not use loops unless
a step explicitly asks you to use loops**.

* **Quick Aside:** Suppose `array` is of type `Employee[]` and `list` is of type `List<Employee>`,
  you can create a stream from either as follows:
  * `Arrays.stream(array)`
  * `list.stream()`
  The actual variable names in the exercise may differ from the illustrative example above.

1. Print all level 3 employees --  each on one line. You can use the predefined `toString()` method to print an
   `Employee` object. 
      * Compile and run your code to verify that it is working. Since the `Employee` objects are randomly generated, 
      you should run the program multiple times and check the output.
      * For readability, be sure to include descriptive output before the level 3 employees are printed. For example,
      your code might print `CHECKPOINT 2.1: LEVEL 3 EMPLOYEES` followed by all of the level 3 employees.
      * Make sure your code passes `checkstyle` then stage and commit your changes.
      
1. Print the individual gross incomes of all employees that have a gross income greater than 
   200K -- each on their own line, prefixed with a `$` and formatted to display two digits after
   the decimal. For convenience, you might use the 
   [`String.format`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...))
   that works like `printf` but returns a `String`. 
      * Compile and run your code to verify that it is working. Since the `Employee` objects are randomly generated, 
      you should run the program multiple times and check the output.
      * For readability, be sure to include descriptive output before the gross incomes are printed. 
      For example, your code might print `CHECKPOINT 2.2: INCOME > 200K` followed by all of gross incomes.
      * Make sure your code passes `checkstyle` then stage and commit your changes.
      
1. Write a static method in the `StreamPractice` class called `getNetIncome` that takes an `Employee` reference
   as a parameter and returns the net income for the specified employee (Remember, no loops). 
   An employee’s net income is defined as their gross income minus the sum of their deductions. 
   **Note:** In this version of the `Employee` class, the deductions are dollar amounts, not percentages.
   
1. Print the individual net incomes of all employees -- each on their own line, 
   prefixed with a `$` and formatted to display two digits after the decimal.
   You should use the `getNetIncome` method that you wrote in the previous step. 
      * Compile and run your code to verify that it is working. Since the `Employee` objects are randomly generated, 
      you should run the program multiple times and check the output.
      * For readability, be sure to include descriptive output before the net incomes are printed. 
      For example, your code might print `CHECKPOINT 2.3: NET INCOME` followed by all of net incomes.
      * Make sure your code passes `checkstyle` then stage and commit your changes.
   
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. **TRICKY:** Write code that prints the sum of the net incomes for all high earning level 2 employees using the Java 
   Stream API. A high earning employee is one with a net income exceeding 100,000. You may write extra methods, 
   if needed. **Again, no loops.**
      * Compile and run your code to verify that it is working. Since the `Employee` objects are randomly generated, 
      you should run the program multiple times and check the output.
      * For readability, be sure to include descriptive output before the final value is printed. 
      For example, your code might print `CHECKPOINT 3.1:` followed by the final value.
      * Make sure your code passes `checkstyle` then stage and commit your changes.

1. Sure, streams can be tricky at first but they are an extremely powerful tool. Now, try to write a solution 
   to the previous step using loops (no streams). Don't call any methods that use streams in your solution to 
   this step. Which solution is cleaner and easier to read?

1. **THIS WOULD BE A GOOD TEST QUESTION:** Consider your stream-based solution to the previous questions. If a question 
   requires both a `map` and a `filter`, answer the following questions related to that code in your notes:
      * Would it be possible to change the order of the calls to `map` and `filter`? This may require other modifications
        to work properly.
      * If you can change the order, explain how this might impact overall processing time for that operation.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce23`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. If you created the API website, include the full link to the site you generated.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce23-doc
   ```

1. Change directories to the parent of `cs1302-ce23` (e.g., `cd ..` from `cs1302-ce23`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce23 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the submit command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>

