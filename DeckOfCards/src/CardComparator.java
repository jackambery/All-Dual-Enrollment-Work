/**
 * @author Jack Ambery
 *
 */
public abstract class CardComparator implements Comparable<Card> {
	
	/**
	 * Main test class, tests Card and Deck methods
	 * Prints to "outputFile.txt"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck(51);
		Deck deck3 = new Deck(10);
		Deck deck4 = new Deck(2);
		Deck deck5 = new Deck(false);
		Deck deck6 = new Deck(true);
		Deck deck7 = new Deck(); //should be same as deck 1
		
		Card card1 = new Card();
		Card card2 = new Card(1, 1);
		Card card3 = new Card("clubs", 1);
		Card card4 = new Card(1, "ace");
		Card card5 = new Card("clubs", "ace");
		Card card6 = new Card(78, 78);
		
		System.out.println("Card Testing:");
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		System.out.println(card6);


		System.out.println("Deck Tests:");
		System.out.println("Printing Deck Before Shuffling:");
//		System.out.println(deck1);
//		System.out.println(deck2);
//		System.out.println(deck3);
//		System.out.println(deck4);
//		System.out.println(deck5);
//		System.out.println(deck6);
		
//		System.out.println("Equals Testing:");
//		System.out.println(deck1.equals(deck7));
//		System.out.println(deck4.equals(deck3));
//		System.out.println();
//
//		
//		System.out.println("Pick Testing:");
//		System.out.println(deck3.pick());
//		System.out.println(deck3);
//		System.out.println(deck1.pick());
		
		System.out.println("SelectionSort Testing:");
//		deck1.shuffle();
//		deck1.mergeSort();
//		System.out.println(deck1);
//		deck2.shuffle();
//		deck2.mergeSort();
//		System.out.println(deck2);
//		deck3.shuffle();
//		deck3.mergeSort();
//		System.out.println(deck3);
//		deck4.shuffle();
//		deck4.mergeSort();
//		System.out.println(deck4);
//		deck5.shuffle();
//		deck5.mergeSort();
//		System.out.println(deck5);
//		deck6.shuffle();
//		deck6.mergeSort();
//		System.out.println(deck6);

		System.out.println("BubbleSort Testing:");
//		deck1.shuffle();
//		deck1.mergeSort();
//		System.out.println(deck1);
//		deck2.shuffle();
//		deck2.mergeSort();
//		System.out.println(deck2);
//		deck3.shuffle();
//		deck3.mergeSort();
//		System.out.println(deck3);
//		deck4.shuffle();
//		deck4.mergeSort();
//		System.out.println(deck4);
//		deck5.shuffle();
//		deck5.mergeSort();
//		System.out.println(deck5);
//		deck6.shuffle();
//		deck6.mergeSort();
//		System.out.println(deck6);

		System.out.println("MergeSort Testing:");
//		deck1.shuffle();
//		deck1.mergeSort();
//		System.out.println(deck1);
//		deck2.shuffle();
//		deck2.mergeSort();
//		System.out.println(deck2);
//		deck3.shuffle();
//		deck3.mergeSort();
//		System.out.println(deck3);
//		deck4.shuffle();
//		deck4.mergeSort();
//		System.out.println(deck4);
//		deck5.shuffle();
//		deck5.mergeSort();
//		System.out.println(deck5);
//		deck6.shuffle();
//		deck6.mergeSort();
//		System.out.println(deck6);



		

	}

}
