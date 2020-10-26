import java.util.TreeMap;

public class DocumentIndex {
	
	private TreeMap<String, IndexEntry> entries;
	
	//key == word   value == index entry
	
	public DocumentIndex() {
		entries = new TreeMap<String, IndexEntry>();
	}
	
	public void addWord(String word, int num) {
		word = word.toUpperCase();
		if (!(entries.containsKey(word))) {
			entries.put(word, new IndexEntry(word));
		}
		entries.get(word).add(num);
	}
	
	public void addAllWords(String str, int num) {
		String[] words = str.split(" ");
		for (String s : words) {
			addWord(s, num);
		}
	}
	
	public TreeMap<String, IndexEntry> getEntries() {
		return entries;
	}

}
