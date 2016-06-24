package assignment2;

import java.lang.StringBuilder;
import java.util.Random;
import java.util.Scanner;

/**
 * This class controls the general game state
 * @author danny
 *
 */
public class Game {
	
	/* Fields for class Game */
	private String colors = "RYBGPM";
	private String code = generateCode(colors, 4);
	private boolean activeGame = true;
	private int availableGuesses = 12;
	private boolean showSecret = false; 
	
	public Game(){
		
	}
	
	/**
	 * Constructor for game with user specified rules
	 * @param cl The colors we are playing with, passed as a String of capital letters
	 * @param guesses Allowed The amount of guesses a player is allowed before they lose the game
	 * @param codeLen Length of the code that the player must guess
	 */
	public Game(Boolean test, String cl,  int guessesAllowed, int codeLen){
		colors = cl;
		availableGuesses = guessesAllowed;
		code = generateCode(colors, codeLen);
	}
	//
	/**
	 * Method will being the game and run the game until it is flagged to stop 
	 */
	public  void runGame (){
		Board gameBoard = new Board(code, code.length());
		History log = new History(); 
		if (showSecret) {
			System.out.println("Generated: " + code);
		}
		while(activeGame){
			/* Prompts for the user */
			System.out.println("What is your next guess?");
			System.out.println("Type in the characters for your guess and press enter.");
			System.out.println("Enter your guess: ");
			
			/* Read the user input and store it in a class */
			Scanner guess = new Scanner(System.in);
			PlayerIn player = new PlayerIn(guess.nextLine(), code,  colors);
			
			/* If the player input is formatted correctly, compare it to the ai generated code and publish results */
			if(guess.equals("history")) {
				log.print();
			}else if(!player.isFormatCorrect()){
				System.out.println(player.showPlayerInput() + " -> INVALID GUESS");
			}else{
				if(gameBoard.checkPlayerGuess(player.showPlayerInput())){
					activeGame = false;
				}else{
					availableGuesses -= 1;
					if(availableGuesses == 0){
						activeGame = false;
						System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
					}else{ System.out.println("You have " + availableGuesses + " guesses left."); }
				}
			}
		}
	}
	

	/**
	 * Generates the code to be guessed by the player
	 * @param colorPool The  colors that can be chosen from
	 * @param len Length of the code
	 * @return Randomly generated code in String format
	 */
	public String generateCode(String colorPool, int len){
		StringBuilder temp = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i <len; i += 1){
			temp.append(colorPool.charAt(rand.nextInt(colorPool.length())));
		}
		return temp.toString();
	}
	

}
