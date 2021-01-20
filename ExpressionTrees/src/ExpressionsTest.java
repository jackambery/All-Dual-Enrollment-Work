import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExpressionsTest {

	//private static String[] exp = {"3", "10", "5", "2", "*", "+", "+"};
	//private static ExpressionTree tree = new ExpressionTree(null);
	
public static void main(String[] args) {
		Scanner kb = new Scanner(System.in); 
		System.out.println("What is the name of the test file?")
		String testFileName = kb.nextLine();
		File testFile = new File(testFileName);
		Scanner testScanner;
		try {
			//Makes array of file names from the file "tests" which lists filenames
			testScanner = new Scanner(testFile);
			
			ArrayList<String> expressions = new ArrayList<String>();
			while(testScanner.hasNextLine()) {
				expressions.add(testScanner.nextLine());
			}
			
			//Output writer
			File output = new File("myAnswers.txt");
			PrintWriter p = new PrintWriter(output);
			
			for (String s : testFiles) {
				try {
					//Makes array of all numbers in a file
					//first number is limit
					//rest of numbers are the melons
					File file = new File(s);
					Scanner inputScanner = new Scanner(file);
					ArrayList<Integer> nums = new ArrayList<Integer>(); //list of all numbers in test files
					
					while(inputScanner.hasNextLine()) {
						nums.add(Integer.parseInt(inputScanner.nextLine()));
					}
					if (nums.isEmpty()) {
						p.println("No limit or weights given in \"" + s + "\".");
						break;
					}
					
					//sets w, limit, and n
					int[] w = new int[nums.size() - 1];
					int limit = nums.get(0);
					int n = w.length - 1;
					ArrayList<Integer> list = new ArrayList<Integer>();
					
					//fills w
					for (int i = 1; i < nums.size(); i++) {
						w[i - 1] = nums.get(i);
						//System.out.print(w[i] + ", ");
					}					
					
					
					//printing
					
					//filename, limit, and melons(w)
					p.println(file.getName() + "	" + limit + "	" + Arrays.toString(w));
					p.println();
					
					//computes knapsack problem
					knapsackSum(w, n, limit, list);
					
					//prints used watermelons, if none are used, prints "No possible watermelons"
					if (!list.isEmpty()) {
						for (int i : list) {
							p.println(i + " pound watermelon");
						}
					}
					else {
						p.println("No possible watermelons");
					}
					p.println();
					
					inputScanner.close();
				}
				
				catch (FileNotFoundException e) { 
					p.println("**ERROR**");
					p.println("The file: \"" + s + "\" was not found.");
					
				}
			}
			testScanner.close();
			p.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("The file entered was not found.");
			System.out.println("Please enter a file containing tests.");
		}

	}
}
