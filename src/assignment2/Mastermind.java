package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		boolean launch = true;
		File msg = new File("src/assignment2/Intro.txt");
		System.out.println(new File(".").getAbsoluteFile());
		Scanner sc;
		try {
			sc = new Scanner(msg);
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
	            System.out.println(s);
	        }
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
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
		Game x = new Game(showCode);
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
