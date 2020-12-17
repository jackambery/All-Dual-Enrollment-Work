import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {
	
	//fields
	private int[] w;
	private int n;
	private ArrayList<Integer> list;
	private int limit;
	
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
		if (w[n] >= limit) {
			total1 = knapsackSum(w, n--, limit);
		}
		else {
			total1 = 0;
		}
		if (w[n] < limit) {
			total2 = knapsackSum(w, n--, limit - w[n]) + w[n];
		}
		else {
			total2 = 0;
		}
		return max(total1, total2);
	}
	
	
	public static void main(String[] args) {
		
		File testFolder = new File("tests");
		File[] testFiles = testFolder.listFiles();
		for (File file : testFiles) {
			try {
				Scanner inputScanner = new Scanner(file);
				ArrayList<Integer> nums = new ArrayList<Integer>();
				while(inputScanner.hasNextLine()) {
					nums.add(Integer.parseInt(inputScanner.nextLine()));
				}
				System.out.print(file.getName() + "	" + nums.get(0) + "	");
				for (int i = 1; i < nums.size(); i++) {
					System.out.print(nums.get(i) + ", ");
				}
				System.out.println();
				
				inputScanner.close();
			}
			catch (FileNotFoundException e) { 
				System.out.println("Invalid File");
				
			}
		}
		int[] testArray = {2, 17, 5, 3};
		System.out.println("TESTTESTTEST");
		System.out.println(Integer.toString(knapsackSum(testArray, 3, 6)));
		
	}

}
