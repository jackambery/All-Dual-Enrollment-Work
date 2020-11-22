import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	private Queue<Disk> input;
	private static Queue<Tower> output;
	private Tower robotArm;

	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}

	public void addDisk(Disk disk) {
		input.add(disk);
	}
	
//	public void addAllDisks(String str) {
//		String[] disks = str.split("[ \\-.;:,!?]");
//		for (String s : disks) {
//			addDisk(new Disk(Integer.parseInt(s)));
//		}
//	}

	public void unloadRobot() {
		Tower pyramid = new Tower(); //type Stack
		while (!robotArm.isEmpty()) {
			pyramid.push(robotArm.pop());
		}
		output.add(pyramid);
	}

	//input = queue      robotArm = stack   small on bottom
	public void process() {
		Queue<Disk> tempInput = input;
		while (!tempInput.isEmpty()) {
			if (robotArm.isEmpty() || tempInput.peek().compareTo(robotArm.peek()) > 0) {
				robotArm.push(tempInput.remove());
			}
			else {
				unloadRobot();
				robotArm.push(tempInput.remove());
			}
		}
		unloadRobot();
	}

	public Tower removeTower() {
		return output.remove();
	}

	public void printOutput() {
		Queue<Tower> tempOutput = output;
		while (!tempOutput.isEmpty()) {
			System.out.print("Tower: " + tempOutput.remove().toString());
			System.out.println();
		}

	}

	public Queue<Disk> getInput() {
		return input;
	}
	
	public Queue<Tower> getOutput() {
		return output;
	}

}
