import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class TestFrame extends JPanel {
	
	private final int PANEL_WIDTH = 800;
	private final int PANEL_HEIGHT = 800;
	
	public TestFrame() {
		JFrame window = createFrame();
	      createPanel();
	      window.add(this);  // Because the class extends JPanel, this is a JPanel ... so, what is being added to the frame is the jpanel
	      window.setVisible(true);

	}

	private JFrame createFrame() {
	      JFrame frame = new JFrame("Production Line Visual");
	      frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	      frame.setResizable(true);
	      //frame.setIconImage(new Image(""));
	      return frame; 
	}
	
	private void createPanel() {
	      setBackground(Color.BLACK);
	}
	
//	@Override
//	public void paintComponent(Graphics g) { // This method is what is redrawn whenever Java decides it is required.  
//	                                         // For us, we use the super classes paintComponent to ensure that is 
//	                                         // all taken care of, then we print each shape in the list.  There is a 
//	                                         // temporary debug print statement in the loop right now.
//	      super.paintComponent(g);
//	}
	
	public void drawMachine(Graphics g) {
		
		g.setColor(Color.YELLOW);    // set the drawing color
        g.drawLine(30, 40, 100, 200);
        g.drawOval(150, 180, 10, 10);
        g.drawRect(200, 210, 20, 30);
        g.setColor(Color.RED);       // change the drawing color
        g.fillOval(300, 310, 30, 50);
        g.fillRect(400, 350, 60, 50);
        // Printing texts
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g.drawString("Testing custom drawing ...", 10, 20);
		
	}
	
	public static void main (String[] args) {
		TestFrame window = new TestFrame();
		window.repaint();
	       
	    ProductionLine p = new ProductionLine();
	    p.addDisk(new Disk(8));
	    p.addDisk(new Disk(7));
	    p.addDisk(new Disk(5));
	    p.addDisk(new Disk(3));
	    p.addDisk(new Disk(1));
	    p.process();
	    
	    p.printOutput();
	}

}
