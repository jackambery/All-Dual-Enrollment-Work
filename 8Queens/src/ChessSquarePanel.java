import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel {

	private static final long serialVersionUID = -2968661381187484787L;
	private Color color;
	private Boolean flag;
	private final String QUEEN = "\u265B";
	
	public ChessSquarePanel(Color c, Boolean e) {
		color = c;
		flag = e;
	}	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setBackground(color);
		g.setColor(Color.yellow);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 100));	//100 is font size
		
		if (flag == true) {
			g.drawString(QUEEN, 11, 95); //11 and 95 were just what looked best
		}
	}
	
}
