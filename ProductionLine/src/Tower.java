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
}
