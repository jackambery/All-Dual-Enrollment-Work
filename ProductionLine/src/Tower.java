import java.util.Stack;

public class Tower {
	
	private Stack<Disk> tower;
	private int size;
	
	public Tower() {
		this.tower = new Stack<Disk>();
		size = 0;
	}
	
	//just use push() instead of addDisk()
	public void addDisk(Disk disk) {
		tower.push(disk);
		size++;
	}

}
