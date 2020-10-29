import java.util.*;

/**
 * This class creates Decks and contains methods to sort, shuffle, and deal them
 * 
 * @author Jack Ambery
 *
 */
public class Deck {
	
	private Card[] deck;
	private int topCard;
	
	/**
	 * Creates deck of all 52 sorted cards
	 * 
	 * @throws NotValidCardException to catch any invalid cards
	 */
	public Deck() throws NotValidCardException {		
		this.deck = new Card[52];
		topCard = deck.length - 1;
		
		int temp = 0;
		
		for (int i = 1; i <= 4; i++) {
			try {
				for (int k = 1; k <= 13; k++) {
					deck[temp] = new Card(i, k);
					temp++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}		
	}	
	
	/**
	 * Creates a 52 card deck shuffled to sorted, specified by boolean parameter
	 * 
	 * @param sorted true if deck is to be sorted, false if deck is to be shuffled
	 * @throws NotValidCardException to catch any invalid cards
	 */
	public Deck(boolean sorted) throws NotValidCardException {	
		topCard = deck.length - 1;
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
	
	/**
	 * Creates deck of size cards, filled with random cards
	 * 
	 * @param cards specifies number of cards in deck
	 * @throws NotValidCardException to catch any invalid cards
	 */
	public Deck(int cards) throws NotValidCardException {
		
		this.deck = new Card[cards];
		topCard = deck.length - 1;

		for (int i = 0; i < cards; i++) {
			int suitRand = (int)(Math.random() * 4 + 1);
			int rankRand = (int)(Math.random() * 13 + 1);
			deck[i] = new Card(suitRand, rankRand);
		}
	}
	
	/**
	 * This method shuffles a deck of cards
	 * 
	 */
	public void shuffle() {
				
		for (int i = 1; i < this.deck.length - 1; i++) {
			int randPos = (int)(Math.random() * this.deck.length - 1); //position in the array
			Card temp = this.deck[i];						//card to be switched
			this.deck[i] = this.deck[randPos];				//switches temp card and card at randPos
			this.deck[randPos] = temp;						//switches randPos card to temp card
		}
	}
	
	/**
	 * Converts deck to a string. Prints one card per line if topCard <= 51
	 * Prints in 4 sorted columns if topCard = 52
	 * 
	 */
	@Override
	public String toString() {
		String deckStr = "";
		if (topCard < 51) {
			for (Card card : deck) {
				deckStr = deckStr + card.toString() + "\n";
			}
		}
		
		else {
	        deckStr += String.format("%-25s %-25s %-25s %-25s \n", "Clubs:", "Diamonds:", "Hearts:", "Spades:");
	        for(int i = 0; i < 13; i++) {
	        	deckStr += String.format("%-25s %-25s %-25s %-25s \n", deck[0+i], deck[13+i], deck[26+i], deck[39+i]);
	        }
		}	
		return deckStr;
	}
	
	/**
	 * Determines if two decks are equal
	 * 
	 * @param other deck to be compared to 
	 * @return true if decks are equal, false if not
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Deck) {
			Deck otherDeck = (Deck) other;
			for (int i = 1; i <= topCard; i++) {
				try {
					if (!this.deck[i].equals(otherDeck.deck[i])) {
						return false;
					}
				} catch (NotValidCardException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This method creates and return an array of hands each with a certain amount of cards, 
	 * Throws exception if there are too little cards
	 * 
	 * @param hands amount of hands or players
	 * @param cardsPerHand amount of cards per hand
	 * @return an array of decks of size cardsPerHand
	 * @throws NotEnoughCardsException if there are not enough cards to create enough hands
	 * @throws NotValidCardException to catch any invalid cards
	 */
	public Deck[] deal(int hands, int cardsPerHand) throws NotEnoughCardsException, NotValidCardException {
		int totalCards = hands * cardsPerHand;
		
		if (totalCards > topCard) {
			throw new NotEnoughCardsException("Not enough cards in deck");
		}			
		else {
			Deck[] decks = new Deck[hands];
			
			int index = 0;
			for (int j = 0; j < cardsPerHand - 1; j++) {
				for (int i = 0; i < hands; i++) {
					decks[i] = new Deck(cardsPerHand);
					decks[i].deck[j] = deck[index];
					index++;
				}
			}
			
			return decks;
		}
	}	
	
	/**
	 * Picks a card from a deck then removes it from that deck and shortens deck 
	 * by making topCard one less
	 * 
	 * @return a random card from the deck
	 */
	public Card pick() {
		Random picker = new Random();
		int randInt = picker.nextInt(topCard);
		Card chosen = deck[randInt];
		
		for(int i = 0; i <= deck.length - 1; i++) { 
			if (i < randInt) {
				continue;
			}
			else if (i < topCard){
				deck[i] = deck[i+1];
			}
		}	
		topCard--;
		return chosen;
	}
	
	/**
	 * Performs a selection sort on the deck
	 * 
	 */	
	public void selectionSort() {
		for(int n = deck.length; n > 1; n--) {
			
			int iMax = 0;
			for (int i = 1; i < n; i++) {
				if (deck[i].compareTo(deck[iMax]) == 1) {
					iMax = i;
				}
			}
			Card deckTemp = deck[iMax];
			deck[iMax] = deck[n - 1];
			deck[n - 1] = deckTemp;
		}
	}
	
	
	private Card[] temp;
	/** 
	 * Performs a merge sort on the deck
	 * 
	 */
	public void mergeSort() {
		int n = deck.length;
		temp = new Card[n];
		recursiveSort(deck, 0, n - 1);
	}
	/**
	 * Method used in merge sort
	 * 
	 * @param a deck being sorted
	 * @param from int to represent spot in deck
	 * @param to second int to represent spot in deck
	 */
	private void recursiveSort(Card[] a, int from, int to) {
		if (to - from < 2) {
			if (to > from && (a[to].compareTo(a[from]) == -1)) {
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
	/**
	 * Method used for merge sort
	 * 
	 * @param a deck being sorted
	 * @param from int to represent spot in deck
	 * @param middle int to represent spot in deck
	 * @param to int to represent spot in deck
	 */
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
	
	/**
	 * Performs a bubbleSort on the deck
	 * 
	 */
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

}
