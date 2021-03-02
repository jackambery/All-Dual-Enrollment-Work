
/**
 * Basic class to construct a Message object. A message has a priority 0-4, an arrival time
 * which is the minute is added to or received by a PriorityMessageQueue, and a process time 
 * which is the number of minutes it has had to process.
 * 
 * @author Jack Ambery
 *
 */
public class Message {
	
	/**
	 * Priority of the message (0-4), 0 is the highest, most important priority,
	 * 4 is the least.
	 */
	private int priority;
	
	/**
	 * Arrival time of the message, does not change.
	 */
	private int arrival;
	
	/**
	 * Time message has been processed, increments until it reaches 4.
	 */
	private int processTime;
	
	/**
	 * Constructs a message with a given priority and arrival time.
	 * 
	 * @param p int priority of the message
	 * @param a int arrival time of the message
	 */
	public Message(int p, int a) {
		priority = p;
		arrival = a;
	}
	
	/**
	 * Method to increment the processTime. This message is
	 * called until processTime reaches 4.
	 * 
	 */
	public void processing() {
		processTime++;
	}
	
	/**
	 * Returns the priority of the message.
	 * 
	 * @return int priority of the message
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Returns the arrival time of the message.
	 * 
	 * @return int arrival time of the message
	 */
	public int getArrivalTime() {
		return arrival;
	}
	
	/**
	 * Returns the minutes the message has been processed for.
	 * 
	 * @return the number of minutes the message has been processed for.
	 */
	public int getProcessTime() {
		return processTime;
	}
}
