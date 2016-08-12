/**
 *
 */
package SudokuGenerator;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author Patryk Sulewski
 *
 * @SudokuInterface - UI class that extends JFrame class, in order to
 * create a graphical frame/window with the content.
 * Static integers like @MAX, @MIN, @SIZE to be able to easily expand
 * the board in the future.
 * @sudoku - SudokuGen variable that creates the board.
 * @panel - a Container variable that stores all the graphical information
 * and pushes it out to the frame.
 * @numbers - a JTextField array that will show the generated board in
 * swing interface.
 * @SudokuInterface - Constructor.
 * @configureFrame - a function that configures the frame of the window.
 * @initiateInstanceVariables - a function that initiates and configures
 * variables so they carry needed information.
 * @addComponents - a function that adds components to the frame.
 * @randomClean - a function that randomly cleans out 10 places from the
 * graphical board. That way the player can actually try to solve the
 * puzzle.
 * There is no listener or checker or solver implemented but I felt like
 * there was more important stuff to consider first, before I start out
 * with those.
 */
public class SudokuInterface extends JFrame  {

	private static int MAX = 16;
	private static int MIN = 1;
	private static int SIZE = 16;
	private SudokuGen sudoku;

	Container panel;
	JTextField [] numbers;

	public SudokuInterface() {
		configureFrame();
		initiateInstanceVariables();
		addComponents();
	}

	private void configureFrame() {
		this.setSize(210, 210); //width and height of the GUI
		this.setTitle("Sudoku");
		this.setLocationRelativeTo(null); //Reposition the GUI to the center of the
																			//screen
		this.setResizable(!true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private void initiateInstanceVariables() {
		this.sudoku = new SudokuGen();
		sudoku.generateValidBoard();
		int board [][] = sudoku.returnBoard();
		numbers = new JTextField[SIZE];

		int k=0;
		for(int j=0;j<4;j++) {
			for(int i=0; i<4 ;i++) {
				String str = Integer.toString(board[j][i]);
				numbers[k] = new JTextField(str, 5);
				k++;
			}
		}
		randomClean();
		this.panel = this.getContentPane();
		this.setLayout(new GridLayout(4,4));
	}
	private void addComponents() {
		this.panel.setLayout(new GridLayout(4, 4));
		for(int i=0;i<this.numbers.length;i++)
			this.panel.add(numbers[i]);
	}

	void randomClean() {
		int counter = 0;
		Boolean [] ok = new Boolean[SIZE];
		for(int i=0;i<SIZE;i++){
			ok[i] = false;
		}
		while(counter < 10) {
			Random randGeneratedNr = new Random();
			int pos = randGeneratedNr.nextInt((MAX-MIN)+1)+MIN;
			numbers[pos-1].setText("");
			if(!ok[pos-1]){
				counter++;
				ok[pos-1] = true;
			}

		}
	}
}
