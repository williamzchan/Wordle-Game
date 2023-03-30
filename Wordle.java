
/*
 * Wordle.java 
 * 
 * An console-based implementation of a popular word-guessing game
 * 
 * starter code: Computer Science 112 staff (cs112-staff@cs.bu.edu)
 *
 * completed by: 
 */

import java.io.Console;
import java.util.*;

public class Wordle {
    // the name of a file containing a collection of English words, one word per line
    public static final String WORD_FILE = "words.txt";

    /*
     * printWelcome - prints the message that greets the user at the beginning of the game
     */  
    public static void printWelcome() {
        System.out.println();   
        System.out.println("Welcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.");
        System.out.println();
    }
    
    /*
     * initWordList - creates the WordList object that will be used to select
     * the mystery work. Takes the array of strings passed into main(),
     * since that array may contain a random seed specified by the user 
     * from the command line.
     */
    public static WordList initWordList(String[] args) {
        int seed = -1;
        if (args.length > 0) {
            seed = Integer.parseInt(args[0]);
        }

        return new WordList(WORD_FILE, seed);
    }

    /*
     * readGuess - reads a single guess from the user and returns it
     * inputs:
     *   guessNum - the number of the guess (1, 2, ..., 6) that is being read
     *   console - the Scanner object that will be used to get the user's inputs
     */
    public static String readGuess(int guessNum, Scanner console) {
        String guess;
        do {
            System.out.print("guess " + guessNum + ": ");
            guess = console.nextLine();
        } while (isValidGuess(guess) == false);

        return guess;
        }

    /**** ADD YOUR METHODS FOR TASK 1 HERE ****/
    
    /* A static method that takes two parameters s a String and c a char. 
    * where c is compared to s and if c is present then true is returned and false if not
    */
    public static boolean includes(String s, char c){
        boolean includes;
        if(s.indexOf(c) == -1){
            includes = false;

        }else{
            includes = true;
        }
        return includes;
    }
    /* A string is taken as an input. The string is tested to see if it only contains letters.
    * If it has non- alphabetical letter like ! or ? or numbers, false is returned.
    */
    public static boolean isAlpha(String s){

        boolean alphaOnly = true;

        for(int i = 0; i < s.length(); i++){

            alphaOnly = Character.isAlphabetic(s.charAt(i));
            if(alphaOnly == false){
                return alphaOnly;
            }


        }
        return alphaOnly;
    }
    /* a char c is passed through a String s where the amount of times
    * the character c appears in String s is counted and tracked.
    */
    public static int numOccur(char c, String s){
        int counter = 0;
        char ofS;

        for(int i = 0; i < s.length(); i++){
            ofS = s.charAt(i);
            if(ofS == c){
                counter += 1;
            }

        }
        
        return counter;
    }

    /* takes two strings and a single char c. The method tests how many of the same indexes share the same  
    * characters between String s1 and String s2.
    */
    public static int numInSamePosn(char c, String s1, String s2){
        int numOfPosn = 0;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == c && s2.charAt(i) == c){
                numOfPosn++;

            }


        }
        return numOfPosn;

    }

    /*
     * TASK 2: Implement this method
     * 
     * isValidGuess -  takes an arbitrary string guess and returns true
     * if it is a valid guess for Wordle, and false otherwise
     */

     /* Takes in a string and tests to see if the 
     * string is a valid five-letter string. Based on the game wordle. 
     */
    public static boolean isValidGuess(String guess) {

        int lengthOfGuess = guess.length();

        if(lengthOfGuess != 5){

            System.out.println("The guess must be 5 letters, dummy!");
            return false;
        }
        for(int i = 0 ; i < guess.length(); i++){

                if(Character.isAlphabetic(guess.charAt(i)) == false){
                    System.out.println("Please only include letters! Jesus!");
                    return false;         
            }
        }
        return true;
    }
        

    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/
    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/

    /* This method will process all strings inputted. It then will output an underscore, bracketed letter,
    * or a letter. Rules based on the game wordle.  
    */
    public static boolean processGuess(String guess, String mystery){

        if(guess.equals(mystery)){
            
            System.out.println(guess.charAt(0) + " " + guess.charAt(1) + " " + guess.charAt(2) + " " + guess.charAt(3) + 
            " " + guess.charAt(4) + " " );
            return true;
                            
        } 
            
        for(int i = 0 ; i < mystery.length(); i++){
            
            int charAtHolder = mystery.indexOf(guess.charAt(i));
            // if letter not in index than -1
            if(charAtHolder == -1 ){
                System.out.print("_ ");

            }else if(guess.charAt(i) == mystery.charAt(i)){
                System.out.print(guess.charAt(i) + " ");
            /*
            *splice guess in half than compare letter 
            *to first half than second half of mystery
            *and use numOccur s1.substring(1, 4)
            */
            }else if(guess.charAt(i) == mystery.charAt(charAtHolder)){
             
                if(numInSamePosn(guess.charAt(i), guess, mystery) < numOccur(guess.charAt(i), mystery)){
                
                    System.out.print("[" + guess.charAt(i) + "] ");
            
                }else {
                    System.out.print("_ ");

                }
            }
        }
        System.out.println();

        return false;
    }
    
  



    // main method which runs everything
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        printWelcome();

    
        // Create the WordList object for the collection of possible words.
        WordList words= initWordList(args);

        // Choose one of the words as the mystery word.
        String mystery = words.getRandomWord();
        
        /*** TASK 4: Implement the rest of the main method below. ***/
        // readGuess first then processGuess
        //keeps track of our worldle game. Every user gets 6 attempts as seen in the official wordle. 
        int tracker = 0;
        for(int i = 0 ; i < 7; i++){
           
            tracker++;

            String guess = readGuess(tracker, console);
            
            if(processGuess(guess, mystery) == true){
                System.out.println();
                System.out.println("Congrats! You guessed it!");
                break;
                //maybe it is 7
            }else if(tracker == 6){
                System.out.println("Sorry! Better luck next time!");
                System.out.println("The word was " + mystery);
                break;
            }
           
                
            
        }
       
    }
}









