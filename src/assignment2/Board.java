package assignment2;

import java.util.Vector;

public class Board {
	private Vector <Pegs> aiPegs = new Vector<Pegs>(0);
	private Vector <Pegs> playerPegs = new Vector<Pegs>(0);
	private int codeLen;
	
	/**
	 * Constructor for the initial board
	 * @param aiCode The String of colors selected randomly
	 */
	public Board(String aiCode, int len){
		for(int i = 0; i < aiCode.length(); i += 1){
			int pegLocation = idxPegInVector(aiCode.charAt(i), aiPegs);
			if( pegLocation != -1){
				aiPegs.elementAt(pegLocation).updatePegs(i);
			}else{
				Pegs temp = new Pegs(aiCode.charAt(i), i);
				aiPegs.addElement(temp);
			}
		}
		codeLen = len;
	}
	
	
	/**
	 * Compares the player guess with the actual generated code
	 * @param userln The player guess as a String
	 * @return True if the player guesses exactly right, false otherwise
	 */
	public boolean checkPlayerGuess(String userIn){
		updateUserInput(userIn);
		int blackPegs = 0;
		int whitePegs = 0;
		for(int i = 0; i < playerPegs.size(); i += 1){
			int aiLocation = idxPegInVector(playerPegs.elementAt(i).whatColor(), aiPegs);
			if(aiLocation != -1){
				
				/* White pegs indicate a correctly guessed color, so should be the amount of times the user entered the current color (obviously does not exceed actual) */
				int tempWhite = playerPegs.elementAt(i).getOccurence();
				if(tempWhite > aiPegs.elementAt(aiLocation).getOccurence()){
					tempWhite =  aiPegs.elementAt(aiLocation).getOccurence();
				}
				
				/* Now we will check for colors in the correct position, which are represented with a black peg  */
				int tempBlack = 0;
				for(int k = 0; k < playerPegs.elementAt(i).getPositions().size(); k += 1){
					if(aiPegs.elementAt(aiLocation).getPositions().indexOf(playerPegs.elementAt(i).getPositions().elementAt(k)) != -1){
						tempBlack += 1;
					}
				}
				
				/* Recount the overall amount of black and white pegs */
				whitePegs += (tempWhite - tempBlack);
				blackPegs += tempBlack;
			}
		}
		Game.log.updateWhites(whitePegs);
		Game.log.updateBlacks(blackPegs);
		
		/* Return true if the user has matched the pegs exactly, else false */
		if(blackPegs == codeLen){
			System.out.println(userIn + " -> Result: " + blackPegs + " black peg(s) - You win!!");
			return true;
		}else if(whitePegs > 0 || blackPegs > 0){
			System.out.println(userIn + " -> Result: " + blackPegs + " black peg(s) and " + whitePegs + " white peg(s)");
			return false; 
		}
		
		/* This point is reached when the user sucks and guesses completely wrong */
		System.out.println(userIn + "-> Result: No pegs");
		return false;
	}
	
	/**
	 * Updates the user input tracker on the board
	 * @param userIn
	 */
	private void updateUserInput(String userIn){
		playerPegs = new Vector<Pegs> (0);
		for(int i = 0; i < userIn.length(); i += 1){
			int pegLocation = idxPegInVector(userIn.charAt(i), playerPegs);
			if(pegLocation != -1){
				playerPegs.elementAt(pegLocation).updatePegs(i);
			}else{
				Pegs temp = new Pegs(userIn.charAt(i), i);
				playerPegs.addElement(temp);
			}
		}
		
	}
	/**
	 * Returns the index of a color peg in a vector
	 * @param ch Color which you are searching for
	 * @param v Vector you are searching in
	 * @return Index of the color peg, -1 if does not exist
	 */
	public static int  idxPegInVector(char ch, Vector <Pegs> v){
		for(int i = 0; i < v.size();  i += 1){
			if(v.elementAt(i).whatColor() == ch){
				return i;
			}
		}
		return -1;
	}

}
