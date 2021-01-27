/**
 * This class is a TicTacToe Board. It will fill random boards, check for certain types
 * of wins, and checks if a board is valid.
 * 
 * @author Jack Ambery
 *
 */
public class TicTacToe {
	public final static int ROWS = 3;
	public final static int COLS = 3;
	public final static int POSSIBILITIES = (int) Math.pow(3,9);
	public final static int CHAR_POSSIBILITIES = 3; // x, o or space

	/**
	 * Checks how many times a specified character appears in a 2-d
	 * array.
	 * 
	 * @param b array/board to be examined
	 * @param ch character which is being searched for
	 * @return number of times ch appears in b
	 */
	private static int numChars(char[][] b, char ch) {
		int total = 0;
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < COLS; c++)
				if (ch == b[r][c]) 
					total++;
		return total;
	}

	/**
	 * Determines if a given board is possible in a normal game of tic-tac-toe.
	 * 
	 * @param board board to be checked
	 * @return true if board is valid, false if board is not possible
	 */
	public static boolean valid(char[][] board) {

		// Ensure there are at least 3 xs and 2 os, or 3 os and 2 xs
		// Make sure there are at least one more x or one more o
		int numX = numChars(board, 'x');
		int numO = numChars(board, 'o');
		if (! (numX > 2 || numO > 2)) 
			return false;
		if ((numX == numO + 1) || (numO == numX + 1)) 
			return true;
		return false;
	}

	/**
	 * Takes a board and converts it to a String representation.
	 * 
	 * @param b board to be converted
	 * @return String representation of b
	 */
	public static String boardToString(char[][] b) {
		String result = "";
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) 
				result += b[r][c];
			//     result += "\n";
		}
		return result;
	}

	/**
	 * Takes a string and sets each character in that string to a spot in 2-d
	 * board array.
	 * 
	 * @param board String representation of a board
	 * @return filled in tic-tac-toe board 2-d array
	 */
	public static char[][] stringToBoard(String board) {
		char[][] b = new char[ROWS][COLS];
		int index = 0;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) 
				b[r][c] = whichLetter(board.charAt(index++));
		}
		return b;
	}


	/**
	 * Determines whether the given integer character represents 'x', 'o', or ' '. 
	 * 
	 * @param ch Character being converted
	 * @return 'x', 'o', or ' ' based on if ch is '1', '2', or '0'
	 */
	public static char whichLetter(char ch) {
		switch (ch) {
		case '1' : 
			return 'x';
		case '2' : 
			return 'o';
		case '0'  : 
			return ' ';
		default: 
			return ch;
		}
	}

	/**
	 * Takes in a string of 0, 1, and 2s and creates a board of 
	 * x, o, and spaces.
	 * 
	 * @param s String of 0, 1, and 2s
	 * @return a filled in tic-tac-toe board of x, o, and spaces
	 */
	public static char[][] makeBoard(String s) {
		char[][] b = new char[ROWS][COLS];
		int ch = 0;
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < COLS; c++){         
				b[r][c] = whichLetter(s.charAt(ch));
				ch++;
			}
		return b;
	}

	/**
	 * Takes a base 3 number in the form of a string and adds 1 to it.
	 * 
	 * @param s the string representation of a base 3 number
	 * @return a new string, one higher than s
	 */
	private static String addOne(String s) {
		// s is a 9 character string, composed of 0s, 1s, and 2s.  Add 1 to the last char, adjusting
		// all the rest of the characters as necessary.
		boolean carry = false;
		char ch[] = s.toCharArray();
		ch[ch.length-1] =  (char)((int)(ch[ch.length-1])+1);
		for (int n = ch.length-1; n >=0; n--) {
			if (carry) ch[n] = (char)((int)(ch[n])+1);
			if (ch[n] == '3') {
				carry = true;
				ch[n] = '0';
			}
			else
				carry = false;      
		}
		return new String(ch);
	}

	/**
	 * Fills an array of every possible tic-tac-toe board possibility, represented
	 * by strings of numbers
	 * 
	 * @return a very large array of board possibilities
	 */
	public static String[] fillValues() {
		String strBoard = "000000000";
		String[] values = new String[POSSIBILITIES];
		int index = 0;
		values[index++] = strBoard;
		while (!strBoard.equals("222222222") ) {
			strBoard = addOne(strBoard);
			values[index++] = strBoard;
		}
		return values;
	}

	/**
	 * Checks if a board has a win in the diagonal direction.
	 * 
	 * @param board board being checked
	 * @return true if win is found, false if no win is found
	 */
	public static boolean diagonalWin(char[][] board) {
		int wins = 0;
		if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') || 
				(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')) 
			wins++;


		if ((board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') ||
				(board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')) 
			wins++;

		return wins == 1;
	}

	/**
	 * Checks if a board has a win in the horizontal direction.
	 * 
	 * @param board board being checked
	 * @return true if win is found, false if no win is found
	 */
	public static boolean rowWin(char[][] board) {
		char ch;
		int wins = 0;
		boolean win = true;
		for (int r = 0; r < ROWS; r++) {
			win = true;
			ch = board[r][0];
			for (int c = 0; c < COLS; c++) 
				if (ch != board[r][c]) {
					win = false;
					break;
				}
			if (win && ch != ' ')
				wins++;
		} 
		return wins == 1;
	} 
	
	/**
	 * Checks if a board has a win in the verical direction.
	 * 
	 * @param board board being checked
	 * @return true if win is found, false if no win is found
	 */
	public static boolean colWin(char[][] board) {
		char ch;
		int wins = 0;
		boolean win = true;
		for (int c = 0; c < COLS; c++) {
			win = true;
			ch = board[0][c];
			for (int r = 0; r < ROWS; r++) 
				if (ch != board[r][c]) {
					win = false;
					break;
				}
			if (win && ch != ' ') 
				wins++;
		} 
		return wins == 1;
	} 

	/**
	 * Checks how many total wins are on a tic-tac-toe board.
	 * 
	 * @param b board being checked
	 * @return number of wins found on b
	 */
	public static boolean isWin(char[][]b) {
		int wins = 0;
		if (valid(b)) {
			if (rowWin(b)) wins++;
			if (colWin(b)) wins++;
			if (diagonalWin(b)) wins++;
		}
		return wins == 1;
		//     return valid(b) && (rowWin(b) ^ colWin(b) ^ diagonalWin(b));
	}

	/**
	 * Checks if a board has any wins and tells user what those wins are.
	 * 
	 * @param b board to be checked
	 * @return String indicating what kind of win if any, or "loser" if no win found
	 */
	public static String isWinString(char[][]b) {
		boolean v = valid(b);
		if (v) {
			boolean r = rowWin(b);
			boolean c = colWin(b);
			boolean d = diagonalWin(b);
			int wins = 0;
			if (r) wins++;
			if (c) wins++;
			if (d) wins++;
			if (wins == 1) {
				if (r) 
					return "Row";
				if (c) 
					return "Col";
				if (d) 
					return "Dia";
				return "winner";

			}
		}   
		return "loser";
	}

	/**
	 * Creates a new board with a String s, and checks for any wins in that
	 * board
	 * 
	 * @param s String to be checked
	 * @return true if string can be made into valid table, false if not
	 */
	public static boolean isWin(String s) {
		char[][] b = stringToBoard(s);
		return isWin(b);
	}

	/**
	 * Takes a string, turns the string to a tic-tac-toe board, then tells 
	 * user how many wins and what kind of wins are on the board.
	 * 
	 * @param s initial String to be made into table.
	 * @return String determining what kind of wins s has
	 */
	public static String isWinString(String s) {
		char[][] b = stringToBoard(s);
		return isWinString(b);
	}

	/**
	 * This is the main method.
	 * 
	 * @param args String array args
	 */
	public static void main(String[] args) {
		String s = "ooooxxxox";
		char[][] b = stringToBoard(s);
		System.out.println("Valid:   " + valid(b));
		System.out.println("Row Win: " + rowWin(b));
		System.out.println("Col Win: " + colWin(b));
		System.out.println("Dia Win: " + diagonalWin(b));
		System.out.println(isWin(b));

	}    
}
