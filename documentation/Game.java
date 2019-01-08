/**
* The Game program implements a class that
* can be used to create Hangman games.
*
* @author AnderGonzalez
* @version 1.0
* @since 2019-01-08
*/
package hangman;

import java.util.Random;

public class Game {
	private char[] guessed=new char[3];
	private int guessedCounter=0;
	private String randomSurname="";
	/**

	 * Game constructor which will assign a random surname to the property "randomSurname".

	 */
	public Game() {
		// Save into an array all the surnames of the people in class
		String[] surnames = {"lazkano","intxausti","artola","alberdi","lekubide","ortiz","gonzalez"};
		// Take randomly a surname between them
		this.randomSurname = surnames[new Random().nextInt(surnames.length)];
	}
	/**

     * guessed getter method

     * @return The char array guessed

     */
	public char[] getGuessed() {
		return this.guessed;
	}
	/**

     * Guessed setter method

     * @param guessed The new guessed char array

     */
	public void setGuessed(char[] guessed) {
		this.guessed=guessed;
	}
	/**

     * randomSurname getter method

     * @return The randomSurname of the game

     */
	public String getRandomSurname() {
		return this.randomSurname;
	}
	/**

     * randomSurname setter method

     * @param randomSurname The new randomSurname of the game

     */
	public void setRandomSurname(String randomSurname) {
		this.randomSurname=randomSurname;
	}
	/**

	 * A method to print the randomSurname hidden with voids

	 */
	public void printVoids() {
		// Print the word with voids
		for (int i = 0; i < this.randomSurname.length(); i++) {
			System.out.print("_ ");
		}
	}
	/**

	 * A method to print the randomSurname with the letters guessed by the player and the rest voids

	 */
	public void printGuessed() {
		// Print the surname with only the letters that the player guessed
		for (int surnameIndex = 0; surnameIndex < this.randomSurname.length(); surnameIndex++) {
			boolean found = false;
			for (int guessedIndex = 0; guessedIndex < guessed.length; guessedIndex++) {
				if (guessed[guessedIndex] == this.randomSurname.charAt(surnameIndex)) {
					System.out.print(this.randomSurname.charAt(surnameIndex) + " ");
					found = true;
				}
			}
			if (!found) {
				System.out.print("_ ");
			}
		}
	}
	/**

	 * A method to check if the letter the player entered is in the randomSurname

	 * @param playerLetter The letter the user entered

	 */
	public void checkLetter(char playerLetter) {
		for (int surnameIndex = 0; surnameIndex < this.randomSurname.length(); surnameIndex++) {
			if (this.randomSurname.charAt(surnameIndex) == playerLetter) {
				// If it is, open another loop which will go checking if the player had already
				// guessed that letter
				boolean found = false;
				int guessedIndex = 0;
				while (guessedIndex < this.guessed.length && this.guessed[guessedIndex] != playerLetter
						&& !found) {
					// Check that the cell of the array is empty
					if (!Character.isLetter(this.guessed[guessedIndex])) {
						// If he/she had not done so, save the letter in the array 'guessed'
						this.guessed[this.guessedCounter] = this.randomSurname.charAt(surnameIndex);
						// Increment once the variable 'guessedCounter' for a future possible letter
						this.guessedCounter++;
						// Define the variable 'found' as true so as to get out of the loop
						found = true;
					}
					// Increment the variable 'guessedIndex' so as to check the next letter of the array
					// 'guessed'
					guessedIndex++;
				}
				break;
			}
		}
	}
	/**

	 * A method to check if the surname the player entered is the randomSurname

	 * @param playerWord The word the user entered
	 * @return True if what the player entered is the randomSurname, otherwise false.

	 */
	public boolean checkWord(String playerWord) {
		if (playerWord.equals(this.randomSurname)) {
			return true;
		} else {
			return false;
		}
	}
	/**

	 * A method to check if what the player entered is a letter

	 * @param entered What the player entered
	 * @return True if what the player entered is a letter, otherwise false.

	 */
	public boolean isLetter(String[] entered) {
		boolean isLetter=true;
		if (entered.length==1) {
			String[] letterArray = entered[0].split(" ");
			if (letterArray.length == 1) {
				// Check that the player has entered just a character
				if (letterArray[0].length() == 1) {
					if (!Character.isLetter(letterArray[0].charAt(0))) {
						isLetter=false;
					}
				}else {
					isLetter=false;
				}
			}else {
				isLetter=false;
			}
		}else {
			isLetter=false;
		}
		if (isLetter) {
			return true;
		}else {
			return false;
		}
	}
	/**

	 * A method to check if what the player entered is a word

	 * @param entered What the player entered
	 * @return True if what the player entered is a word, otherwise false.

	 */
	public boolean isWord(String[] entered) {
		boolean isWord=true;
		if (entered.length==1) {
			String[] letterArray = entered[0].split(" ");
			if (letterArray.length == 1) {
				for (int i=0;i<letterArray[0].length();i++) {
					if (!Character.isLetter(letterArray[0].charAt(i))) {
						isWord=false;
						break;
					}
				}
			}else {
				isWord=false;
			}
		}else {
			isWord=false;
		}
		if (isWord) {
			return true;
		}else {
			return false;
		}
	}
}