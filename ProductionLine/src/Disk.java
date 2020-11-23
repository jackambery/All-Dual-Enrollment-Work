import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Creates the Disk object. A disk has a radius and is comparable to
 * other disks.
 * 
 * @author Jack Ambery
 *
 */
public class Disk implements Comparable<Disk> {

	private int radius;
	private final int DISK_HEIGHT = 30;

	/**
	 * Constructs a new disk with a specified radius
	 * 
	 * @param radius integer size of disk's radius
	 */
	public Disk(int radius) {
		this.radius = radius;
	}

	/**
	 * Compares the radiuses this.disk and other
	 * 
	 * @param Disk to be compared to
	 * @return 1 if this.disk is bigger than other, -1 if smaller, and 0 if equal
	 */
	@Override
	public int compareTo(Disk other) {
		if (this.radius > other.radius) {
			return 1;
		}
		if (this.radius == other.radius) {
			return 0;
		}
		return -1;
	}

	/**
	 * Allows the access of radius to disks created in other classes
	 * 
	 * @return integer which represents the size of the Disk
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Returns the String representation of a disk which is just the radius of that disk
	 * 
	 * @return the integer radius size of a disk in String format 
	 */
	public String toString() {
		return "" + radius;
	}
	
	/**
	 * Draws a disk. A disk is an orange round rectangle with a proportionally
	 * sized width and a fixed height. A disk also has its radius written in its
	 * center in white.
	 * 
	 * @param g Graphics object to draw disk parts
	 * @param xPos x-coordinate of Disk's location
	 * @param yPos y-coordinate of disk's location
	 */
	public void drawDisk(Graphics g, int xPos, int yPos) {
		g.setColor(Color.ORANGE);
		g.fillRoundRect(xPos, yPos, 100 + radius * 20, DISK_HEIGHT, 50, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
		g.drawString("" + radius, (170 + radius * 20)/2, yPos + 20);
		g.setColor(Color.ORANGE);
	}

}
