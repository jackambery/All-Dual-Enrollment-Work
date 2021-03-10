import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel {

	private static final long serialVersionUID = -2968661381187484787L;
	private Color color;
	private Boolean empty;
	private final String QUEEN = "\u265B";
	
	public ChessSquarePanel(Color c, Boolean e) {
		color = c;
		empty = e;
		
		if (empty == false) {
			setText(QUEEN);
		}
	}	
	
}
