/**
 *
 */
package SudokuGenerator;

/** 
 * @author Patryk Sulewski
 *
 * This is the main class for the program!
 * Not much is happening here beside initiating
 * the game and starting the panel.
 */
public class MainFunc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuInterface i = new SudokuInterface();
		i.setVisible(true);
	}

}
