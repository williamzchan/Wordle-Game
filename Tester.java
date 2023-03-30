/*
 * Tester.java 
 * 
 * A program that you can use to make test calls to the methods that you 
 * write as part of your Wordle implementation. 
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // sample test for the includes method
        System.out.println("\nTesting includes method...");
        boolean result = Wordle.includes("hello", 'e');
        System.out.println("includes(\"hello\", 'e') returns " + result);

        // Add additional tests below to ensure that your methods
        // work correctly.
        System.out.println("\nTesting includes method...");
        boolean result2 = Wordle.includes("hello", 'l');
        System.out.println("includes(\"hello\", 'l') returns " + result2);
        

        System.out.println("\nTesting includes method...");
        boolean result3 = Wordle.includes("goodbye", 'x');
        System.out.println("includes(\"goodbye\", 'x') returns " + result3);
        
       
        System.out.println();
        System.out.println(Wordle.isAlpha("Goodbye!"));
        System.out.println();
        System.out.println(Wordle.isAlpha("Hello"));

        System.out.println(Wordle.numOccur('l', "hello"));
        System.out.println();
        System.out.println(Wordle.numOccur('e', "hello"));
        System.out.println();
        System.out.println(Wordle.numOccur('x', "goodbye"));
        System.out.println();
        System.out.println(Wordle.numInSamePosn('p', "apple", "maple"));
        System.out.println();
        System.out.println(Wordle.numInSamePosn('a', "apple", "maple"));
        System.out.println();
        System.out.println(Wordle.numInSamePosn('a', "java", "mama"));
        System.out.println();
        System.out.println("isValidGuess test 1 " + Wordle.isValidGuess("hello"));
        System.out.println();
        System.out.println("isValidGuess test 2 " + Wordle.isValidGuess("hi"));
        System.out.println();
        System.out.println("isValidGuess test 3 " + Wordle.isValidGuess("what?"));
        System.out.println();
        System.out.println("isValidGuess test 4 " + Wordle.isValidGuess("abcde"));
        System.out.println();

        System.out.println("processGuess test 1 " + Wordle.processGuess("stain", "edict"));
        System.out.println("processGuess test 2 " + Wordle.processGuess("edict", "edict"));
        System.out.println("processGuess test 3 " + Wordle.processGuess("merit", "edict"));
        System.out.println("processGuess test 4 " + Wordle.processGuess("light", "edict"));
        System.out.println("processGuess test 5.1 " + Wordle.processGuess("heart", "depth"));

        System.out.println();
        System.out.println("processGuess test 5, task 5 " + Wordle.processGuess("loyal", "towel"));
        System.out.println("processGuess test 6, task 5 " + Wordle.processGuess("piper", "nippy"));


       

        console.close();

    }
}
