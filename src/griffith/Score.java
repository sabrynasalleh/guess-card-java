package griffith;

import java.time.LocalDate;

public class Score {
	
	//Test commit 1
	// Private attributes to store each data
	private String name;
	private int score;
	private LocalDate date;
	
	//Constructor
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
		this.date = LocalDate.now();
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	
	//toString method
	@Override
	public String toString() {
		 return String.format("| %-20s | %-6d | %-10s |",
		            name, score, date);
	}
}
