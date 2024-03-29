import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class TicTacToeHashMap {

	private static HashMap<String, Boolean> myMap;

	/**
	 * Constructor which instantiates the HashMap.
	 * 
	 */
	TicTacToeHashMap() {
		myMap = new HashMap<String, Boolean>();
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

		TicTacToeHashMap m = new TicTacToeHashMap();

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