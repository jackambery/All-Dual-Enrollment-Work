import java.awt.Color;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;

/**
 * This class sets up a tile and sets the default tile properties.
 * 
 * @author Jack Ambery
 *
 */
public class Tile extends JButton{
	
	Point location;
	private static int fontSize = 80;
	private static Font font = new Font("TimesRoman", Font.PLAIN, fontSize);
	String moving;
	
	/**
	 * Default constructor sets tile properties to blank, yellow and at 0,0.
	 */
	public Tile() {
		this ("", Color.RED, Color.YELLOW, new Point(0, 0));
	}
	
	/**
	 * This constructor allows specific properties to be set.
	 * 
	 * @param strPiece Label to determine specific piece
	 * @param back Background color
	 * @param fore Foreground color
	 * @param point Point at which tile is
	 */
	public Tile(String strPiece, Color back, Color fore, Point point) {
		
		setText(strPiece);
		setBackground(back);
		setForeground(fore);
		setFont(font);
		location = point;
	}

}
