package assignment2;

import java.util.Vector;

public class Pegs {
	private char color;
	private Vector<Integer> positions = new  Vector<>(0);
	private int occurence = 0;
	

	

	public Pegs(char charAt, int i) {
		color = charAt;
		occurence = 1;
		positions.addElement(i);
	}

	/**
	 *  What color is the peg counter representing 
	 * @return The capital letter of the color's first letter
	 */
	public char whatColor(){
		return color;
	}
	
	/**
	 * Accessor for the positions vector
	 * @return Vector of the Pegs' positions
	 */
	public Vector<Integer> getPositions(){
		return positions;
	}
	
	/**
	 * Called to update  a peg counter
	 * Increments the occurrence counter and  updates the position array
	 * @param p
	 */
	public void updatePegs(int p){
		occurence += 1;
		positions.addElement(p);
	}
	
	/**
	 * How many times a color occurs
	 * @return Accesses and returns the occurrence rate of a color 
	 */
	public int getOccurence() {
		// TODO Auto-generated method stub
		return occurence;
	}
	
	

} 