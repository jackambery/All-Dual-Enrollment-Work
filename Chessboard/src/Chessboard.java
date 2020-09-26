import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Jack Ambery
 *
 */
public class Chessboard extends JPanel {
	
	//Constants
	private final static String WHITE_PAWN = "\u2659 ";
	private final static String WHITE_KING = "\u2654 ";
	private final static String WHITE_QUEEN = "\u2655 ";
	private final static String WHITE_BISHOP = "\u2657 ";
	private final static String WHITE_KNIGHT = "\u2658 ";
	private final static String WHITE_ROOK = "\u2656 ";
	
	private final static String BLACK_PAWN = "\u265F ";
	private final static String BLACK_KING = "\u265A ";
	private final static String BLACK_QUEEN = "\u265B ";
	private final static String BLACK_BISHOP = "\u265D ";
	private final static String BLACK_KNIGHT = "\u265E ";
	private final static String BLACK_ROOK = "\u265C ";

	
	JPanel squares[][] = new JPanel[8][8];
	JButton pieces[][] = new JButton[8][8];

		
	public Chessboard() {
		
	    JFrame window = new JFrame("Chessboard");
	    window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	    createBoard();
	    addPieces();
	    window.add(this);
	    //window.pack();
	    window.setVisible(true);
	}
	
	private void createBoard() {
		setLayout(new GridLayout(8, 8));
		
		for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            squares[i][j] = new JPanel(); //creates 64 JPanels
	            squares[i][j].setSize(100, 100);
	            
	            //colors specific JPanel
	            if ((i + j) % 2 == 0) {
	                squares[i][j].setBackground(Color.BLACK);
	            } else {
	                squares[i][j].setBackground(Color.WHITE);
	            }   
	            
	            //adds specific JPanel
	            add(squares[i][j]);
	        }
		}
	}
	
	/*
	public void addPieces() {
		setLayout(new GridLayout(8, 8));
		
		for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            pieces[i][j] = new JButton("test");
	            pieces[i][j].setSize(75, 75);
	            pieces[i][j].setText(BLACK_BISHOP);
	            pieces[i][j].setVisible(true);
	            add(pieces[i][j]);
	        }
		}
	}
	*/
	
	
	public static void main(String[] args) {
		new Chessboard();
	}

}
