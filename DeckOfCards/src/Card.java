
public class Card implements Comparable<Card> {
	
	private String suit;
	private String rank;
	
	//CLUBS = 1, DIAMONDS = 2, HEARTS = 3, SPADES = 4
	
	//Constructors-------------------------------------------------------
	public Card() {
		suit = "clubs";
		rank = "ace";		
	}
	
	public Card(int suit, int rank) {
		this.suit = getSuitStr(suit);
		this.rank = getRankStr(rank);
	}
	
	public Card(String suit, String rank) {
		this.suit = rank;
		this.rank = rank;		
	}
	
	public Card(String suit, int rank) {
		this.suit = suit;		
		this.rank = getRankStr(rank);
	}
	
	public Card(int suit, String rank) {
		this.suit = getSuitStr(suit);		
		this.rank = rank;
	}
	
	//Methods--------------------------------------------------
	@Override
	public String toString() {
		return rank + " of " + suit;	
	}
	
	public String getRankStr(int rank) {
		switch (rank) {
		case 1:
			return "ace";
		case 2:
			return Integer.toString(rank);
		case 3:
			return Integer.toString(rank);
		case 4:
			return Integer.toString(rank);
		case 5:
			return Integer.toString(rank);
		case 6:
			return Integer.toString(rank);
		case 7:
			return Integer.toString(rank);
		case 8:
			return Integer.toString(rank);
		case 9:
			return Integer.toString(rank);
		case 10:
			return Integer.toString(rank);
		case 11:
			return "jack";
		case 12:
			return "queen";
		case 13:
			return "king";
		default:
			return "invalid card type";
		}
	}
	
	public int getRankInt(String rank) {
		switch (rank) {
		case "ace":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "jack":
			return 11;
		case "queen":
			return 12;
		case "king":
			return 13;
		default:
			return 0;
		}
	}
	
	public String getSuitStr(int suit) {
		switch (suit) {
		case 1:
			return "clubs";
		case 2:
			return "diamonds";
		case 3:
			return "hearts";
		case 4:
			return "spades";
		default:
			return "invalid suit number";
		}
	}
	
	public int getSuitInt(String suit) {
		switch (suit) {
		case "clubs":
			return 1;
		case "diamonds":
			return 2;
		case "hearts":
			return 3;
		case "spades":
			return 4;
		default:
			return 0;
		}
	}
	
	public int compareSuitTo(Card other) {
		if (getSuit() > other.getSuit()) {
			return 1;
		}
		if (getSuit() < other.getSuit()) {
			return -1;
		}
		return 0;
	}
	
	public int compareRankTo(Card other) {
		if (getRank() > other.getRank()) {
			return 1;
		}
		if (getRank() < other.getRank()) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public int compareTo(Card other) {
		if (compareSuitTo(other) != 0) {
			return compareSuitTo(other);
		}
		else {
			return compareRankTo(other);
		}
	}
	
	public boolean equals(Card other) {
		if ( (this.getRankInt(rank) == other.getRankInt(rank)) && 
				(this.getSuitInt(suit) == other.getSuitInt(suit)) ) {
			return true;
		}
		
		return false; //if cards are not equal
	}
	
	public int getRank() {
		return getRankInt(rank);
	}
	
	public int getSuit() {
		return getSuitInt(suit);
	}

}
