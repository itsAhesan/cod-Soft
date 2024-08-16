package com.codSoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int score = 0;
	        int maxAttempts = 10;
	        boolean playAgain = true;

	        while (playAgain) {
	            System.out.println("\nNew Round");
	            int numberToGuess = random.nextInt(100) + 1;
	            int attempts = 0;
	            boolean correctGuess = false;

	            while (attempts < maxAttempts && !correctGuess) {
	                System.out.print("Enter your guess (between 1 and 100): ");
	                int guess = scanner.nextInt();
	                attempts++;

	                if (guess < numberToGuess) {
	                    System.out.println("Too low!");
	                } else if (guess > numberToGuess) {
	                    System.out.println("Too high!");
	                } else {
	                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
	                    correctGuess = true;
	                    score += (maxAttempts - attempts + 1);
	                }
	            }

	            if (!correctGuess) {
	                System.out.println("You've used all attempts. The correct number was " + numberToGuess + ".");
	            }

	            System.out.println("Your current score is: " + score);

	            System.out.print("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next().equalsIgnoreCase("yes");
	        }

	        System.out.println("Thank you for playing! Your final score is: " + score);
	        scanner.close();
	    }
	

}
