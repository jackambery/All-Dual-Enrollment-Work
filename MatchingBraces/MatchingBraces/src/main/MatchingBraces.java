package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchingBraces {
	
	
	public static boolean bracketCheck(File file) {
		
		Scanner input = null;
		int count = 0;
		
		try {
			input = new Scanner(file);
		}
		
		catch (FileNotFoundException ex){
			System.out.println("*** Cannot open " + file.getName() + " ***");
			System.exit(1);
		}
		
		for (String arr : file.list()) {
			for (char letter : arr.toCharArray()) {
				if (letter == '{') {
					count++;
				}
				if (letter == '}') {
					count--;
				}
			}
		}
		
		/*
		while (count <= file.length()) {
			if (input.next().contentEquals("{")) {
				count++;
			}
			if (input.next().contentEquals("}")) {
				count--;
			}
		}
		*/
		
		if (count == 0) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String args[]) {
		
		//String pathname = "testfile";
		File file = new File("testfile");
		
		if (bracketCheck(file) == true) {
			System.out.println(file.getName() + " has no bracket issues.");
		}
		else {
			System.out.println(file.getName() + " has an uneven amount of brackets.");
		}
	}

}
