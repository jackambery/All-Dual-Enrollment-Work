import java.util.Iterator;
import java.util.TreeSet;

public class IndexEntry {
	
	private String word;
	private TreeSet<Integer> lines;
	
	public IndexEntry(String word) {
		this.word = word;
		lines = new TreeSet<Integer>();
	}
	
	public void add(int num) { 
		if(!(lines.contains(num))) {
			lines.add(num);			
		}
	}
	
	public String getWord() {
		return word;
	}
	
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
