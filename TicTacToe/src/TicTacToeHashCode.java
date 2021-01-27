//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	boolean [] winners;  // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
		// TODO Instantiate/fill winners array.  
	}

	// TODO - write the myHashCode function.  It must create a unique hashcode for all of the 
	//   possible values the game board (3 ^ 9) and it MUST use the super.charAt(row, col) function
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
			index += (Character.getNumericValue(s.charAt(i)) * Math.pow(3, i));
		}
		
		return index;
	}
	
	public boolean isWin() {
		return false;
	}

	public boolean isWin(String s) {
		// return the value in the winner array for the hash code of the board string sent in.
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		TicTacToeHashCode board = new TicTacToeHashCode ("Tic Tac Toe");
		String s = "";
		java.util.Scanner kb = new java.util.Scanner(System.in);

		while (true) {
			s = kb.nextLine();
			//String currentBoard = board.boardValues[(int)(Math.random()* board.boardValues.length)];
			//board.show(currentBoard);
			//board.setHashCode(board.myHashCode());
			//TODO Update this line to call your isWin method.
			//board.setWinner(TicTacToe.isWin(currentBoard));
			TicTacToe ttt = new TicTacToe();
			System.out.println(ttt.isWin(s));
			board.show(s);
			//Thread.sleep(4000); 
			//board.displayRandomString();      
		}
	}
}