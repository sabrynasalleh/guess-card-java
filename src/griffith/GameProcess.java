
package griffith;
import java.util.Scanner; //Imports scanner to allow user input
import java.util.ArrayList;

public class GameProcess {
	private static int totalGames = 0; //Initialise a variable and to track counter throughout the class
	private static int totalLoss = 0; //Initialise a variable and to track counter throughout the class
	private static int totalWins = 0; //Initialise a variable and to track counter throughout the class
	
	public static void playGame(Scanner myscanner, int difficulty) throws InterruptedException{ //Allows delays
		boolean keepPlay = true; //Initialise a boolean to control game loop
		
		while (keepPlay) { //Starts a loop
	
			Deck deck = new Deck(); //Creates a deck object
			deck.shuffle(); // Initialise a shuffled deck
			Card[] cards = deck.getCards(); //Retrieves the shuffled card
			Card currentCard = cards[0]; //Sets the first card as the currentCard
			int win = 0; //Initialise the win
			int pointsToWin; //Initialise the points needed to win
			int hintsUsed = 0; //Initialise a variable to check how many hints used by the player
			int maximumHints = 3; //To store the maximum hints in a variable
			
			switch(difficulty) {
			case 1:
				pointsToWin = 3; // Player has to collect 3 points to win the easy level
				break;
			case 2: 
				pointsToWin = 5; //Player has to collect 5 points to win the medium level
				break;
			case 3:
				pointsToWin = 7; //Player has to collect 7 points to win the hard level
				break;
			default:
				pointsToWin  =3; //Acts as a fallback value
			}
			
			totalGames++; //Increase game counter every time the player starts the game
			
			System.out.println("\nTotal Hints Left: " + maximumHints);
			System.out.println("The first card is: "); //Displays the first card
			currentCard.drawingCard(); //Call drawingCard method from Card class to display the first card
			
			for (int i = 1; i < cards.length; i++) { //To loop through remaining card
				System.out.println("Will the next card be Higher (H) or Lower(L)?"); //Prompts the player to guess the next card
				System.out.println("Type \"Hint\" for a hint."); //Display hint option to the player
				String guess = UserInterface.validGuess(myscanner); //Allow user to input their guess
				
				if (guess.equalsIgnoreCase("hint")) { //Check if the input word is correct
					if (hintsUsed < maximumHints) { //Check if the player has used up all the hints
						boolean isHigher = cards[i].getRank() > currentCard.getRank(); //Initialise a variable to store data to determine if the next card is higher than the current card
						if (isHigher) {  //Check if the next card is higher than the current card
							System.out.println(UserInterface.BLUE + "Hint: You'll get a positive number if you subtract the next card rank with the current one." + UserInterface.RESET); //To display hint
						} else { //If the next card is lower than the current card
							System.out.println(UserInterface.BLUE + "Hint: The next card has to climb perhaps a few ranks to be equal with the current card." + UserInterface.RESET); // To display hint
						}
						hintsUsed++; //Increment every time player used a hint
						i--; //To skip incrementing i so that current round is replayed
						continue; //Go back to the top of the loop 
					} else { //If the player used up all the hint
						System.out.println(UserInterface.RED + "You used up all your hints!" + UserInterface.RESET); //To display error message
					i--; //To skip incrementing i so that current round is replayed
					continue; //Go back to the top of the loop
					}
				}
				
				Card nextCard = cards [i]; //Store the next card in cards index
				int hintsLeft = maximumHints - hintsUsed; //TO calculate how many hints left can be used by the player
				System.out.println("\nTotal Hints Left: " + hintsLeft); //Displays how many hints left for the player to use
				UserInterface.simulateDelay(); //Calls simulateDelay method from UserInterface class to display some delay (extra feature)
				System.out.println("The next card is:"); //Display the next card				
				nextCard.drawingCard(); //Call drawingCard method from Card class to display the next card
				
				boolean higherCard = nextCard.getRank() > currentCard.getRank(); //Check if the card is higher or lower
				
				if ((guess.equals("h") && higherCard) || (guess.equals("l") && !higherCard)) { //To check if the player guessed the card right
					System.out.println(UserInterface.GREEN + "\nYou are correct!" + UserInterface.RESET); //Display message to let player know they got a point
					win++; //Increase the point
					currentCard = nextCard; //Change the current card into the next card
				} else { //For remaining possibility (conditions are not met)
					System.out.println(UserInterface.RED + "\nYou've got it wrong! The game is over :(" + UserInterface.RESET); //Display message to let the player know they lost the game
					totalLoss++; //Update the total loss
					break; //To exit loop
				}
				
				if (win == pointsToWin) { //If the player reaches win conditions
					totalWins++; //Update total wins 
					System.out.println(UserInterface.GREEN + "\nCongratulations! You win the game! 🎉" + UserInterface.RESET); //Display message to let the player know they've won the game
					System.out.println("Save progress? Y/N");
					String progress = myscanner.next();
					if(progress.equals("Y") || progress.equals("y")) { //Determine user input
						System.out.println("Enter your name: ");
						String name = myscanner.next();
						Score newScore = new Score(name, win); //Create a HighScore object
						
						boolean saved = HighScoreManager.saveScore(newScore);
						
						if (saved) {
							System.out.println("Score saved to leaderboard!");
						} else {
							System.out.println("Score was not high enough for top 10.");
						}
						
					}
					break; //To exit loop
				}
			}
			
			if (win != pointsToWin) { //If the player had guessed a card, this code will be executed
				int remaining = pointsToWin - win; //To calculate the remaining to get right before winning the game
				System.out.println("You correctly guessed the card " + win + " time(s)! You need " + remaining + " more to win."); //Display to the player
			}
			
			System.out.println(UserInterface.BLUE + "\nTotal Games Played: " + totalGames + UserInterface.RESET); //Display to player total games they played
			System.out.println(UserInterface.GREEN + "Total Wins: " + totalWins + UserInterface.RESET); //Display to player total wins they had
			System.out.println(UserInterface.RED + "Total Loss: " + totalLoss + UserInterface.RESET); //Display to player total loss they had
			System.out.println("\nWould you like to play again?"); //Give player option to continue or back to main menu
			System.out.println("1. Yes"); //Display option to player
			System.out.println("2. No, return to main menu"); //Display option to player
			System.out.print("Enter your choice: "); //Prompts the player to enter their choice
			
			int choice = UserInterface.userChoice(myscanner, 1, 2); //Allow user to input their choice
			if (choice == 2) { //To execute this code if the player chooses the number 2
				System.out.println("Returning to the main menu..."); //Display message to main menu to player
				break; //Exit loop
			}
		}
		
	}

}
