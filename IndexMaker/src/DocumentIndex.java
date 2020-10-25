import java.util.TreeMap;

public class DocumentIndex {
	
	private TreeMap<String, IndexEntry> entries;
	
	//key == word   value == index entry
	
	public DocumentIndex() {
		entries = new TreeMap<String, IndexEntry>();
	}
	
	public void addWord(String word, int num) {
		if (entries.containsKey(word)) {
			entries.get(word).add(num);
		}
		else {
			IndexEntry newEntry = entries.put(word, new IndexEntry(word));
			newEntry.add(num);
		}
	}
	
	public void addAllWords(String str, int num) {
		String[] words = str.split(" ");
		for (String s : words) {
			addWord(s, num);
		}
	}

}
