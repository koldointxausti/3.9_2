import hangman.*;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Game game = new Game();
			System.out.println("Good luck, start with the first letter.");
			game.printVoids();
			char[] guessed = new char[3];
			int flag = 0;
			while (flag < 3) {
				String letter = sc.nextLine();
				letter.trim().toLowerCase();
				char[] letterArray = letter.toCharArray();
				if(letterArray.length==1) {
					if(Character.isLetter(letterArray[0])) {
						guessed[flag] = letterArray[0];
						game.setGuessed(guessed);
						game.checkLetter(guessed[flag]);
						game.printGuessed();
					}else 
						System.out.println("It has to be a letter. No numbers / symbols");
				}else
					System.out.println("Don't cheat, enter just a letter");
				flag++;
				if (flag == 1)
					System.out.println("You can enter just two letters more");
				else if (flag == 2)
					System.out.println("You can enter just a letter more");
			}
			System.out.println("It's time, you gotta try to guess the whole word");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String playerWord = sc.nextLine();
				// check the user has entered just one word
				String[] playerWordArray = playerWord.split(" ");
				if (playerWordArray.length == 1) {
					// check if the word the user enters has a number
					boolean hasNumber = false;
					for (int i = 0; i < playerWordArray[0].length(); i++) { // taking each letter
						if(!Character.isLetter(playerWordArray[0].charAt(i))) {
							hasNumber = true;
							break;
						}
					}
					if (hasNumber == false) {
						wordEntered = true; // to go out of the loop
						if (playerWordArray[0].compareTo(game.getRandomSurname()) == 0)
							System.out.println("Congrats, you won the game");
						else
							System.out.println("Sorry, you lost. The surname was " + game.getRandomSurname());
					} else
						System.out.println("Please, enter a real number (no numbers)");
				} else
					System.out.println("Please enter just one word");
			}
			System.out.println("Would you like to play again? (y/n)");
			boolean askAgain = true;
			while (askAgain) {
				char answer = sc.next().toLowerCase().charAt(0);
				sc.nextLine();
				switch (answer) {
				case 'y':
					askAgain = false; // get out of this loop but no out of the biggest loop (playAgain)
					break;
				case 'n':
					askAgain = false; // get out of this loop
					playAgain = false; // get out of the biggest loop (playAgain)
					break;
				default:
					System.out.println("Please, select a posible answer ('y' for yes/ 'n' for no)");
					break;
				}
			}
		}
		sc.close();
	}

}
