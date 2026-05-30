
package griffith;
import java.util.Scanner; //Imports scanner to allow user input

public class CardGame {

	public static void main(String[] args) throws InterruptedException{ //throws InterruptedException allows program to handle delays simulation
		// TODO Auto-generated method stub
		Scanner myscanner = new Scanner(System.in); //Creates a scanner to read user input
		boolean keepPlay = true; //Initialise a boolean variable to control the main game loop
		
		while (keepPlay) { //Starts a loop
			UserInterface.welcomeScreen(); //Calls welcomeScreen() method from UserInterface to display welcome screen with main menu
			
			System.out.println("1. Start Game"); //Prints the main menu option to user
			System.out.println("2. View Game Rules"); //Prints the main menu option to user
			System.out.println("3. Exit Game"); //Prints the main menu option to user
			System.out.print("Enter choice: "); //Prompts user to pick an option 
			int choice = UserInterface.userChoice(myscanner, 1,3); //Calls userChoice method in UserInterface class to validate user input
			
			switch (choice) { //To create possible case for each option chosen
			case 1:
				UserInterface.showDifficulty(); //To display the difficulty level of the game before playing
				int difficulty = UserInterface.getDifficultyLevel(myscanner); //To get user input on the level chosen 
				GameProcess.playGame(myscanner, difficulty); //Starts the game by calling playGame method in GameProcess class
				break;
			case 2:
				UserInterface.gameRules(); //Display game rules to player by calling gameRules method in UserInterface class
				System.out.println("Choose an option:"); //Display next action for player by giving options
				System.out.println("1. Start game"); //Display option to player
				System.out.println("2. Back to main menu"); //Display option to player
				int option = UserInterface.userChoice(myscanner, 1, 2); //Calls userChoice method in UserInterface class to validate user input
				
				if (option == 1) { //To execute a certain code if condition is true
					UserInterface.showDifficulty(); //To display the difficulty level of the game before playing
					int level = UserInterface.getDifficultyLevel(myscanner); //To get user input on the level chosen 
					GameProcess.playGame(myscanner, level); //Starts the game by calling playGame method in GameProcess class
				} else { // To execute a different code if the condition isn't met
					break; //To exit if else condition
				}
				keepPlay = false; //To exit loop
				break;
			case 3:
				System.out.println(UserInterface.GREEN + "Thanks for playing! You're exiting the game."); //Display exit message to user that choose this option
				keepPlay = false; //To exit loop
				break;
			}
		}
		
		myscanner.close(); //To close scanner user input
	}

}
