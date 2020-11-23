import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
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

	private static final long serialVersionUID = -7181755070117321560L;
	private final int PANEL_WIDTH = 800;
	private final int PANEL_HEIGHT = 600;
	private static ProductionLine p;

	/**
	 * Constructs class by instantiating ProductionLine and creates the frame
	 * and panel for Graphics. Disks are also added to input here.
	 * 
	 */
	public MachineGraphics() {
		JFrame window = createFrame();
		createPanel();
		window.add(this);
		p = new ProductionLine();
//		p.addDisk(new Disk(1));
//		p.addDisk(new Disk(2));
//		p.addDisk(new Disk(3));
//		p.addDisk(new Disk(4));
//		p.addDisk(new Disk(5));
//		p.addDisk(new Disk(3));
//		p.addDisk(new Disk(5));
//		p.addDisk(new Disk(8));
		p.addRandomDisks();
		
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
	 * PaintCompnent method draws all parts of the operation. Uses rectangles
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
		g.drawString("Top of input queue", 50, yPos - 30);
		java.util.Queue<Disk> tempInput = p.getInput(); 
		while (!tempInput.isEmpty()) {
			tempInput.remove().drawDisk(g, xPos, yPos);
			yPos += 40;
		}
		
		//towers		
		p.process();
		p.printOutput();
		int xPos1 = 50;
		int yPos1 = 50;
		java.util.Queue<Tower> tempOutput = p.getOutput();
		while (!tempOutput.isEmpty()) {
			tempOutput.remove().drawTower(g, 300, 300);
			xPos1 += 50;
			yPos1 += 50;
		}
		
		// Printing texts
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
		g.drawString("Input disks:", 50, 50);
		g.setFont(new Font("Monospaced", Font.PLAIN, 14));
		g.drawString("Robot", 375, 450);
	}

	/**
	 * Main method. Asks user for a filename to derrive disks from. If 
	 * no disks are found, random ones are generated
	 * 
	 * @param args 
	 * @throws FileNotFoundException if user's file is not found
	 */
	public static void main (String[] args) throws FileNotFoundException {
		
//		System.out.println("What is the input filename?");
//		Scanner kb = new Scanner(System.in);
//		String filename = kb.nextLine();
//		
//		File inputFile = new File(filename);
//		Scanner inputScanner = new Scanner(inputFile);
//		while (inputScanner.hasNextLine()) {
//			String str = inputScanner.nextLine();
//			String[] disks = str.split("[ \\-.;:,!?]");
//			for (String s : disks) {
//				p.addDisk(new Disk(Integer.valueOf(s)));
//			}
//			//p.addAllDisks(inputScanner.nextLine());
//		}
		
		MachineGraphics window = new MachineGraphics();
		window.repaint();
		
//		inputScanner.close();
//		kb.close();
	}

}
