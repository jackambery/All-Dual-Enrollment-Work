import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Stack;

public class Tower {

	private Stack<Disk> tower;

	public Tower() {
		this.tower = new Stack<Disk>();
	}

	public void push(Disk disk) {
		tower.push(disk);
	}

	public Disk pop() {
		return tower.pop();
	}

	public Disk peek() {
		return tower.peek();
	}

	public int size() {
		return tower.size();
	}

	public boolean isEmpty() {
		return tower.isEmpty();
	}

	public Stack<Disk> getTower() {
		return tower;
	}

	public String toString() {
		Stack<Disk> tempTower = tower;
		String temp = "";
		while (!tempTower.isEmpty()) {
			temp += tempTower.pop().toString() + " ";
		}
		return temp;
	}
	
	public void drawTower(Graphics g, int xPos, int yPos) {
		g.setColor(Color.WHITE);
		for (Disk d : tower) {
			d.drawDisk(g, xPos, yPos + 30);
		}
//		g.fillRoundRect(xPos, yPos, 100 + radius * 20, 30, 50, 50);
//		g.setColor(Color.BLACK);
//		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
//		g.drawString("" + radius, (170 + radius * 20)/2, yPos + 20);
//		g.setColor(Color.ORANGE);
	}
}
