package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		
		if(GameConfiguration.colors == null || GameConfiguration.colors.length == 0) {
			System.out.println("Invalid number of colors");
			return;
		}
		
		if(GameConfiguration.pegNumber <=0){
			System.out.println("Invalid pegNumber entry");
			return;
		}
		
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
		System.out.println("You have " + GameConfiguration.guessNumber + 
				" guesses to figure out the secret code or you lose the game. ");
	
		boolean play = true;
		boolean launch = true;
		while(play){
			while(launch){
				System.out.println("Are you ready to play? (Y/N) :");
				Scanner ready = new Scanner(System.in);
				String cmp = new String("Y");
				String cmp1 = ready.nextLine();
				if(cmp.equals(cmp1)){
					launch = false;
				}
			}
			
			Boolean showCode = true; 
			Game x = new Game(showCode);
			x.runGame();
			
			boolean poll = true; 
			while(poll){
				System.out.println("Are you ready for another game? (Y/N)");
				Scanner again = new Scanner(System.in);
				String another = again.nextLine();
				if(another.equals("N")){
					play = false; 
					poll = false; 
				} else if (another.equals("Y")) {
					play = true; 
					poll = false; 
				}
			}
		}
	}
	
	public static String arrToString(String [] x){
		String temp = new String();
		for(int i = 0; i < x.length; i += 1){
			temp += x[i];
		}
		return temp;
	}
}
