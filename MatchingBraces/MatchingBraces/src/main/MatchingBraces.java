package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchingBraces {
	
	
	public boolean bracketCheck(File file) {
		
		Scanner input = null;
		int count = 0;
		
		try {
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex){
			System.out.println("*** Cannot open " + file.getName() + " ***");
			System.exit(1);
		}
		
		while (count <= file.length()) {
			if (input.next().contentEquals("{")) {
				count++;
			}
			if (input.next().contentEquals("}")) {
				count--;
			}
		}
		
		if (count == 0) {
			return true;
		}
		
		return false;
		
	}

}
