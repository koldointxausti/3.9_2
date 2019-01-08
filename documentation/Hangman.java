package hangman;

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Game game = new Game();
			game.printVoids();
			// Open a loop that will go asking to the player a possible letter in each turn
			int tries = 0;
			while (tries < 3) {
				// Create a string object with the letter's value
				String entered[] = sc.nextLine().toLowerCase().split(" ");
				if (game.isLetter(entered)) {
					char playerLetter = entered[0].charAt(0);
					// Open a loop that will go checking if the letter the player entered is in the
					// surname
					game.checkLetter(playerLetter);
					// Increment 'tries' so as to ask for another letter
					tries++;
				}else {
					System.out.println("Please, enter a letter.");
				}
				game.printGuessed();
				// Print to the letters that the player has left
				if (tries == 1) {
					System.out.println("You have two letters left.");
				} else if (tries == 2) {
					System.out.println("You have just a letter left.");
				}
			}
			// Ask to the player a possible word
			System.out.println("It's the time, you have to guess the word.");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String[] playerWordArray = sc.nextLine().split(" ");
				if (game.isWord(playerWordArray)) {
					String surnameEntered=playerWordArray[0];
					if (game.checkWord(surnameEntered)){
						System.out.println("Congrats, you won the game.");
					}else {
						System.out.println("I'm sorry, you lost the game.");
					}
					wordEntered=true;
				} else {
						System.out.println("Please, enter a surname.");
				}
			}
			// Ask if the player wants to play again
			System.out.println("Would you like to play again?(y/n)");
			boolean askAgain = true;
			while (askAgain == true) {
				String back = sc.next().toLowerCase();
				sc.nextLine();
				switch (back) {
				case "y":
					// Get out of the loop and play again
					askAgain = false;
					break;
				case "n":
					// Get out of the loop and terminate the program
					playAgain = false;
					askAgain = false;
					break;
				default:
					// Ask for a possible value again
					System.out.println("Please, select a possible value(y/n)");
					break;
				}
			}
		}
		sc.close();
	}

}
