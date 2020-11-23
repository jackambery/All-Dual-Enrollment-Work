import java.awt.Graphics;
import java.util.Stack;

/**
 * Tower class allows creation and manipulation of tower objects which
 * are towers of type disk
 * 
 * @author Jack Ambery
 *
 */
public class Tower {

	private Stack<Disk> tower;

	/**
	 * Constructs tower by instantiating tower as a new
	 * stack of type object
	 * 
	 */
	public Tower() {
		this.tower = new Stack<Disk>();
	}

	/**
	 * Adds disk object to the top of tower
	 * 
	 * @param disk to be added to tower
	 */
	public void push(Disk disk) {
		tower.push(disk);
	}

	/**
	 * Removes and returns top disk from tower
	 * 
	 * @return top disk from tower
	 */
	public Disk pop() {
		return tower.pop();
	}

	/**
	 * Returns but does not remove the top disk from tower
	 * 
	 * @return top disk from tower
	 */
	public Disk peek() {
		return tower.peek();
	}

	/**
	 * Returns number of disks in tower
	 * 
	 * @return integer number of disks in tower 
	 */
	public int size() {
		return tower.size();
	}

	/**
	 * Determines if tower is empty
	 * 
	 * @return true if no disks in tower, false if at least 1 is present
	 */
	public boolean isEmpty() {
		return tower.isEmpty();
	}

	/**
	 * Allows access of tower by other classes
	 * 
	 * @return tower field
	 */
	public Stack<Disk> getTower() {
		return tower;
	}

	/**
	 * Puts tower into a string format by listing radius of each disk in tower
	 * 
	 * @return String of integers representing the sizes of radiuses in tower's disks
	 */
	public String toString() {
		Stack<Disk> tempTower = tower;
		String temp = "";
		while (!tempTower.isEmpty()) {
			temp += tempTower.pop().toString() + " ";
		}
		return temp;
	}
	
	/**
	 * Draws a tower utilizing Disk's draw method. A drawn tower is a stack of drawn disks spaced
	 * so disks are touching.
	 * 
	 * @param g Graphics object drawing the various pieces
	 * @param xPos x-coordinate of tower
	 * @param yPos y-coordinate of tower, iterated to vertically stack disks
	 */
	public void drawTower(Graphics g, int xPos, int yPos) {
		Stack<Disk> tempTower = tower;
		while (!tempTower.isEmpty()) {
			tower.pop().drawDisk(g, xPos, yPos);
			yPos += 30;
		}
	}
}
