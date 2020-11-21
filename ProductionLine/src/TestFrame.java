import java.awt.*;
import javax.swing.*;

public class TestFrame extends JPanel {

	private static final long serialVersionUID = -7181755070117321560L;
	private final int PANEL_WIDTH = 800;
	private final int PANEL_HEIGHT = 600;

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
		return frame; 
	}

	private void createPanel() {
		setBackground(Color.BLACK);
	}

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
		g.setColor(Color.ORANGE);
		g.fillOval(200, 400, 60, 30);
		//g.drawString(p.getInput().peek().toString(), 375, 450);

		// Printing texts
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.PLAIN, 14));
		g.drawString("Input disks:", 50, 200);
		g.drawString("Robot", 375, 450);
	}

	public static void main (String[] args) {
		TestFrame window = new TestFrame();
		window.repaint();

		ProductionLine p = new ProductionLine();
		p.addDisk(new Disk(1));
		p.addDisk(new Disk(2));
		p.addDisk(new Disk(3));
		p.addDisk(new Disk(4));
		p.addDisk(new Disk(5));
		p.addDisk(new Disk(111));
		p.addDisk(new Disk(3));
		p.addDisk(new Disk(5));
		p.addDisk(new Disk(33));
		p.addDisk(new Disk(5));
		p.process();

		p.printOutput();
	}

}
