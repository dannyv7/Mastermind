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
	private String colors = Mastermind.arrToString(GameConfiguration.colors);
	private String code = generateCode(colors, colors.length());
	private int availableGuesses = GameConfiguration.guessNumber;
	public History log = new History(); 
	private boolean activeGame = true;
	private boolean showSecret = false; 
	
	public Game(){}
	
	/**
	 * Constructor for game with user specified rules
	 * @param test display secret code for testing purposes 
	 */
	public Game(Boolean test){
		showSecret = test;
	}
	
	/**
	 * Method will being the game and run the game until it is flagged to stop 
	 */
	public  void runGame (){
		Board gameBoard = new Board(code, code.length());
		
		if (showSecret) {
			System.out.println("SECRET CODE: " + code);
		}
		
		while(activeGame){
			/* Prompts for the user */
			System.out.println("What is your next guess?");
			System.out.println("Type in the characters for your guess and press enter.");
			System.out.println("Enter your guess: ");
			
			/* Read the user input and store it in a class */
			Scanner guess = new Scanner(System.in);
			String guessStr = guess.nextLine();
			PlayerIn player = new PlayerIn(guessStr, code,  colors);
			
			/* If the player input is formatted correctly, compare it to the ai generated code and publish results */
			if(guessStr.equals("history")) {
				log.print();
			}else if(!player.isFormatCorrect()){
				System.out.println(player.showPlayerInput() + " -> INVALID GUESS");
			}else{
				log.updateGuesses(guessStr);
				if(gameBoard.checkPlayerGuess(player.showPlayerInput(), log)){
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
		System.out.println("Generating secret code ....");
		StringBuilder temp = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i <len; i += 1){
			temp.append(colorPool.charAt(rand.nextInt(colorPool.length())));
		}
		return temp.toString();
	}
	

}
