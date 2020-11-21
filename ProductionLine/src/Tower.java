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
}
