package assignment2;

import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		boolean launch = true;
		while(launch){
			System.out.println("Are you ready to play? (Y/N) :");
			Scanner ready = new Scanner(System.in);
			String cmp = new String("Y");
			String cmp1 = ready.nextLine();
			if(cmp.equals(cmp1)){
				launch = false;
			}
		}
		Game x = new Game();
		x.runGame();

	}

}
