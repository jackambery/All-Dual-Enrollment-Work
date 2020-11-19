import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLine {
	
	private Queue<Disk> input;
	private Queue<Tower> output;
	private Tower robotArm;
	
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}
	
	public void addDisk(Disk disk) {
		input.add(disk);
	}
	
	public void unloadRobot() {
		Tower pyramid = new Tower(); //type Stack
		while (!robotArm.isEmpty()) {
			pyramid.push(robotArm.pop());
		}
		output.add(pyramid);
	}
	
	public void process() {
		while (!input.isEmpty()) {
			if (input.peek().compareTo(robotArm.peek()) > 0) {
				robotArm.push(input.remove());
			}
			else {
				unloadRobot();
				robotArm.push(input.remove());
			}
		}
	}
	
	public Tower remove
	
	//**********Main Method************
	public static void main(String[] args) {
		
	}

}
