import java.util.*;

public class Deck {
	
	//fields
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
	
	public Deck(int cards) {
		this.deck = new Card[cards];	
		topCard = deck.length - 1;		
	}
	
	
	public Deck(boolean shuffled, int cards) {		
		this.deck = new Card[cards];
		topCard = deck.length - 1;
		
		if (shuffled == true) {
			shuffle();
		}
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
	
	public String toString() {
		String deckStr = "";		
		for (Card card : deck) {
			deckStr = deckStr + card.toString() + " , ";
		}
		return deckStr;
	}
	
	//does not work
	public boolean equals(Deck other) {
		for (int i = 1; i <= deck.length - 1; i++) {
			if (this.deck[i] != other.deck[i]) {
				return false;
			}
		}
		return true;
	}
	
	public Deck[] deal(int hands, int cardsPerHand) throws NotEnoughCardsException {
			
		if (hands * cardsPerHand > topCard) {
			throw new NotEnoughCardsException("Not enough cards in deck");
		}			
		else {
			Deck[] dealtHands = new Deck[hands];
			shuffle();				
			for(Deck deck : dealtHands) {
				deck.deck = new Card[cardsPerHand];
				//need to add cards to each hand
			}
			return dealtHands;
		}
	}	
	
	public Card pick() {
		Random picker = new Random();
		int randInt = picker.nextInt(deck.length - 1);
		Card chosen = deck[randInt];
		
		//need to shorten deck by removing chosen card
		/*
		for(int i = 0; i <= deck.length - 1; i++) { 
			if (i < randInt) {
				continue;
			}
			else if (i < deck.length - 2){
				deck[i] = deck[i+1];
			}
		}
		*/
		
		return chosen;
	}
	
	public void selectionSort() {
		int n = deck.length - 1;		
		while (n > 1) {
			int maxPos = 0;
			for (int k = 1; k < n; k++) {
				if (deck[k].getRank() > (deck[maxPos].getRank())) {
					maxPos = k;
				}
			Card temp = deck[maxPos];
			deck[maxPos] = deck[n - 1];
			deck[n - 1] = temp;
			n--;
			}
		}
	}
	
	public static void main(String[] args) throws NotEnoughCardsException {
		Deck testDeck = new Deck();
		//Deck testDeck2 = new Deck();
		//testDeck.shuffle();
		//testDeck.selectionSort();
		//testDeck.deal(8, 8);
		//System.out.println(testDeck.deck[34].toString());
		//System.out.println(testDeck.toString());
		//System.out.println(testDeck.equals(testDeck2));
	}

}
