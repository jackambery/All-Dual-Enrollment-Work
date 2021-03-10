import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	private ChessSquarePanel[][] tiles;
	
	public Board (int rows, int cols) {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(rows, cols));
		tiles = new ChessSquarePanel[rows][cols];
		for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            tiles[i][j] = new ChessSquarePanel(); //creates 64 JButtons
	            //tiles[i][j].setSize(100, 100);
	            
	            //colors specific JButton
	            if ((i + j) % 2 == 0) {
	                tiles[i][j].setBackground(Color.BLACK);
	            } else {
	                tiles[i][j].setBackground(Color.WHITE);
	            }
	            add(tiles[i][j]);
	        }
		}
	}
	
	/**
	 * Default constructor sets up 8 rows and 8 columns
	 * 
	 */	
	public Board() {
		this (8, 8);
	}
	
	/**
	 * This method adds pieces to each specific JButton in tiles[][]
	 * 
	 */
	public void addPieces() {
		
		//adds pawns
		
		}
	}
}
