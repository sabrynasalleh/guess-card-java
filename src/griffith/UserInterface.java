
package griffith;
import java.util.Scanner;

public class UserInterface {

	public static final String RESET = "\u001B[0m"; //To initialise a variable, store constant and to use throughout the classes
	public static final String GREEN = "\u001B[32m"; //To initialise a variable, store constant and to use throughout the classes for font color
	public static final String RED = "\u001B[31m"; //To initialise a variable, store constant and to use throughout the classes for font color
	public static final String BLUE = "\u001B[34m"; //To initialise a variable, store constant and to use throughout the classes for font color
	
	public static void welcomeScreen() { //Creates a welcome screen
		System.out.println(BLUE + "  ______________________________\r\n"
				+ " / \\                             \\.\r\n"
				+ "|   |                            |.\r\n"
				+ " \\_ |                            |.\r\n"
				+ "    |                            |.\r\n"
				+ "    |        Welcome to          |.\r\n"
				+ "    |      Higher or Lower       |.\r\n"
				+ "    |        Card Game           |.\r\n"
				+ "    |                            |.\r\n"
				+ "    |         ♠     ♥            |.\r\n"
				+ "    |            ♦     ♣         |.\r\n"
				+ "    |   _________________________|___\r\n"
				+ "    |  /                            /.\r\n"
				+ "    \\_/____________________________/." + RESET); //To display ASCII art and welcome players
		System.out.println(GREEN + "\n🍀 Feeling Lucky? Test your luck today 🍀\n" + RESET); //Display a tagline to attract player
		
	}	
	
	public static void showDifficulty() {
		System.out.println("\nSelect Difficulty Level:"); //To display difficulty level
        System.out.println("1. Easy - Streak of 3 to win"); //To display difficulty level
        System.out.println("2. Medium - Streak of 5 to win"); //To display difficulty level
        System.out.println("3. Hard - Streak of 7 to win"); //To display difficulty level
        System.out.print("Enter your choice: "); //Prompts user to enter an input
	}
	
	public static void gameRules() { 
		System.out.println("\nGame Rules:"); //To display the rules of the game
		System.out.println("1. A random card will be picked out from the deck and be shown to the player."); //To display the rules of the game
		System.out.println("2. Player has to guess if the next card that will be drawn from the deck is higher and lower than the current one."); //To display the rules of the game
		System.out.println("3. If the player guess a card right, the player will earn one point."); //To display the rules of the game
		System.out.println("4. The player will win if they manage to collect a certain points continuously according to the difficulty level."); //To display the rules of the game
		System.out.println("5. If the player guesses the card wrong, they will lose and the game will end.\n"); //To display the rules of the game
	}
	
	public static int getDifficultyLevel(Scanner myscanner) {
		int difficulty; //Initialise a variable
		while (true) { //Starts looping
			try {
				difficulty = Integer.parseInt(myscanner.nextLine()); //Enable user input to be converted to integer
				if (difficulty >= 1 && difficulty <= 3 ) { //To check if it met the condition
					return difficulty; //Return back to continue the game
				} else { //For input that does not met condition (numbers that are not between 1 to 3)
					System.out.println(RED + "Invalid choice. Please select between 1 and 3." + RESET); //To display error message
				}
			} catch (NumberFormatException e) { //For input that is not numeric
				System.out.println(RED + "Invalid input. Please enter a number between 1 and 3." + RESET); //To display error message
			}
		}
	}
	
	public static int userChoice( Scanner myscanner, int min, int max) { //To get the user's choice
		int choice; //Initialise a variable
		while (true) { //Starts looping
	        try { //To ensure user enters a valid input
	        	choice = Integer.parseInt(myscanner.nextLine()); //To convert string to integer
	            if (choice >= min && choice <= max) { //To check if the condition is met
	            	return choice; //To return a correct and matched value to the main class
	            } else { //For remaining possibility (number that is not between the minimum and maximum given)
	                System.out.println(RED + "Enter a number between " + min + " and " + max + "." + RESET); //Display error message
	            }
	        } catch (NumberFormatException e) { //This executes when user enters any character that is not a number or a number with other character or alphabet
	        	System.out.println(RED + "Invalid input. Please enter a valid number." + RESET); //Display error message
	        }
		}
	}
	
	public static String validGuess(Scanner myscanner) {
		while (true) { //Starts looping
			String input = myscanner.nextLine().trim().toLowerCase(); //To receive input, trim input and convert the alphabet input to lowercase
			if (input.equals("h") || input.equals("l") || input.equals("hint")) { //Ensures correct input
				return input; //Return the correct and matched input to the main class
			} else { //For invalid input
				System.out.println(RED + "Invalid input. Enter either 'H' for Higher Card, 'L' for Lower Card or 'Hint' for Hint" + RESET); //Display error message
			}
		}
	}
	
	public static void simulateDelay() throws InterruptedException { //To create and allow delay
		System.out.println("Drawing the next card"); //Display what the system is doing
		for(int i = 0; i < 3; i++) { //Used to repeat a block of code several times
			Thread.sleep(500); //Loads the system for a certain amount of time
			System.out.print("."); //Displays visual presentation of loading
		}
		System.out.println(); //To print empty line
	}
}
