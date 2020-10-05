import java.util.*;

public class Deck {
	
	private Card[] deck;
	private int topCard;
	
	public Deck() {		
		this.deck = new Card[52];
		topCard = deck.length - 1;
		
		int temp = 0;
		
		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 13; k++) {
				deck[temp] = new Card(i, k);
				temp++;
			}	
		}		
	}	
	
	public Deck(boolean sorted) {	
		this.deck = new Card[52];
		int temp = 0;
		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 13; k++) {
				deck[temp] = new Card(i, k);
				temp++;
			}	
		}	
		if (sorted == false) {
			shuffle();
		}
	}
	
	public Deck(int cards) {
		this.deck = new Card[cards];
	}
	
	public void shuffle() {
		
		Random random = new Random();
		
		for (int i = 1; i < this.deck.length - 1; i++) {
			int randPos = random.nextInt(this.deck.length); //position in the array
			Card temp = this.deck[i];						//card to be switched
			this.deck[i] = this.deck[randPos];				//switches temp card and card at randPos
			this.deck[randPos] = temp;						//switches randPos card to temp card
		}
	}
	
	@Override
	public String toString() {
		String deckStr = "";
		if (topCard < 51) {
			for (Card card : deck) {
				deckStr = deckStr + card.toString() + "\n";
			}
		}
		
		else {
	        deckStr += String.format("%-25s %-25s %-25s %-25s", "Clubs", "Diamonds", "Hearts", "Spades");
	        for(int i = 0; i < 13; i++) {
	        	deckStr += String.format("%-25s %-25s %-25s %-25s \n", deck[0+i], deck[13+i], deck[26+i], deck[39+i]);
	        }
		}	
		return deckStr;
	}
	
	public boolean equals(Deck other) {
		for (int i = 1; i <= deck.length - 1; i++) {
			if (this.deck[i].compareTo(other.deck[i]) != 0) {
				return false;
			}
		}
		return true;
	}
	
	public Deck[] deal(int hands, int cardsPerHand) throws NotEnoughCardsException {
		int totalCards = hands * cardsPerHand;
		
		if (totalCards > topCard) {
			throw new NotEnoughCardsException("Not enough cards in deck");
		}			
		else {
			shuffle();
			Deck[] decks = new Deck[hands];
			
			int index = 0;
			for (int j = 0; j < cardsPerHand - 1; j++) {
				for (int i = 0; i < hands - 1; i++) {
					decks[i] = new Deck(cardsPerHand);
					decks[i].deck[j] = deck[index];
					index++;
				}
			}
			
			return decks;
		}
	}	
	
	public Card pick() {
		Random picker = new Random();
		int randInt = picker.nextInt(deck.length - 1);
		Card chosen = deck[randInt];
		
		for(int i = 0; i <= deck.length - 1; i++) { 
			if (i < randInt) {
				continue;
			}
			else if (i < deck.length - 1){
				deck[i] = deck[i+1];
			}
		}		
		return chosen;
	}
	
	public void selectionSort() {
	    for (int i = 0; i < deck.length - 1; i++) {
	        int minPos = i;
	        for (int j = i + 1; j < deck.length; j++) {
	            if (deck[minPos].compareTo(deck[j]) == 1) {
	                minPos = j;
	            }
	        }
	 
	        if (minPos != i) {
	            Card temp = deck[i];
	            deck[i] = deck[minPos];
	            deck[minPos] = temp;
	        }
	    }
	}
	
	private Card[] temp;
	public void mergeSort() {
		int n = deck.length;
		temp = new Card[n];
		recursiveSort(deck, 0, n - 1);
	}
	private void recursiveSort(Card[] a, int from, int to) {
		if (to - from < 2) {
			if (to > from && (a[from].compareTo(a[from]) == -1)) {
				Card aTemp = a[to];
				a[to] = a[from];
				a[from] = aTemp;
			}
		}
		else {
			int middle = (from + to) / 2;
			recursiveSort(a, from, middle);
			recursiveSort(a, middle + 1, to);
			merge(a, from, middle, to);
		}
	}
	private void merge(Card[] a, int from, int middle, int to) {
		int i = from;
		int j = middle + 1;
		int k = from;
		
		while (i <= middle && j <= to) {
			if (a[i].compareTo(a[j]) == -1) {
				temp[k] = a[i];
				i++;
			}
			else {
				temp[k] = a[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			temp[k] = a[i];
			i++;
			k++;
		}
		while (j <= to) {
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++) {
			a[k] = temp[k];
		}
	}
	
	public void bubbleSort() {
		boolean sorted = false;
		Card temp;
		while(!sorted) {
			sorted = true;
			for (int i = 0; i < deck.length - 1; i++) {
				if (deck[i].compareTo(deck[i + 1]) == 1) {
					temp = deck[i];
					deck[i] = deck[i + 1];
					deck[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NotEnoughCardsException {
		Deck testDeck = new Deck();
		//Deck testDeck2 = new Deck();
		//testDeck.shuffle();
		//testDeck.selectionSort();
		//testDeck.mergeSort();
		//testDeck.bubbleSort();
		//testDeck.deal(8, 8);
		//System.out.println(testDeck.deck[34].toString());

		//System.out.println(testDeck.toString());

		//System.out.println(testDeck.equals(testDeck2));
	}

}
