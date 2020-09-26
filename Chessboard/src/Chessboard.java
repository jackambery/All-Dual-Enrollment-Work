import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Jack Ambery
 *
 */
public class Chessboard extends JPanel {
	
	public Chessboard() {
		
	    JFrame window = createFrame();
	    createPanel();
	    window.add(this);
	    window.pack();
	    window.setVisible(true);
	}
	
	private JFrame createFrame() {
		
		JFrame frame = new JFrame("Chessboard");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	} 
	
	private void createPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//add(new Display());
		//add(new Keypad());
	}
	
	public static void main(String[] args) {
		Chessboard c = new Chessboard();
	}

}
