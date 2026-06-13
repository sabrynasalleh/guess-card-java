
package griffith;
import java.util.Random; //Imports random class to generate random numbers

public class Deck {
	private String[] suits = {"♠", "♥", "♦", "♣"}; //Declares array string to assign suits
	private Card[] cards; //Declares array of card objects
	
	public Deck() {
		cards = new Card[52]; //To create a deck of 52 cards
		int index = 0; //Initialise a variable and set it to zero
		
		for (String suit : suits) { //To loop and go through each card
			for (int rank = 1; rank <= 13; rank++) { //To assign card values from 1 to 13 for all 52 cards
				cards[index++] = new Card(rank, suit); //Assign rank and suit
			}
		} 
	}
	
	public void shuffle() {
		Random random = new Random(); //Creates a random object to generate numbers
		for (int i = 0; i < cards.length; i++) { //To loop and go through each card
			int randomNum = random.nextInt(cards.length); //Generates a random number
			Card temp = cards[i]; //Stores the number temporarily in index i
			cards[i] = cards[randomNum]; //Replaces card at index i with the card at randomNum
			cards[randomNum] = temp; //Assign the temporarily stored card to randomNum
		}
	}
	
	public Card[] getCards() {
		return cards; //To return the cards array with value
	}
}
