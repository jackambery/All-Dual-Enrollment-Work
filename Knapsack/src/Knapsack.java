import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
	
	//fields
	//private static int[] w;
	//private static int n = w.length;
	//private static int limit;
	
	//private static List<Integer> list;

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
	
	public static int knapsackSum(int[] w, int n, int limit, List<Integer> list) {
		int total1 = 0;
		int total2 = 0;
		int i = 0;
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		while (i < w.length) {
			if (n < 0 || limit == 0) {
				return 0;
			}
			if (w[i] >= limit) {
				listA.add(w[i]);
				total1 = knapsackSum(w, n - 1, limit, list);
			}
			else {
				listA.clear();
				total1 = 0;
			}
			if (w[i] <= limit) {
				listB.add(w[i]);
				total2 = knapsackSum(w, n - 1, limit - w[i], list) + w[i];
			}
			else {
				listB.clear();
				total2 = 0;
			}
			i++;
		}
		
		if (max(total1, total2) == total1) {
			list.addAll(listA);
		}
		else if (max(total1, total2) == total2){
			list.addAll(listB);
		}
		
		return max(total1, total2);
	}
	
	
//	//IN CLASS WAY
//	public static int knapsackSum(int[] w, int n, int limit) {
//		int total1 = 0;
//		int total2 = 0;
//		int i = 0;
//		n = w.length - 1;
//		while (i < n) {
//			if (n < 0 || limit == 0) {
//				return 0;
//			}
//			if (w[i] > limit) {
//				i++;
//				total1 = knapsackSum(w, n, limit - w[i]) + w[i];
//			}
//			else {
//				total1 = 0;
//			}
//			if (w[i] < limit) {
//				i++;
//				total2 = knapsackSum(w, n, limit - w[i + 1]) + w[i + 1];
//			}
//			else {
//				total2 = 0;
//			}
//			//i++;
//		}
//		
//		return max(total1, total2);
//	}
	
	
	public static void main(String[] args) {
		
		File tests = new File("tests");
		Scanner testScanner;
		try {
			
			testScanner = new Scanner(tests);
			ArrayList<String> testFiles = new ArrayList<String>();
			while(testScanner.hasNextLine()) {
				testFiles.add(testScanner.nextLine());
			}
			
			for (String s : testFiles) {
				try {
					//creates file for each line in tests
					File file = new File(s);
					Scanner inputScanner = new Scanner(file);
					ArrayList<Integer> nums = new ArrayList<Integer>(); //list of all numbers in test files
					
					while(inputScanner.hasNextLine()) {
						nums.add(Integer.parseInt(inputScanner.nextLine()));
					}
					
					int[] w = new int[nums.size()];
					int limit = nums.get(0);
					
					System.out.print(file.getName() + "	" + limit + "	" + w);
					for (int i = 1; i < nums.size(); i++) {
						w[i] = nums.get(i);
						//System.out.print(nums.get(i) + ", ");
					}
					System.out.println();
					
					//-------------------------------------------------------------------------
					//int[] w = {28, 3, 4, 6, 1};
					int n = w.length - 1;
					//limit = 40;
					list = new ArrayList<Integer>();
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
