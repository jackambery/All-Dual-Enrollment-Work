import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to construct and manipulate a PriorityMessageQueue
 * 
 * @author Jack Ambery
 *
 */
public class PriorityMessageQueue {
	
	private Queue<Message> q0, q1, q2, q3, q4;
	private ArrayList<Queue<Message>> inbox;

	public PriorityMessageQueue() {
		q0 = new LinkedList<Message>();
		q1 = new LinkedList<Message>();
		q2 = new LinkedList<Message>();
		q3 = new LinkedList<Message>();
		q4 = new LinkedList<Message>();
		inbox = new ArrayList<Queue<Message>>();
		inbox.add(q0);
		inbox.add(q1);
		inbox.add(q2);
		inbox.add(q3);
		inbox.add(q4);
	}

	public void processMessage(Message m) {
		int priority = m.getPriority();
		inbox.get(priority).add(m);
	}

	public void printInbox() {
		ArrayList<Queue<Message>> inbox2 = inbox;
		for (int i = 0; i < inbox2.size(); i++) {
			if (inbox2.get(i) != null) {
				while ((inbox2.get(i).peek() != null)) {
					System.out.print("Priority: ");
					System.out.print(inbox2.get(i).peek().getPriority());
					System.out.print(" Arrival: ");
					System.out.println(inbox2.get(i).poll().getArrivalTime());

				}
			}
		}	
	}
	
	/**
	 * Gets the first message in the highest priority queue that is not empty
	 * 
	 * @return the message in the highest non-empty priority queue
	 */
	public Message getMostImportant() {
		for (int i = 0; i < inbox.size(); i++) {
			if (!(inbox.get(i).isEmpty())) {
				Message top = inbox.get(i).peek();
				return top;
			}
		}
		return null;
	}
	
	/**
	 * Removes the first message in the highest, non-empty priority queue
	 * 
	 */
	public void removeMostImportant() {
		for (int i = 0; i < inbox.size(); i++) {
			if (!(inbox.get(i).isEmpty())) {
				inbox.get(i).poll();
			}
		}
	}

}
