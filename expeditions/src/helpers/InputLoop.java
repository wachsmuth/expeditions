package helpers;

import java.util.Scanner;

public class InputLoop {

    public static int inputLoop(String question, String... options) {
        String answerString;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println(question);
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
                        // answerString = options.get(i);
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
	
}
