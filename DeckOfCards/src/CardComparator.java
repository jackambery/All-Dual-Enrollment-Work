import java.util.Comparator;

/**
 * This class compares the suit and rank of two given cards.
 * @author Jack Ambery
 *
 */
public abstract class CardComparator implements Comparator<Card> {
	
	/**
	 * Compares two cards to determine which is greater/lesser
	 * 
	 * @param a first card to be compared
	 * @param b second card to be compared
	 * @return integer 0, 1, or -1 if Card a is equal to, greater than, or less than Card B
	 */
	@Override
	public int compare(Card a, Card b) {
		return a.compareTo(b);
	}
}