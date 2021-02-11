import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class TicTacToeMyHashMap {

	private static HashMap<String, Boolean> myMap;

	/**
	 * Constructor which instantiates the HashMap.
	 * 
	 */
	TicTacToeMyHashMap() {
		myMap = new HashMap<String, Boolean>();
	}

	@Override
	/**
	 * Returns a new hash code value using my hash code function.
	 * 
	 * How the Hash Function works:
	 * If a board is invalid, the position is set to 0. If a board is valid, the base-3 
	 * representation of the board is converted to base-10 then that number is divided by 10. 
	 * This cuts down the extra space in the previous, size 19,000 array. 
	 * 
	 * Does not work, was unsure of how to make the map use this method, 
	 * and did not know how to use Board's method since this class does not 
	 * utilize or extend Board like the others did.
	 * 
	 * @return new hash code value from my hash function
	 */
	public int hashCode() {
		String s = ""; // 9 chars for each spot in given board
		int xCount = 0; // number of x's
		int oCount = 0; // number of o's
		int index = 0; // spot in array

		for (int r = 0; r < TicTacToe.ROWS; r++) {
			for (int c = 0; c < TicTacToe.COLS; c++) {
//				switch(charAt(r, c)) {
//				case 'x':
//					s += "1";
//					xCount++;
//					break;
//				case 'o':
//					s += "2";
//					oCount++;
//					break;
//				case ' ':
//					s += "0";
//					break;
//				default:
//					s += charAt(r, c);
//				}
			}
		}
 
		// check if board in invalid
		if (! (xCount > 2 || oCount > 2))
			return 0;
		if (! ((xCount == oCount + 1) || (oCount == xCount + 1)))
			return 0;
		
		//base 3 to base 10
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				index += ( Character.getNumericValue(s.charAt(i)) * Math.pow(3, s.length() - (i + 1)) );
			}
		}
		
		return index / 10; //index of this board in the array
	}
	
	/**
	 * Returns the size of whole map. Utilizes reflect.
	 * 
	 * @return size of the map, not items in the map
	 * @throws NoSuchFieldException if illegal field is given
	 * @throws IllegalAccessException if error concerning access
	 */
	private int capacity() throws NoSuchFieldException, IllegalAccessException {
		Field tableField = HashMap.class.getDeclaredField("table");
		tableField.setAccessible(true);
		Object[] table = (Object[]) tableField.get(myMap);
		return table == null ? 0 : table.length;   
	}

	//variables for evaluate method, which can be printed later in main
	private static int capacity = 0;
	private static int entries = 0;
	private static double loadFactor = 0;
	private static int collisions = 0;
	/**
	 * Evaluates the map's capacity, entries, collisions, load factor, and distribution.
	 * Prints the distribution of entries in each tenth and in each quarter, sets
	 * entries, load factor, and collisions.
	 * 
	 * @throws NoSuchFieldException if illegal field is given
	 * @throws IllegalAccessException if error concerning access
	 */
	private void evaluate() throws NoSuchFieldException, IllegalAccessException {
		Field tableField = HashMap.class.getDeclaredField("table");
		tableField.setAccessible(true);
		Object[] table = (Object[]) tableField.get(myMap);
		capacity = table == null ? 0 : table.length;   
		for (Object o : table) {
			if (o != null) {
				entries++;
			}
		}
		collisions = 1400 - entries; //1400 is number of winners or total number or items in map
		loadFactor = (double) entries / capacity;

		//distribution of entries in each tenth of the map
		double stop = capacity * 0.1;
		int count = 0;
		int i = 0;
		int percentCount = 10;
		while (i < capacity) {
			while (i < stop) {
				if (table[i] != null) {
					count++;
				}
				i++;
			}
			System.out.println("Number of entries in the " + (percentCount - 10) + "% - " + percentCount + "% of the map: " + count);
			count = 0;
			stop += capacity * 0.1;
			percentCount += 10;
		}

		//distribution of entries in each quarter of the map
		double stop2 = capacity * 0.25;
		int count2 = 0;
		int i2 = 0;
		int percentCount2 = 25;
		while (i2 < capacity) {
			while (i2 < stop2) {
				if (table[i2] != null) {
					count2++;
				}
				i2++;
			}
			System.out.println("Number of entries in the " + (percentCount2 - 25) + "% - " + percentCount2 + "% of the map: " + count2);
			count2 = 0;
			stop2 += capacity * 0.25;
			percentCount2 += 25;
		}


	}

	/**
	 * Main method. Takes in a file of winning boards and sets them in the HashMap.
	 * Prints the map's capacity, entry distribution, load factor, and collisions.
	 * 
	 * @param args prints
	 * @throws java.io.FileNotFoundException if input file is not found
	 * @throws NoSuchFieldException if illegal field is given
	 * @throws IllegalAccessException if error concerning access
	 */
	public static void main(String[] args) throws java.io.FileNotFoundException,
	NoSuchFieldException, 
	IllegalAccessException {

		TicTacToeMyHashMap m = new TicTacToeMyHashMap();

		File winnersFile = new File("TicTacToeWinners.txt");

		try {
			Scanner winnersScanner = new Scanner(winnersFile);
			while(winnersScanner.hasNextLine()) {
				String line = winnersScanner.nextLine();

				//sets all winners to true in map
				myMap.put(line, true);
			}

			winnersScanner.close(); 
		}
		catch (FileNotFoundException e) {
			System.out.println("Winners file was not found.");
		}

		System.out.println("Capacity from the given capacity method: " + m.capacity());
		System.out.println();

		m.evaluate();
		System.out.println();
		System.out.println("Capacity = " + capacity);
		System.out.println("Entries: " + entries);
		System.out.println("Load Factor: " + loadFactor);
		System.out.println("Collisions = " + collisions);

	}

}
