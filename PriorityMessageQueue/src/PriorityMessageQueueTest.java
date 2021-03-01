import java.util.Random;

public class PriorityMessageQueueTest {
	
	public static void main(String[] args) {
		Random random = new Random();
		PriorityMessageQueue p = new PriorityMessageQueue();
		
		//double startTime = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			int rand = random.nextInt(5); // 0, 1, 2, 3, 4
			if (rand == 0) { //0.2 probability of occurring
				int priority = random.nextInt(5);
				Message m = new Message(priority, i + 4);
				p.process(m);
				
			}
		}
		p.printInbox();
		//double endTime = System.nanoTime();
		//System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");

	}
}
