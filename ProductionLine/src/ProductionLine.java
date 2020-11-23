import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	private Queue<Disk> input;
	private static Queue<Tower> output;
	private Tower robotArm;

	/**
	 * Instantiates input and output as new LinkedLists of type disk
	 * and tower and robotArm as a new Tower
	 *  
	 */
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}

	/**
	 * Adds disk to input queue
	 * 
	 * @param disk to be added to input
	 */
	public void addDisk(Disk disk) {
		input.add(disk);
	}
	
//	public void addAllDisks(String str) {
//		String[] disks = str.split("[ \\-.;:,!?]");
//		for (String s : disks) {
//			addDisk(new Disk(Integer.parseInt(s)));
//		}
//	}

	/**
	 * Takes the current tower that is robotArm, flips it into a temporary 
	 * stack, then adds that stack to output
	 * 
	 */
	public void unloadRobot() {
		Tower pyramid = new Tower(); //type Stack
		while (!robotArm.isEmpty()) {
			pyramid.push(robotArm.pop());
		}
		output.add(pyramid);
	}

	/**
	 * Processes all disks in input to create towers to add to output.
	 * Adds disks to robotArm until next disk is smaller than the previous
	 * then unloadsRobot into output
	 * 
	 */
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

	/**
	 * Returns and removes tower from output queue
	 * 
	 * @return tower from output queue
	 */
	public Tower removeTower() {
		return output.remove();
	}
	
	/**
	 * Method created to test code before starting graphics but is effectively
	 * a toString method. Prints each tower in output to its own line
	 *  
	 */
	public void printOutput() {
		Queue<Tower> tempOutput = output;
		while (!tempOutput.isEmpty()) {
			System.out.print("Tower: " + tempOutput.remove().toString());
			System.out.println();
		}

	}

	/**
	 * Allows access of input by other classes
	 * 
	 * @return the input queue of disks
	 */
	public Queue<Disk> getInput() {
		return input;
	}
	
	/**
	 * Allows access of output by other classes
	 * 
	 * @return the output queue of towers
	 */
	public Queue<Tower> getOutput() {
		return output;
	}
	
	/**
	 * Adds 8 randomly sized disks to input from radiuses 1-10
	 * 
	 */
	public void addRandomDisks() {
		for (int i = 1; i <= 8; i++) {
			int rand = (int) (Math.random() * 10) + 1;
			addDisk(new Disk(rand));
		}
	}

}
