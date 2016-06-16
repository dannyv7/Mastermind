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
	private String colors = "RYBG";
	private String code = generateCode(colors, 4);
	private boolean activeGame = true;
	private int availableGuesses = 12;
	
	public Game(){
		
	}
	
	public Game(String cl,  int guessesAllowed, int codeLen){
		colors = cl;
		availableGuesses = guessesAllowed;
		code = generateCode(colors, codeLen);
	}
	
	public  void runGame (){
		while(activeGame){
			System.out.println("Enter your guess: ");
			Scanner guess = new Scanner(System.in);
			PlayerIn player = new PlayerIn(guess.nextLine(), code,  colors);
			if(!player.isFormatCorrect()){
				System.out.println(player.showPlayerInput() + " -> INVALID GUESS");
			}else{}
		}
	}
	

	/**
	 * Generates the code to be guessed by the player
	 * @param colorPool The  colors that can be chosen from
	 * @param len Length of the code
	 * @return Randomly generated code in String format
	 */
	public static String generateCode(String colorPool, int len){
		StringBuilder temp = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i <len; i += 1){
			temp.append(colorPool.charAt(rand.nextInt(colorPool.length())));
		}
		return temp.toString();
	}
	

}
