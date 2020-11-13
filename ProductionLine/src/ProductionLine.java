import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLine {
	
	private Queue<Disk> input;
	private Queue<Tower> output;
	private Stack<Disk> robotArm;
	
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Stack<Disk>();
	}
	
	public void addDisk(Disk disk) {
		input.add(disk);
	}
	
	public void unloadRobot() {
		Tower pyramid = new Tower(); //type Stack
		while (robotArm.size() > 0) {
			pyramid.addDisk(robotArm.pop());
		}
		output.add(pyramid);
	}
	
	
	//**********Main Method************
	public static void main(String[] args) {
		
	}

}
