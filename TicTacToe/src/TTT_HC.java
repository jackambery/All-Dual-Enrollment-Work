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
	TTT_HC(String s) {
		super(s);
		File winnersFile = new File("TicTacToeWinners.txt");
		winners = new boolean[2000]; //mess with this number
		try {
			Scanner winnersScanner = new Scanner(winnersFile);
			while(winnersScanner.hasNextLine()) {
				String line = winnersScanner.nextLine();
				
				//This is to be changed once hash code done
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
	 * Produces the HashMap index for this Board. Enables the user
	 * to find their board in the HashMap with the returned integer index.
	 * 
	 * @return int the index of the specific board in a the HashMap
	 */
	public int tttHashCode() {
		String s = ""; // 9 chars for each spot in given board
		int xCount = 0; //num of x's
		int oCount = 0; // num of o's
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
		// s now equals 1122 1 2 
		// check if board in invalid
		// s needs at least 3 x's or at least 3 o's
		// diff between x and o's is more than 1
		// index = 0 if these are true
		if (! (xCount > 2 || oCount > 2)) 
			index = 0;
		if (! (xCount == oCount + 1) || (oCount == xCount + 1)) 
			index = 0;
		
//		if ( (xCount < 3) && (oCount < 3) ) {
//			index = 0;
//		}
//		else if ( (xCount - oCount > 1) || (oCount - xCount > 1) ) {
//			index = 0;
//		}
		else { 
			//base 3 to base 10
			for (int i = 0; i < s.length(); i++) {
				int bigIndex = (int) (Character.getNumericValue(s.charAt(i)) * Math.pow(3, s.length() - (i + 1) ));
				index = bigIndex / 10; //should be 1 to 1900 ish
			}
		}
		
		return index; //index of this board in HashMap
	}
	
	/**
	 * Only here to correctly extend Board
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
				Thread.sleep(1000);
				
			}
			testScanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The input file was not found.");
		}
		
//		//prints winners[]
//		for(int i = 0; i < winners.length; i++) {
//			System.out.println(i + " " + winners[i]);
//		}
			
	}
}