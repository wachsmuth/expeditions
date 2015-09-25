package helpers;

import java.util.ArrayList;
import java.util.Scanner;

public class InputLoop {

    public static int inputLoop(String... options) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Valid input is: ");
        int j = 0;
        int[] noOfOptions = new int[options.length];
        for (String s : options) {
            noOfOptions[j] = j + 1;
            j++;
            System.out.println(j + ": " + s);
        }
        int userInput;
        inputloop:
        while (true) {
            try {
                System.out.print("Enter your input: ");
                String userInputRaw = inputScanner.nextLine();
                userInput = Integer.parseInt(userInputRaw);
                for (int i : noOfOptions) {
                    if (userInput == i) {
                        break inputloop;
                    }
                }
                System.out.println("Not on the list of permitted input."); //If wrong number
            } catch (NumberFormatException e) {
                System.out.println("Input is not of correct type"); //this prints if 
                //Do nothing. We keep trying.
            }
        }
        return userInput;
    }
    
    public static <T> int inputLoop(String question, ArrayList<T> stuff){
    	String[] arguments = new String[stuff.size()];
    	arguments = stuff.toArray(arguments);
    	System.out.println(question);
    	return inputLoop(arguments);
    }
    /*
    public static <T> T inputLoop(ArrayList<T> stuff) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Valid input is: ");
        for (int i = 0; i < stuff.size(); i++) {
            System.out.println(i + " " + stuff.get(i));
        }
        int userInput;
        inputloop:
        while (true) {
            try {
                System.out.print("Enter your input: ");
                String userInputRaw = inputScanner.nextLine();
                userInput = Integer.parseInt(userInputRaw);
                //Check for extended commands
                if (userInput < stuff.size() && userInput >= 0) {
                    return stuff.get(userInput);
                }
                System.out.println("Not on the list of permitted input."); //If wrong number
            } catch (NumberFormatException e) {
                System.out.println("Input is not of correct type"); //this prints if 
                //Do nothing. We keep trying.
            }
        }
    }*/
	
}
