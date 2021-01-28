import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	private static final long serialVersionUID = 1354215189010113831L;
	boolean [] winners;  // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) throws FileNotFoundException {
		super(s);
		File winnersFile = new File("TicTacToeWinners.txt");
		Scanner winnersScanner = new Scanner(winnersFile);
		while(winnersScanner.hasNextLine()) {
			int index = Integer.parseInt(winnersScanner.nextLine());
			winners[index] = true;
		}
		winnersScanner.close();
		// TODO Instantiate/fill winners array.  
	}

	// TODO - write the myHashCode function.  It must create a unique hashcode for all of the 
	//   possible values the game board (3 ^ 9) and it MUST use the super.charAt(row, col) function
	/**
	 * Produces the HashMap index for this Board. Enables the user
	 * to find their board in the HashMap with the returned integer index.
	 * 
	 * @return int the index of the specific board in a the HashMap
	 */
	@Override
	public int myHashCode() {
		String s = "";

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				switch(charAt(r, c)) {
				case 'x':
					s += "1";
				case 'o':
					s += "2";
				case ' ':
					s += "0";
				default:
					s += charAt(r, c);
				}
			}
		}
		
		//base 3 to base 10
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			index += (Character.getNumericValue(s.charAt(i)) * Math.pow(3, s.length() - (i + 1) )); //*** this may cause errors
		}
		
		return index; //index of this board in HashMap
	}
	
	public boolean isWin() {
		return winners[myHashCode()];
	}

	public boolean isWin(String s) {
		// return the value in the winner array for the hash code of the board string sent in.
		//**not a part of current assignment**
		int index = Integer.parseInt(s);
		return winners[index];
	}

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		TicTacToeHashCode board = new TicTacToeHashCode ("Tic Tac Toe");
		String s = "";
		java.util.Scanner kb = new java.util.Scanner(System.in);

		while (true) {
			s = kb.nextLine();
			board.show(String.valueOf(board.myHashCode()));
			board.setHashCodeLabel(board.myHashCode());
			
			//TODO Update this line to call your isWin method.
			board.setWinner(board.isWin());
			
			TicTacToe ttt = new TicTacToe();
			//System.out.println(ttt.isWin(s));
			board.show(s);
			Thread.sleep(4000); 
			board.displayRandomString();      
		}
	}
}