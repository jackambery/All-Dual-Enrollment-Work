import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.*;

/**
 * MachineGraphics is the main class that runs the program. This class draws the graphics 
 * aspect, reads in the file, and sorts/prints the inputs and outputs.
 * 
 * @author Jack Ambery
 *
 */
public class MachineGraphics extends JPanel {

	private static final long serialVersionUID = 9005827282935292460L;
	private final int PANEL_WIDTH = 800;
	private final int PANEL_HEIGHT = 600;
	private static ProductionLine p;

	/**
	 * Constructs class by creating the frame and panel
	 * for Graphics.
	 * 
	 */
	public MachineGraphics() {
		JFrame window = createFrame();
		createPanel();
		window.add(this);
		
	}

	/**
	 * Creates the frame for Graphics.
	 * 
	 * @return the frame to which things will be drawn to
	 */
	private JFrame createFrame() {
		JFrame frame = new JFrame("Production Line Visual");
		frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		return frame; 
	}

	/**
	 * Creates the panel in the frame to draw to
	 * 
	 */
	private void createPanel() {
		setBackground(Color.BLACK);
	}

	/**
	 * PaintComponent method draws all parts of the operation. Uses rectangles
	 * and polygons to draw a machine. Iterates though input to draw all disks justified
	 * to the bottom of the window. Also iterates though output to print all output towers
	 * in the right area of the window. Draws strings to label items.
	 * 
	 * @param g Graphics object to draw various parts
	 */
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);

		//machine base
		g.setColor(Color.DARK_GRAY);
		g.fillRoundRect(320, 400, 150, 100, 50, 50);
		g.fillRect(380, 300, 30, 100);
		int[] xPoints1 = {320, 350, 410, 380};
		int[] yPoints1 = {200, 200, 300, 300};
		g.fillPolygon(xPoints1, yPoints1, 4);
		int[] xPoints2 = {320, 350, 270, 240};
		int[] yPoints2 = {200, 200, 300, 300};
		g.fillPolygon(xPoints2, yPoints2, 4);

		//disks
		int xPos = 50;
		int yPos = 600 - ((p.getInput().size() + 1) * 40); //40 = DISK_HEIGHT(30) + distance between disks(10)
		g.setColor(Color.WHITE);
		g.drawString("Top of input queue", xPos, yPos - 30);
		
		//When I draw disks I am somehow not allowing the creation
		//of towers. When this section is commented off, towers are
		//created but still not printed
		Queue<Disk> tempInput = p.getInput(); 
		while (!tempInput.isEmpty()) {
			tempInput.remove().drawDisk(g, xPos, yPos);
			yPos += 40;
		}
		
		//towers				
		int xPos1 = 50;
		int yPos1 = 50;	
		
		Queue<Tower> tempOutput = p.getOutput();
		while (!tempOutput.isEmpty()) {
			tempOutput.remove().drawTower(g, xPos1, yPos1);
			xPos1 += 50;
			yPos1 += 50;
		}
		
		// Printing texts
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
		g.drawString("Input disks:", 50, 50);
		g.drawString("Output towers:", 475, 50);
		g.setFont(new Font("Monospaced", Font.PLAIN, 14));
		g.drawString("Robot", 375, 450);
	}

	/**
	 * Main method. Asks user for a filename to derive disks from. If 
	 * given file is not found, 8 random disks are generated for the 
	 * user. 
	 * 
	 * @param args 
	 */
	public static void main (String[] args) {
		
		p = new ProductionLine();
		System.out.println("What is the input filename? (Leave blank for random disks)");
		Scanner kb = new Scanner(System.in);
		String filename = kb.nextLine();
		
		try {
            File inputFile = new File(filename);
            Scanner inputScanner = new Scanner(inputFile);
            
            while(inputScanner.hasNextLine()) {
                p.addDisk(new Disk(Integer.parseInt(inputScanner.nextLine())));
            }
            
        	MachineGraphics window = new MachineGraphics();
    		window.repaint();

            inputScanner.close();
        }
		catch (FileNotFoundException e) { 
			System.out.println("Your file is not found or file does not have one number per line. Random disks will be added.");
			p.addRandomDisks();
			
			MachineGraphics window = new MachineGraphics();
    		window.repaint();
		}
		
		kb.close();
	}

}
