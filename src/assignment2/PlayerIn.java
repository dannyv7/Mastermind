package assignment2;

public class PlayerIn {
	String aiCode;
	String playerGuess;
	
	/**
	 * Constructor for PlayerIn class
	 * @param input User input when prompted
	 * @param code Colors selected by the AI
	 */
	public PlayerIn(String input, String code){
		aiCode = code;
		playerGuess = input;
	}
	
	/**
	 * Checks to see if the user input is valid
	 * @return True or False depending on user input format
	 */
	public boolean isFormatCorrect(){
		if(playerGuess.length() != aiCode.length()){
			return false;
		}else{ return true; }
	}
}
