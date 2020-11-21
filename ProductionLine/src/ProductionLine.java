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

	public void unloadRobot() {
		Tower pyramid = new Tower(); //type Stack
		while (!robotArm.isEmpty()) {
			pyramid.push(robotArm.pop());
		}
		output.add(pyramid);
	}

	//input = queue      robotArm = stack   small on bottom
	public void process() {
		while (!input.isEmpty()) {
			if (robotArm.isEmpty() || input.peek().compareTo(robotArm.peek()) > 0) {
				robotArm.push(input.remove());
			}
			else {
				unloadRobot();
				robotArm.push(input.remove());
			}
		}
		unloadRobot();
	}

	public Tower removeTower() {
		return output.remove();
	}

	public void printOutput() {
		for (Tower t: output) {
			System.out.print("Tower: " + t.toString());
			System.out.println();
		}

	}

	public Queue<Disk> getInput() {
		return input;
	}

}
