package fr.toxy.guessinggame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* Generating a random integer between 0, and 100
		 * Notice:
		 * 	Math.random() returns a random float between 0 and 1
		 * 	Math.floor() returns the rounded float entered
		 * For example:
		 * 	Math.random() will return 0.9200613377372193
		 * 	Math.floor() of Math.random() * 100 (Math.floor(Math.random) * 100) will return 2 numbers of Math.random() after decimal point
		 * 	For Math.random() = 0.9200613377372193, Math.floor() will returns 92
		 * WARNING:
		 * 	If you don't multiply your result, Math.floor(Math.random()) will returns 0.0 or 1.0
		 */
		float secretNumber = (int) Math.floor(Math.random() * 100);
		int lifes = 10;
		
		// Creating a console scanner
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			// Asking the user to guess the secret number
			System.out.println(Colors.RESET + "Guess the secret number!");
				
			// If the next user's input isn't an integer, return an error
			while (!scanner.hasNextInt()) {
				
				System.out.println(Colors.RED + "Invalid number!");
				scanner.nextLine();
				System.out.print(Colors.RESET);
				
			}
			
			// Getting the input number (next integer entered by the user)
			int inputNumber = scanner.nextInt();
			
			// Comparing the input number with the secret number
			if (inputNumber < secretNumber) {
				
				System.out.println(Colors.RED + "You are smaller than the secret number!");
				
			} else if (inputNumber > secretNumber) {
				
				System.out.println(Colors.RED + "You are bigger than the secret number!");
				
			} else {
				
				System.out.println(Colors.GREEN + "Congratulations! You found the secret number!");
				break;
				
			}
			
			// Decrementing lifes for each iteration
			lifes--;
			String lifeColor = Colors.GREEN;
			
			// Coloring the text depending of the number of lifes
			if (lifes > 5) {
				
				lifeColor = Colors.GREEN;
				
			} else if (lifes <= 5 && lifes > 3) {
				
				lifeColor = Colors.YELLOW;
				
			} else if (lifes <= 3 && lifes > 0) {
				
				lifeColor = Colors.RED;
				
			} else {
				
				System.out.println(Colors.RED + "Game over! No more life!");
				break;
				
			}
			
			System.out.println(lifeColor + "Lifes: " + lifes);
			
		}
		
		scanner.close();
		
	}

}
