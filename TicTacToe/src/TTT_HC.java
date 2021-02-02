import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTT_HC extends Board {

	private static final long serialVersionUID = 1354215189010113831L;
	static boolean [] winners;  // True if the hash string that maps to this index is a winner, false otherwise

	/**
	 * Creates boolean array of size 3^9 which has false for all non-winner indices
	 * and true for all winners. A file of winners is taken in. 
	 * 
	 * @param s Title for Board graphic
	 */
	TicTacToeHashCode(String s) {
		super(s);
		File winnersFile = new File("TicTacToeWinners.txt");
		winners = new boolean[TicTacToe.POSSIBILITIES];
		try {
			Scanner winnersScanner = new Scanner(winnersFile);
			while(winnersScanner.hasNextLine()) {
				String line = winnersScanner.nextLine();
				
				setBoardString(line);
				winners[myHashCode()] = true;
			}
			
			winnersScanner.close(); 
		}
		catch (FileNotFoundException e) {
			System.out.println("Winners file was not found.");
		}
		
	}

	/**
	 * Produces the HashMap index for this Board. Enables the user
	 * to find their board in the HashMap with the returned integer index.
	 * 
	 * @return int the index of the specific board in a the HashMap
	 */
	@Override
	public int myHashCode() {
		String s = "";

		for (int r = 0; r < TicTacToe.ROWS; r++) {
			for (int c = 0; c < TicTacToe.COLS; c++) {
				switch(charAt(r, c)) {
				case 'x':
					s += "1";
				break;
				case 'o':
					s += "2";
				break;
				case ' ':
					s += "0";
				break;
				default:
					s += charAt(r, c);
				}
			}
		}

		//base 3 to base 10
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			index += (Character.getNumericValue(s.charAt(i)) * Math.pow(3, s.length() - (i + 1) ));
		}

		return index; //index of this board in HashMap
	}

	/**
	 * Determines if a game is a winner by checking if true in the winners array.
	 * 
	 * @return true if winner, false if not
	 */
	public boolean isWin() {
		return winners[myHashCode()];
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
		TicTacToeHashCode board = new TicTacToeHashCode ("Tic Tac Toe");

		File testFile = new File("TTT_Tests.txt");
		
		String line = "";
		try {
			
			Scanner testScanner = new Scanner(testFile);
			
			while (testScanner.hasNextLine()) {
				line = testScanner.nextLine();
				board.setBoardString(line);
				board.setHashCodeLabel(board.myHashCode());

				board.setWinner(board.isWin());

				TicTacToe ttt = new TicTacToe();
				System.out.println(ttt.isWin(line));
				Thread.sleep(4000);
				
			}
			testScanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The input file was not found.");
		}
//		for(int i = 0; i < winners.length; i++) {
//			System.out.println("" + i + winners[i]);
//		}
			
	}
}