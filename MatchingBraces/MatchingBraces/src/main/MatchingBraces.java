package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Jack Ambery
 * <p>This class takes in a document and tests if there is an equal 
 * amount of open and closed braces.
 * </p>
 *
 */

public class MatchingBraces {
	
	/**
	 * @param file the file user wants to test
	 * @return true if bracket issues are not evident, false otherwise
	 */
	public static boolean bracketCheck(File file) {
		
		Scanner input = null;    //initialized if file exists
		int count = 0;    //should end at zero if file is good
		
		try {
			input = new Scanner(file);
		}
		
		catch (FileNotFoundException ex){
			System.out.println("*** Cannot open " + file.getName() + " ***");
			System.exit(1);
		}
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			for (char letter : line.toCharArray()) {
				if (letter == '{') {
					count++;
				}
				if (letter == '}') {
					count--;
				}
			}
		}
		
		if (count == 0) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * This is the test class.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		String pathname = "testfile";
		File file = new File(pathname);
		
		if (bracketCheck(file) == true) {
			System.out.println(file.getName() + " has no bracket issues.");
		}
		else {
			System.out.println(file.getName() + " has an uneven amount of brackets.");
		}
	}

}
