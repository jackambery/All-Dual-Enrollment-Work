import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Knapsack {

	public static int max(int i, int k) {
		if (i > k) {
			return i;
		}
		return k;
	}
	
	//w is all melons
	//n is number of melons allowed
	//limit is max weight allowed
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
	
	
//	
	//	
	public static int knapsackSum(int[] w, int n, int limit, ArrayList<Integer> list) {
		int total1 = 0;
		int total2 = 0;
		int i = 0;
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
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
					
					//-------------------------------------------------------------------------
					
					//filename, limit, and melons(w)
					System.out.println(file.getName() + "	" + limit + "	" + Arrays.toString(w));
					
					//knapsack solution
					System.out.println(Integer.toString(knapsackSum(w, n, limit, list)));
					System.out.println(list);
					
					inputScanner.close();
				}
				catch (FileNotFoundException e) { 
					System.out.println("Invalid File");
					
				}
			}
			testScanner.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Invalid File");
		}

	}

}
