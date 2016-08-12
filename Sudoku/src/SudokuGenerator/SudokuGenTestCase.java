package SudokuGenerator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuGenTestCase {

	SudokuGen s = new SudokuGen();
	@Test
	public void test() {
		
		s.generateValidBoard();
	}

}
