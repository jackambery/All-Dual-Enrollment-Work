import java.util.Iterator;
import java.util.TreeSet;

/**
 * This class creates an entry for the index consisting of a string for the words
 * and a TreeSet for the lines at which that word is found
 * 
 * @author Jack Ambery
 *
 */
public class IndexEntry {
	
	private String word;
	private TreeSet<Integer> lines;
	
	/**
	 * Sets field to parameter and creates new TreeSet for the lines at which word occurs
	 * 
	 * @param word represents the word for the index entry
	 */
	public IndexEntry(String word) {
		this.word = word;
		lines = new TreeSet<Integer>();
	}
	
	/**
	 * Adds num to lines if not already in lines
	 * 
	 * @param num represents the line at which word occurred
	 */
	public void add(int num) { 
		if(!(lines.contains(num))) {
			lines.add(num);			
		}
	}
	
	/**
	 * Getter method for the word field
	 * 
	 * @return returns the word field
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Creates string representation of an index entry
	 * Returns the word followed by the lines it is found on separated by commas
	 * 
	 * @return returns the index as a string
	 */
	public String toString() {
		if (!(word.equals(""))) {
			Iterator<Integer> iterator = lines.iterator();
			String str = word + ": ";
			while (iterator.hasNext()) {
				str += iterator.next() + ", ";
			}
			str.toUpperCase();
			return str.substring(0, str.length() - 2); //substring gets rid of last comma on end
		}
		return "";
	}

}
