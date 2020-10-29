/**
 * This class allows creation of Card objects using various constructors 
 * and gives Card objects methods
 * 
 * @author Jack Ambery
 *
 */
public class Card implements Comparable<Card> {
	
	private String suit;
	private String rank;
	
	//CLUBS = 1, DIAMONDS = 2, HEARTS = 3, SPADES = 4
	
	/**
	 * Default constructor sets Card to ace of clubs.
	 * This is the first card in a sorted deck.
	 */
	public Card() {
		suit = "clubs";
		rank = "ace";		
	}
	
	/**
	 * Creates Card with integer suit and ranks and sets fields to parameters
	 * 
	 * @param suit integer representation of suit
	 * @param rank integer representation of rank
	 * @throws NotValidCardException checks if ranks and suits are valid
	 */
	public Card(int suit, int rank) throws NotValidCardException {
		this.suit = getSuitStr(suit);
		this.rank = getRankStr(rank);
	}
	
	/**
	 * Creates Card with String suit and ranks
	 * and sets fields to parameters
	 * 
	 * @param suit String representation of suit
	 * @param rank String representation of rank
	 */
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;		
	}
	
	/**
	 * Creates Card with String suit and integer rank
	 * and sets fields to parameters
	 * 
	 * @param suit String representation of suit
	 * @param rank integer representation of rank
	 * @throws NotValidCardException checks if rank is valid
	 */
	public Card(String suit, int rank) throws NotValidCardException {
		this.suit = suit;		
		this.rank = getRankStr(rank);
	}
	
	/**
	 * Creates Card with integer suit and String rank
	 * and sets fields to parameters
	 * 
	 * @param suit integer representation of suit
	 * @param rank String representation of rank
	 * @throws NotValidCardException checks if suit is valid
	 */
	public Card(int suit, String rank) throws NotValidCardException {
		this.suit = getSuitStr(suit);		
		this.rank = rank;
	}
	
	/**
	 * toString method for Card class
	 * 
	 * @return a String representation of a Card
	 */
	@Override
	public String toString() {
		return rank + " of " + suit;	
	}
	
	/**
	 * Gets rank as a String
	 * 
	 * @param rank integer representation of rank
	 * @return the String representation of a given integer rank
	 * @throws NotValidCardException to catch if rank is valid
	 */
	public String getRankStr(int rank) throws NotValidCardException {
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
			throw new NotValidCardException("invalid rank number");
		}
	}
	
	/**
	 * Gets rank as an integer
	 * 
	 * @param rank String representation of rank
	 * @return integer representation of a given String rank
	 * @throws NotValidCardException to catch if rank is valid
	 */
	public int getRankInt(String rank) throws NotValidCardException {
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
			throw new NotValidCardException("invalid rank");
		}
	}
	
	/**
	 * Gets suit as a String
	 * 
	 * @param suit integer representation of suit
	 * @return the String representation of a given integer suit
	 * @throws NotValidCardException to catch if suit is valid
	 */
	public String getSuitStr(int suit) throws NotValidCardException {
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
			throw new NotValidCardException("invalid suit number");
		}
	}
	
	/**
	 * Gets suit as an integer
	 * 
	 * @param suit String representation of suit
	 * @return the integer representation of a given String suit
	 * @throws NotValidCardException to catch if suit is valid
	 */
	public int getSuitInt(String suit) throws NotValidCardException {
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
			throw new NotValidCardException("invalid suit");
		}
	}
	
	/**
	 * Compares the suits of two cards
	 * 
	 * @param other Card being compared to
	 * @return -1 if this is less than other, 1 if this is greater than other, 0 if this is equal to other
	 * @throws NotValidCardException catches if suit is valid
	 */
	public int compareSuitTo(Card other) throws NotValidCardException {
		if (getSuit() > other.getSuit()) {
			return 1;
		}
		if (getSuit() < other.getSuit()) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Compares the ranks of two cards
	 * 
	 * @param other Card being compared to
	 * @return -1 if this is less than other, 1 if this is greater than other, 0 if this is equal to other
	 * @throws NotValidCardException catches if rank is valid
	 */
	public int compareRankTo(Card other) throws NotValidCardException {
		if (getRank() > other.getRank()) {
			return 1;
		}
		if (getRank() < other.getRank()) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Compares suits then ranks two cards
	 * 
	 * @param other Card being compared to
	 * @return -1 if this is less than other, 1 if this is greater than other, 0 if this is equal to other
	 */
	@Override
	public int compareTo(Card other) {
		try {
			if (compareSuitTo(other) != 0) {
				return compareSuitTo(other);
			}
			else {
				return compareRankTo(other);
			}
		} catch (NotValidCardException e) {
			e.printStackTrace();
		}
		return -2; //not sure why I need a try/catch here and can't use a throw
	}
	
	/**
	 * Determines true of false if two cards are equal
	 * 
	 * @param other Card being compared to 
	 * @return true if this equals other, false if cards are not equal
	 * @throws NotValidCardException catches if rank and suit are valid
	 */
	//@Override can not override b/c of exception
	public boolean equals(Card other) throws NotValidCardException  {
		if (other instanceof Card) {
			if ( (this.getRankInt(rank) == other.getRankInt(rank)) && 
					(this.getSuitInt(suit) == other.getSuitInt(suit)) ) {
				return true;
			}
		}
		
		return false; //if cards are not equal
	}
	
	/**
	 * Method to access rank as integer
	 * 
	 * @return integer representation of rank
	 * @throws NotValidCardException to catch if rank is valid
	 */
	public int getRank() throws NotValidCardException {
		return getRankInt(rank);
	}
	
	/**
	 * Method to access suit as integer
	 * 
	 * @return integer representation of suit
	 * @throws NotValidCardException to catch if suit is valid
	 */
	public int getSuit() throws NotValidCardException {
		return getSuitInt(suit);
	}

}
