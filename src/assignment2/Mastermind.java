package assignment2;

import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		boolean launch = true;
		while(launch){
			System.out.print("You have " + GameConfiguration.guessNumber + 
					" guesses to figure out the secret code or you lose the game. ");
			System.out.println("Are you ready to play? (Y/N) :");
			Scanner ready = new Scanner(System.in);
			String cmp = new String("Y");
			String cmp1 = ready.nextLine();
			if(cmp.equals(cmp1)){
				launch = false;
			}
		}
		//Game x = new Game();
		Boolean showCode = true; 
		Game x = new Game(showCode, arrToString(GameConfiguration.colors), GameConfiguration.guessNumber, GameConfiguration.pegNumber);
		x.runGame();

	}
	

	public static String arrToString(String [] x){
		String temp = new String();
		for(int i = 0; i < x.length; i += 1){
			temp += x[i];
		}
		return temp;
	}
}
