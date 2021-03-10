import javax.swing.JFrame;

public class Chessboard {
	Board board;

	/**
	 * Default constructor sets up a new window and adds a Board to the window
	 * 
	 */
	public Chessboard() {

		JFrame window = new JFrame("Chessboard");
		setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		board = new Board();
		add(board);

		setTitle("Game Board");
		pack();
		setVisible(true);
	}

	/**
	 * This is the main method.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		Chessboard c = new Chessboard();
		c.board.addPieces();
		c.pack();
	}

}
