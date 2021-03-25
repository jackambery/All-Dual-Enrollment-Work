import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class graphically creates a chess board and finds the solutions
 * to the 8 Queens problem. All configurations with 8 "peaceful" queens are
 * added to an ArrayList of solutions.
 * 
 * @author jambery
 *
 */
public class EightQueens {

	/**
	 * 2-D array of black and white ChessSquarePanels to be the 64 
	 * squares on the chess board
	 */
	private ChessSquarePanel[][] board;
	
	/**
	 * Final number of rows.
	 */
	private static final int ROWS = 8;
	
	/**
	 * Final number of columns.
	 */
	private static final int COLS = 8;
	
	/**
	 * JPanel for ChessSquarePanels to be added to.
	 */
	private JPanel boardPanel;

	/**
	 * Default constructor, sets up new JPanel of ChessSquarePanels and JFrame
	 * for the JPanel to be placed on. Adds 64 ChessSquarePanels to the JPanel with alternating
	 * colors to set up the chess board.
	 * 
	 */
	public EightQueens() {

		JFrame window = new JFrame("Chessboard");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boardPanel = new JPanel();
		boardPanel.setBackground(Color.white);
		boardPanel.setLayout(new GridLayout(ROWS, COLS));

		board = new ChessSquarePanel[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {

				if ((i + j) % 2 == 0) {
					ChessSquarePanel temp = new ChessSquarePanel(Color.white, false);
					board[i][j] = temp;
					boardPanel.add(board[i][j]);
				} else {
					ChessSquarePanel temp = new ChessSquarePanel(Color.black, false);
					board[i][j] = temp;
					boardPanel.add(board[i][j]);
				}
				board[i][j].setSize(100, 100);
			}
		}
		window.add(boardPanel);

		window.setVisible(true);
	}

	/**
	 * Checks if a queen placed at the designated spot is at risk
	 * of attack from another queen that may be in the same row, column,
	 * or diagonal. Returns true if queen can be placed, false if another queen prohibits.
	 * 
	 * @param thisRow row in which potential queen will be placed
	 * @param thisCol column in which potential queen will be placed
	 * @return true if queen can be placed, false if another queen prohibits.
	 */
	public boolean isSafe(int thisRow, int thisCol) {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				while (!(row == thisRow && col == thisCol)) { //makes sure potential spot is not counted
					//row check
					if (board[thisRow][col].hasQueen()) {
						return false;
					}

					//column check
					if (board[row][thisCol].hasQueen()) {
						return false;
					}

					//diagonal check
					if ((Math.abs(thisRow - row)) == (Math.abs(thisCol - col))) { 
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * ArrayList to hold winning/successful queen configuration positions
	 */
	private static ArrayList<ArrayList<ChessSquarePanel>> winningCombos = new ArrayList<ArrayList<ChessSquarePanel>>();
	
	/**
	 * ArrayList to hold temporary queen positions
	 */
	private static ArrayList<ChessSquarePanel> queens = new ArrayList<ChessSquarePanel>();
	
	/**
	 * Recursive method to find combinations of 8 queen positions in such way they
	 * will not be able to attack each other. Solutions are added to the winningCombos 
	 * ArrayList. Returns true if configuration successfully has 8 "peaceful" queens.
	 * 
	 * @return true if 8 queens that can not attack each other are present
	 */
	public boolean solveQueens() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (isSafe(row, col)) { //if a queen can be placed

					board[row][col].changeFlag();
					queens.add(board[row][col]);
					
					solveQueens(); //recursive call
				}
			}
		}
		
		if(queens.size() == 8) {
			winningCombos.add(queens);
			return true;
		}
		queens.clear();
		return false;
		
	}

	/**
	 * This is the main method. Creates a new Chess board and gives solutions 
	 * to 8 queens problem.
	 * 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		EightQueens c = new EightQueens();
		c.solveQueens();
		System.out.println(winningCombos);
	}

}
