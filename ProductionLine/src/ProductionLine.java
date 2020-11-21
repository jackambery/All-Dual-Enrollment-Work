import java.awt.Canvas;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JFrame;

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
	
	public void process() {
		while (!input.isEmpty()) {
			if (robotArm.isEmpty() || input.element().compareTo(robotArm.peek()) < 0) {
				robotArm.push(input.remove());
			}
			else {
				unloadRobot();
				robotArm.push(input.remove());
			}
		}
	}
	
	public Tower removeTower() {
		return output.remove();
	}
	
	public void printOutput() {
		for (Tower t: output) {
			System.out.print("Tower: " + t.toString());
			//with no tower toString
//			Iterator<Disk> count = t.getTower().iterator();
//			while (count.hasNext()) {
//				System.out.print(count.next().toString());
//			}
			
			System.out.println();
		}
	}

}
