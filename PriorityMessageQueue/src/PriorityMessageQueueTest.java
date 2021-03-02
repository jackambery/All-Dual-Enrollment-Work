import java.util.ArrayList;
import java.util.Random;

/**
 * This class tests the PriorityMessageQueue class with a 600 simulation that adds random messages 
 * every few "minutes" and calculates the difference in wait times for each of the different
 * priority queues.
 * 
 * @author Jack Ambery
 *
 */
public class PriorityMessageQueueTest {

	/**
	 * Prints out the total wait time for messages in each priority queue.
	 * Adds up integers in each of waitTimes' ArrayLists 
	 * 
	 * @param waitTimes ArrayList of ArrayLists of Integers
	 */
	public static void printWaitTimes(ArrayList<ArrayList<Integer>> waitTimes) {
		int sum = 0;
		for (int i = 0; i < waitTimes.size(); i++) {
			System.out.print("Priority: ");
			System.out.print(i);
			if (!(waitTimes.get(i).isEmpty())) {
				for (int j = 0; j < waitTimes.get(i).size(); j++) {
					sum += waitTimes.get(i).remove(j);
				}
			}
			System.out.print(" Combined Total Wait Time: ");
			System.out.println(sum + " minutes");
		}
	}

	/**
	 * Creates a new PriorityMessageQueue. Creates waitTimes which is an ArrayList of ArrayLists which hold
	 * the processing times of each message in a priority queue. Runs a simulation in which 600 minutes, messages
	 * occur with a chance of 0.2 each minute and are created with random priorities. Higher priority messages are
	 * processed before others, allowing longer wait times for others. Once the most important message has had 4 
	 * minutes to process, it is removed from the message queue and its wait time is added to the proper ArrayList 
	 * in waitTimes. Wait times for each priority queue are printed.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Random random = new Random();
		PriorityMessageQueue p = new PriorityMessageQueue();
		int currentTime = 0;

		//ArrayList of 5 ArrayLists, hold the total number of seconds each message 
		//took in each priority queue
		ArrayList<ArrayList<Integer>> waitTimes = new ArrayList<ArrayList<Integer>>();
		//fills waitTimes
		for (int i = 0; i < 5; i++) {
			waitTimes.add(new ArrayList<Integer>());
		}

		//600 minutes, messages every fifth minute (0.2 probability)
		for(int i = 0; i < 600; i++) {
			int rand = random.nextInt(5); // 0, 1, 2, 3, 4
			if (rand == 0) { //0.2 probability of occurring
				int priority = random.nextInt(5); //random priority for new message
				Message m = new Message(priority, i); //i is arrival time
				p.processMessage(m); //adds message to priority queue
			}

			//processes most important message until it has been processed
			//for 4 seconds then removes it and adds its waiting time to the 
			//waiting time ArrayLists
			if (p.getMostImportant() != null) {
				p.getMostImportant().processing();
				if (p.getMostImportant().getProcessTime() == 4) {
					Message top = p.getMostImportant();
					waitTimes.get(top.getPriority()).add(currentTime - top.getArrivalTime());
					p.removeMostImportant();
				}
			}
			currentTime++;
		}
		printWaitTimes(waitTimes);
		//p.printInbox();
	}
}
