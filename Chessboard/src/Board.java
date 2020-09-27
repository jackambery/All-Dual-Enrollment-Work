import java.awt.Color;

import java.awt.GridLayout;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class constructs the board and places the pieces.
 * 
 * @author Jack Ambery
 *
 */
public class Board extends JPanel implements DragGestureListener, DropTargetListener {
	
	private DragSource mouse = DragSource.getDefaultDragSource();
	private Tile[][] tiles;
	private JButton pieces[][];
	
	//Pieces
	private final static String WHITE_PAWN = "\u2659";
	private final static String WHITE_KING = "\u2654";
	private final static String WHITE_QUEEN = "\u2655";
	private final static String WHITE_BISHOP = "\u2657";
	private final static String WHITE_KNIGHT = "\u2658";
	private final static String WHITE_ROOK = "\u2656";
	
	private final static String BLACK_PAWN = "\u265F";
	private final static String BLACK_KING = "\u265A";
	private final static String BLACK_QUEEN = "\u265B";
	private final static String BLACK_BISHOP = "\u265D";
	private final static String BLACK_KNIGHT = "\u265E";
	private final static String BLACK_ROOK = "\u265C";

	/**
	 * This constructor sets up a board of Tiles
	 * 
	 * @param rows Number of Rows in board
	 * @param cols Number of columns in board
	 */
	public Board (int rows, int cols) {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(rows, cols));
		tiles = new Tile[rows][cols];
		for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            tiles[i][j] = new Tile(); //creates 64 JButtons
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
		for (int i = 0; i < 8; i++) {
			tiles[1][i].setText(BLACK_PAWN);
			tiles[6][i].setText(WHITE_PAWN);
		}
		
		//adds specific pieces
        tiles[0][0].setText(BLACK_ROOK);
        tiles[0][1].setText(BLACK_KNIGHT);
        tiles[0][2].setText(BLACK_BISHOP);
        tiles[0][3].setText(BLACK_QUEEN);
        tiles[0][4].setText(BLACK_KING);
        tiles[0][5].setText(BLACK_BISHOP);
        tiles[0][6].setText(BLACK_KNIGHT);
        tiles[0][7].setText(BLACK_ROOK);

        tiles[7][0].setText(WHITE_ROOK);
        tiles[7][1].setText(WHITE_KNIGHT);
        tiles[7][2].setText(WHITE_BISHOP);
        tiles[7][3].setText(WHITE_KING);
        tiles[7][4].setText(WHITE_QUEEN);
        tiles[7][5].setText(WHITE_BISHOP);
        tiles[7][6].setText(WHITE_KNIGHT);
        tiles[7][7].setText(WHITE_ROOK);

	}
	
	/**
	 * Have not used these methods yet
	 * 
	 */

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}