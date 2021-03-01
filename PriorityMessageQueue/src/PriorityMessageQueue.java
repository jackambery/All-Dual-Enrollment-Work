import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityMessageQueue {
	Queue<Message> q0, q1, q2, q3, q4;
	ArrayList<Queue<Message>> inbox;

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

	public void process(Message m) {
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

}
