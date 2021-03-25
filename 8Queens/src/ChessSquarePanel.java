import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class to set up a single chess square for a board. A square
 * has a background color and boolean flag to indicate whether a 
 * queen occupies it or not.
 * 
 * @author jambery
 *
 */
public class ChessSquarePanel extends JPanel {

	/**
	 * Background color of tile.
	 */
	private Color color;
	
	/**
	 * Flag to indicate if queen is present on square.
	 */
	private Boolean flag; //false if no queen
	
	/**
	 * Unicode value for the queen chess piece.
	 */
	private final String QUEEN = "\u265B";
	
	/**
	 * Constructor to set up color and flag of a square.
	 * 
	 * @param c background color of square
	 * @param e true if queen present, false if there is no queen
	 */
	public ChessSquarePanel(Color c, Boolean e) {
		color = c;
		flag = e;
	}	
	
	/**
	 * Overridden method to set color and queen symbol if indicated.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setBackground(color);
		g.setColor(Color.yellow);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 100));	//100 is font size
		
		if (flag == true) {
			g.drawString(QUEEN, 11, 95); //11 and 95 were just what looked best
		}
	}
	
	/**
	 * Getter for the flag.
	 * 
	 * @return true if a queen is present , false if square is open.
	 */
	public boolean hasQueen() {
		return flag; //false is there is no queen
	}
	
	/**
	 * Switches flag to opposite boolean value. Used when queen is
	 * placed on a square.
	 */
	public void changeFlag() {
		flag = !flag;
	}
	
}
