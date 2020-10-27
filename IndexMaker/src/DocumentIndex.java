import java.util.TreeMap;

/**
 * This class creates an index for a document utilizing a treemap
 * data structure of IndexEntrys.
 * 
 * @author Jack Ambery
 *
 */
public class DocumentIndex {
	
	private TreeMap<String, IndexEntry> entries;
	
	//key == word   value == index entry
	
	/**
	 * Default constructor sets up entries, a new treemap of IndexEntrys
	 * 
	 */
	public DocumentIndex() {
		entries = new TreeMap<String, IndexEntry>();
	}
	
	/**
	 * Adds word to index only if word is not already in index. Adds num to the treeset of word.
	 * 
	 * @param word represents the word to be added to the index
	 * @param num represents the line at which word occurs
	 */
	public void addWord(String word, int num) {
		word = word.toUpperCase();
		if (!(entries.containsKey(word))) {
			entries.put(word, new IndexEntry(word));
		}
		entries.get(word).add(num);
	}
	
	/**
	 * Creates array of words found in str and adds each word in array to index at line num
	 * 
	 * @param str represents a string containing multiple words
	 * @param num represents the line at which str occurs
	 */
	public void addAllWords(String str, int num) {
		String[] words = str.split("[ \\-.;:,!?]");
		for (String s : words) {
			addWord(s, num);
		}
	}
	
	/**
	 * Getter method for the entries treemap
	 * 
	 * @return returns the entries field which is of type TreeMap<String, IndexEntry>
	 */
	public TreeMap<String, IndexEntry> getEntries() {
		return entries;
	}

}
