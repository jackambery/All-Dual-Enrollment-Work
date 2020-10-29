import java.util.Comparator;

/**
 * This class compares the suit of two given cards.
 * @author Jack Ambery
 *
 */
public abstract class CardComparatorSuitOnly implements Comparator<Card> {
	
	/**
	 * Compares two cards to determine which is greater/lesser based on suit
	 * 
	 * @param a first card to be compared
	 * @param b second card to be compared
	 * @return integer 0, 1, or -1 if Card a's suit is equal to, greater than, or less than Card b
	 */
	@Override
	public int compare(Card a, Card b) {
		try {
			return a.compareSuitTo(b);
		} catch (NotValidCardException e) {
			e.printStackTrace();
		}
		return -2; //have to return something, code should never reach here though
	}
}