import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class creates a boolean hash array for every possible tic-tac-toe board combination.
 * Boards with winning combinations are true, the rest are false. Extends the Board class, mainly
 * responsible for the Graphics aspects.
 * 
 * @author Jack Ambery
 *
 */
public class TTT_HC extends Board {

	private static final long serialVersionUID = 1354215189010113831L;
	static boolean [] winners;

	/**
	 * Creates boolean array of size 1968 (3^9 / 10) which has false for all non-winner and invalid boards
	 * and true for all winners. A file of winners is taken in. 
	 * 
	 * @param s Title for Board graphic
	 */
	TTT_HC(String s) {
		super(s);
		File winnersFile = new File("TicTacToeWinners.txt");
		winners = new boolean[TicTacToe.POSSIBILITIES / 10];
		try {
			Scanner winnersScanner = new Scanner(winnersFile);
			while(winnersScanner.hasNextLine()) {
				String line = winnersScanner.nextLine();

				//Sets all the winners to true in winners[]
				setBoardString(line);
				winners[tttHashCode()] = true;
			}

			winnersScanner.close(); 
		}
		catch (FileNotFoundException e) {
			System.out.println("Winners file was not found.");
		}

	}

	/**
	 * Produces a position in an array of booleans for this Board. Enables the user
	 * to determine whether their board is a winner or not.
	 * 
	 * How the Hash Function works:
	 * If a board is invalid, the position is set to 0. If a board is valid, the base-3 
	 * representation of the board is converted to base-10 then that number is divided by 10. 
	 * This cuts down the extra space in the previous, size 19,000 array. 
	 * 
	 * @return integer index/position of the board configuration in the array
	 */
	public int tttHashCode() {
		String s = ""; // 9 chars for each spot in given board
		int xCount = 0; // number of x's
		int oCount = 0; // number of o's
		int index = 0; // spot in array

		for (int r = 0; r < TicTacToe.ROWS; r++) {
			for (int c = 0; c < TicTacToe.COLS; c++) {
				switch(charAt(r, c)) {
				case 'x':
					s += "1";
					xCount++;
					break;
				case 'o':
					s += "2";
					oCount++;
					break;
				case ' ':
					s += "0";
					break;
				default:
					s += charAt(r, c);
				}
			}
		}
 
		// check if board in invalid
		if (! (xCount > 2 || oCount > 2))
			return 0;
		if (! ((xCount == oCount + 1) || (oCount == xCount + 1)))
			return 0;
		
		//base 3 to base 10
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				index += ( Character.getNumericValue(s.charAt(i)) * Math.pow(3, s.length() - (i + 1)) );
			}
		}
		
		return index / 10; //index of this board in the array
	}

	/**
	 * (Only here to correctly extend Board) References tttHashCode method to determine position.
	 * 
	 * @return integer position in winners array
	 */
	@Override
	public int myHashCode() {
		return tttHashCode();
	}

	/**
	 * Determines if a game is a winner by checking if true in the winners array.
	 * 
	 * @return true if winner, false if not
	 */
	public boolean isWin() {
		return winners[tttHashCode()];
	}

	/**
	 * Determines if a given x and o combination string is a winner.
	 * 
	 * @param s String of x's, o's and spaces
	 * @return
	 */
	public boolean isWin(String s) {
		// return the value in the winner array for the hash code of the board string sent in.
		//**not a part of current assignment**
		int index = Integer.parseInt(s);
		return winners[index];
	}

	/**
	 * Main method, updates display every 4 seconds for each line in test file.
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		TTT_HC board = new TTT_HC ("Tic Tac Toe with new hash function");

		File testFile = new File("TTT_Tests.txt");

		String line = "";
		try {

			Scanner testScanner = new Scanner(testFile);

			while (testScanner.hasNextLine()) {
				line = testScanner.nextLine();
				board.setBoardString(line);
				board.setHashCodeLabel(board.tttHashCode());

				board.setWinner(board.isWin());

				System.out.println(board.isWin());
				Thread.sleep(200);

			}
			testScanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The input file was not found.");
		}

		//prints winners[]
		double trueCount = 0;
		for(int i = 0; i < winners.length; i++) {
			if (winners[i] == true) {
				trueCount++;
			}
		}
		double loadfactor = trueCount / (TicTacToe.POSSIBILITIES / 10);
		System.out.println("Load factor = " + trueCount + " / 1968 = " + loadfactor);
		
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int q4 = 0;
		for(int i = 0; i < winners.length / 4; i++) {
			if (winners[i] == true) {
				q1++;
			}
		}for(int i = winners.length / 4; i < winners.length / 2; i++) {
			if (winners[i] == true) {
				q2++;
			}
		}for(int i = winners.length / 2; i < winners.length - (winners.length / 4); i++) {
			if (winners[i] == true) {
				q3++;
			}
		}for(int i = winners.length - (winners.length / 4); i < winners.length; i++) {
			if (winners[i] == true) {
				q4++;
			}
		}
		System.out.println("Distribution in each quarter: " + q1 + ", " + q2 + ", " + q3 + ", " + q4);

	}
}