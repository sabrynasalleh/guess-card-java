package griffith;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoreManager {
	// Private attributes
	private static final String FILENAME = "scoreinfo.txt";
	
	//Method to load scores
	public static ArrayList<Score> loadScores() {
		
		ArrayList<Score> scores = new ArrayList<>();
		
		try {
			File file = new File(FILENAME); //Create a file object
			if (!file.exists()) { //Check file's existence
				file.createNewFile(); //Create file
			}
			BufferedReader read = new BufferedReader(new FileReader(FILENAME));
			
			String line;
			
			while((line = read.readLine()) != null) { //Read all filled lines
			
			//file.getAbsolutePath(); //Get absolute path of the file
		
				String[] parts = line.split(","); //Split each line into players name, score and date
				
				String name = parts[0];
				int scoreValue = Integer.parseInt(parts[1]);
				
				scores.add(new Score(name, scoreValue));
			}
			
			read.close();
			
		}catch(IOException | NumberFormatException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
		
		return scores;
	}
	
	//Method to save, sort, trim scores
	public static boolean saveScore(Score newScore) {
		ArrayList<Score> scores = loadScores();
		
		scores.add(newScore); //Add new score
		scores.sort((a, b) -> b.getScore() - a.getScore()); //Sort highest first
		
		if(scores.size() > 10) { //Make sure only 10 top scorers are recorded
			scores = new ArrayList<>(scores.subList(0, 10));
		}
		
		writeToFile(scores); //Add to file
		
		return scores.contains(newScore) || scores.size() <= 10; //Improvement #1
		
	}
	
	//Method to write score to file
	public static void writeToFile(ArrayList<Score> score) {
		try(BufferedWriter write = new BufferedWriter(new FileWriter(FILENAME))){ //Open file to write
			for(Score s: score) { //Loop over the score list
				write.write(s.getName() + "," + s.getScore() + "," + s.getDate()); //Write each attribute to file
				write.newLine();//Debug #1
			}
		} catch(IOException e) {
			System.err.println("Error writing file.");
		}
	}
	
	public static void displayScores(ArrayList<Score> score) {
		if(score.isEmpty()) {
			System.out.println("\nNo one has played yet!");
			return;
		}
		
		  System.out.println("+----------------------+--------+------------+");
		    System.out.println("| Player Name          | Score  | Date       |");
		    System.out.println("+----------------------+--------+------------+");

		    for (Score s : score) {
		        System.out.println(s);
		    }

		    System.out.println("+----------------------+--------+------------+");
	}
}
