import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Disk implements Comparable<Disk> {

	private int radius;
	private final int DISK_HEIGHT = 30;

	public Disk(int radius) {
		this.radius = radius;
	}

	@Override
	public int compareTo(Disk disk) {
		if (this.radius > disk.radius) {
			return 1;
		}
		if (this.radius == disk.radius) {
			return 0;
		}
		return -1;
	}

	public int getRadius() {
		return radius;
	}

	public String toString() {
		return "" + radius;
	}
	
	public void drawDisk(Graphics g, int xPos, int yPos) {
		g.setColor(Color.ORANGE);
		g.fillRoundRect(xPos, yPos, 100 + radius * 20, DISK_HEIGHT, 50, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
		g.drawString("" + radius, (170 + radius * 20)/2, yPos + 20);
		g.setColor(Color.ORANGE);
	}

}
