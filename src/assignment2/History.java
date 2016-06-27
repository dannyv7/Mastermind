package assignment2;

public class History {
	private int[] blackPegs = new int[GameConfiguration.guessNumber]; 
	private int[] whitePegs = new int[GameConfiguration.guessNumber];
	private String[] guesses = new String[GameConfiguration.guessNumber];
	private int numRounds = 0;
	
	public void updateRounds() {
		numRounds++;
	}
	
	public void updateBlacks(int num) {
		blackPegs[numRounds] = num;
	}
	
	public void updateWhites(int num) {
		whitePegs[numRounds] = num;
	}
	
	public void updateGuesses(String guess) {
		guesses[numRounds] = guess; 
	}
	
	public void print() {
		if(numRounds == 0) {
			System.out.println("No rounds yet");
		}
		
		for (int i = 0; i < numRounds; i++) {
			System.out.println("ROUND \tGUESS \t\tBLACK PEGS \t\tWHITE PEGS");
			System.out.println((i + 1) + " \t" + guesses[i] + " \t\t" + blackPegs[i] + " \t\t" + whitePegs[i]);
		}
		return;
	}
	
}
