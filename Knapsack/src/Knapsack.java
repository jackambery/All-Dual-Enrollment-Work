import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class finds the optimal combination of watermelon weights to fill
 * a knapsack. Can keep track of the melons used or not.
 * 
 * @author Jack Ambery
 *
 */
public class Knapsack {

	/**
	 * Returns the greater of two given integers.
	 * 
	 * @param i first integer to be compared
	 * @param k second integer to be compared
	 * @return the larger of the two given integers
	 */
	public static int max(int i, int k) {
		if (i > k) {
			return i;
		}
		return k;
	}
	
	/**
	 * Performs the knapsack problem. Finds the weight of the best combination of given watermelon
	 * weights that does not exceed the knapsack weight limit.
	 * 
	 * @param w the array of weights of the watermelons
	 * @param n the number of watermelons allowed to be used, the total number of watermelons
	 * @param limit the weight limit of the knapsack, combined weight of watermelons can not exceed this number
	 * @return the total weight of watermelons used in the 
	 */
	public static int knapsackSum(int[] w, int n, int limit) {
		int total1 = 0;
		int total2 = 0;
		if (n < 0 || limit == 0) {
			return 0;
		}
		if (w[n] > limit) {
			total1 = knapsackSum(w, n - 1, limit);
		}
		else {
			total1 = 0;
		}
		if (w[n] <= limit) {
			total2 = knapsackSum(w, n - 1, limit - w[n]) + w[n];
		}
		else {
			total2 = 0;
		}
		return max(total1, total2);
	}
	
	/**
	 * Performs the knapsack problem. Finds the weight of the best combination of given watermelon
	 * weights that does not exceed the knapsack weight limit. Also keeps track of the watermelons
	 * used in the final, best combination.
	 * 
	 * @param w the array of weights of the watermelons
	 * @param n the number of watermelons allowed to be used, the total number of watermelons
	 * @param limit the weight limit of the knapsack, combined weight of watermelons can not exceed this number
	 * @param list an ArrayList of the weights used in the best combination
	 * @return the total weight of watermelons used in the 
	 */
	public static int knapsackSum(int[] w, int n, int limit, ArrayList<Integer> list) {
		int total1 = 0;
		int total2 = 0;
		int i = 0;
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		if (n < 0 || limit == 0) {
			return 0;
		}
		if (w[n] > limit) {
			listA.add(w[n]);
			total1 = knapsackSum(w, n - 1, limit, list);
		}
		else {
			listA.clear();
			listB.clear();
			total1 = 0;
		}
		if (w[n] <= limit) {
			listB.add(w[i]);
			total2 = knapsackSum(w, n - 1, limit - w[n], list) + w[n];
		}
		else {
			listA.clear();
			listB.clear();
			total2 = 0;
		}

		if (max(total1, total2) == total1) {
			list.addAll(listA);
		}
		else if (max(total1, total2) == total2){
			list.addAll(listB);
		}

		return max(total1, total2);
	}	
	
	/**
	 * Main method for Knapsack class. Takes in "tests" file which indicates certain test
	 * files. For each of those files, the knapsackSum method is applied, and the
	 * results are printed to the "knapsack.txt" file
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		
		File tests = new File("tests");
		Scanner testScanner;
		try {
			
			//Makes array of file names from the file "tests" which lists filenames
			testScanner = new Scanner(tests);
			ArrayList<String> testFiles = new ArrayList<String>();
			while(testScanner.hasNextLine()) {
				testFiles.add(testScanner.nextLine());
			}
			
			//Output writer
			File output = new File("knapsack.txt");
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
			System.out.println("The file containing tests was not found.");
			System.out.println("Please enter a file containing tests.");
		}

	}

}
