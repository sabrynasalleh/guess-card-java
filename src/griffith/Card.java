
package griffith;

public class Card {
	private int rank; // Assign variable for card rank
	private String suit; // Assign variable for card suit
	
	public Card(int rank, String suit) {
		this.rank = rank; //Initialise rank
		this.suit = suit; //Initialise suit
	}
	
	public int getRank() { //Getter method
		return rank;
	}
	
	public String getsuit() { //Getter method
		return suit;
	}

	public void drawingCard() {
		String rankStr; //To initialise a variable
		if (rank == 1) {
			rankStr = "A"; //To convert the numerical value to their rank 			
			} else if (rank == 11) {
				rankStr = "J"; //To convert the numerical value to their rank 
			} else if (rank == 12) {
				rankStr = "Q"; //To convert the numerical value to their rank 
			} else if (rank == 13) {
				rankStr = "K"; //To convert the numerical value to their rank 
			} else {
				rankStr = String.valueOf(rank); //To convert the numerical value to their rank (in this case it's still a number)
			}
			
		System.out.println("+-------+"); //To print card using ASCII art
		System.out.printf("| %-2s    |" + "\n", rankStr); //To print a random number or rank
		System.out.println("|       |"); //To print card using ASCII art
		System.out.printf("|   %-2s  |" + "\n", suit); //To print a random suit
		System.out.println("|       |"); //To print card using ASCII art
		System.out.printf("|     %-2s|" + "\n", rankStr); //To print a random number or rank
		System.out.println("+-------+"); //To print card using ASCII art
		}
		
}
