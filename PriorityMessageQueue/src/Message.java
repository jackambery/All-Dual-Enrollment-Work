
public class Message {
	
	private int priority;  // 0 - 4, 0 is highest priority
	private int arrival;
	
	public Message(int p, int a) {
		priority = p;
		arrival = a;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getArrivalTime() {
		return arrival;
	}
}
