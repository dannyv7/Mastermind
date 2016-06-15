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
	private static String colors = "RYBG";
	private static String code = generateCode(colors, 4);
	private static boolean activeGame = true;
	
	public static void main(String args[]){
		while(activeGame){
			System.out.println("Enter your guess: ");
			Scanner guess = new Scanner(System.in);
			PlayerIn temp = new PlayerIn(guess.nextLine(), code);
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
