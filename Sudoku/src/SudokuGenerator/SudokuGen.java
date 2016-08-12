/**
 * Imports Random to generate random numbers into the board.
 */
package SudokuGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Patryk Sulewski 
 *
 * The main class where we are generating the 4x4
 * sudoku board. The main idea was to generate a
 * random board every time we start the program.
 * @theBoard - Sudoku board.
 * @checkList - A boolean check list for the columns
 * to make sure we aren't using the same values.
 * @SudokuGen - Constructor where we initiate the variables.
 * @generateValidBoard - function where we are generating
 * the main board. Due to little time I couldn't get it
 * completely right. It may sometime freeze on the while
 * loops due to wrongly generated numbers. Would definetly
 * like to work more on this function.
 * @printSolution - prints the generated solution to make
 * sure than they follow the rules of sudoku.
 * @returnBoard - returns the board in form of 2D integer
 * array for further use in the SudokuInterface class.
 */
public class SudokuGen {

	public static final int MAX=4;
	public static final int MIN=1;
	private int [][] theBoard;
	private Boolean [] checkList;

	public SudokuGen() {
		super();
		this.theBoard = new int [MAX][MAX];
		this.checkList = new Boolean[MAX];
		for(int i=0;i<MAX;i++) {
			this.checkList[i] = false;
		}

	}
	void generateValidBoard() {
		Boolean ok = false;
		Random randGeneratedNr = new Random();
		int i =0 , j = 0;
		int nr = 0;
		while(!ok) {
			Boolean rowChecker = false;
			Boolean squreChecker = false;
			nr = randGeneratedNr.nextInt((MAX-MIN)+1)+MIN;

			while(!rowChecker || this.checkList[nr-1] || !squreChecker) {
				nr = randGeneratedNr.nextInt((MAX-MIN)+1)+MIN;
				rowChecker = true;
				squreChecker = true;
				for(int k = i; k >= 0; k--) {
					if (nr == this.theBoard[k][j])
						rowChecker = false;
				}
				if(i<2 && j<2) {
					for (int k=0; k<2; k++) {
						for(int l=0; l<2;l++) {
							if(nr == this.theBoard[k][l])
								squreChecker = false;
						}
					}
				}
			}
			this.checkList[nr-1] = true;
			this.theBoard[i][j] = nr;
			j++;
			if(j == MAX) {
				i++;
				j=0;
				for(int k=0;k<MAX;k++) {
					this.checkList[k] = false;
				}
			}
			if(i == MAX) {
				ok = true;
			}
		}
		printSolution();
	}
	void printSolution() {
		for(int k=0; k < MAX; k++) {
			for(int j=0;j < MAX;j++)
				System.out.print(this.theBoard[k][j] + " ");
			System.out.println();
		}
	}
	int [][] returnBoard() {
		return this.theBoard;
	}

}
