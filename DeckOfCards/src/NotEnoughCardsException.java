/**
 * Class for exception when deck.deal does not have enough cards
 * 
 * @author Jack Ambery
 *
 */
public class NotEnoughCardsException extends Exception {
	
	/**
	 * Creates new error by calling calling super
	 * 
	 * @param error error message
	 */
	public NotEnoughCardsException(String error) {
		super(error);
	}
}
