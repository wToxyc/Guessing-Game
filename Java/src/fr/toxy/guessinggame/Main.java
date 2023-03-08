package fr.toxy.guessinggame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		float secretNumber = (int) Math.floor(Math.random() * 100);
		int lifes = 10;
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println(Colors.RESET + "Guess the secret number!");
				
			while (!scanner.hasNextInt()) {
				
				System.out.println(Colors.RED + "Invalid number!");
				scanner.nextLine();
				System.out.print(Colors.RESET);
				
			}
			
			int inputNumber = scanner.nextInt();
			
			if (inputNumber < secretNumber) {
				
				System.out.println(Colors.RED + "You are smaller than the secret number!");
				
			} else if (inputNumber > secretNumber) {
				
				System.out.println(Colors.RED + "You are bigger than the secret number!");
				
			} else {
				
				System.out.println(Colors.GREEN + "Congratulations! You found the secret number!");
				break;
				
			}
			
			lifes--;
			String lifeColor = Colors.GREEN;
			
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
