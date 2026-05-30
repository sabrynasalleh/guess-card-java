# Card Guess Game

A Java console-based card game where the player has to guess the next card will be higher or lower


---

## Features

### Difficulty Levels
Players choose a difficulty level before starting. Each level affects how many correct guesses are needed to win.

### Game Statistics
The game tracks:
- Total games played
- Games won
- Games lost

### Win Condition
Players must achieve a set number of correct guesses in a row depending on difficulty.

### Hint System
Players can use up to **3 hints per game** to help them decide their next move.

### Delay Simulation
A short delay is added when drawing cards to create suspense during gameplay.

### Restart System
After a game ends, players can:
- Restart the game
- Return to the main menu

---

## How to Play

1. A card is displayed
2. Player chooses:
   - `H` / `h` for Higher  
   - `L` / `l` for Lower  
   - `Hint` to use a hint (limited uses)
3. Correct guess → score increases
4. Wrong guess → game ends
5. Reach required streak → win

---

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Console-based input/output

---

## How to Run
1. Clone repository
2. Open project in IntelliJ IDEA or Eclipse
3. Run 'CardGame.java'

---

## Project Structure
- 'CardGame.java'      -> Starts the program
- 'Card.java'          -> Draws card
- 'Deck.java'          -> Shuffles deck and gets card
- 'GameProcess.java'   -> Handles game logic
- 'UserInterface.java' -> Manages interface for players

---

## Future Improvements
- GUI version using JavaFX  
- Better animations / visuals  
- Save high scores  
- Multiplayer mode

## What I Learned
This project helped me practice:
- Java OOP principles  
- Control flow and loops  
- User input handling  
- Game state management  
- Structuring a multi-class program

---

## Current Status
Actively improving