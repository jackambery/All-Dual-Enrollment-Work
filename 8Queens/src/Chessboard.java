import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chessboard {

	private ChessSquarePanel[][] tiles;
	private static final int ROWS = 8;
	private static final int COLS = 8;
	private JPanel boardPanel;

	/**
	 * Default constructor sets up a new window and adds a Board to the window
	 * 
	 */
	public Chessboard() {

		JFrame window = new JFrame("Chessboard");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boardPanel = new JPanel();
		boardPanel.setBackground(Color.white);
		boardPanel.setLayout(new GridLayout(ROWS, COLS));

		tiles = new ChessSquarePanel[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {

				if ((i + j) % 2 == 0) {
					ChessSquarePanel temp = new ChessSquarePanel(Color.white, false);
					tiles[i][j] = temp;
					boardPanel.add(tiles[i][j]);
				} else {
					ChessSquarePanel temp = new ChessSquarePanel(Color.black, false);
					tiles[i][j] = temp;
					boardPanel.add(tiles[i][j]);
				}
				tiles[i][j].setSize(100, 100);
			}
		}
		window.add(boardPanel);

		window.setVisible(true);
	}

	/**
	 * This is the main method.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		Chessboard c = new Chessboard();

	}

}
