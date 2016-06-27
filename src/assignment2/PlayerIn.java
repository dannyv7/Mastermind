package assignment2;

public class PlayerIn {
	String aiCode;
	String playerGuess;
	String colorPool;
	
	/**
	 * Constructor for PlayerIn class
	 * @param input User input when prompted
	 * @param code Colors selected by the AI
	 */
	public PlayerIn(String input, String code, String pool){
		aiCode = code;
		playerGuess = input;
		colorPool = pool;
	}
	
	/**
	 * Reveals the player input String
	 * @return
	 */
	public String showPlayerInput(){
		return playerGuess;
	}
	
	/**
	 * Checks to see if the user input is valid
	 * @return True or False depending on user input format
	 */
	public boolean isFormatCorrect(){
		/* Mismatched string sizes clearly indicate extra/fewer than required input */
		if(playerGuess.length() != aiCode.length()){
			return false;
		}
		
		/* Check for any characters in the input that do not appear in the color pool */
		for(int i = 0; i < playerGuess.length(); i += 1){
			if(colorPool.indexOf(playerGuess.charAt(i)) == -1){
				return false;
			}
		}
		
		/* Format should be correct upon reaching this point */
		return true;
	}
}
