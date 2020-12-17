import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
	
	//fields
	private int[] w;
	private int n;
	private List<Integer> list;
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
		int[] testArray = {67, 17, 5, 3, 24};
		List<Integer> testList = new ArrayList<Integer>();
		System.out.println(Integer.toString(knapsackSum(testArray, testArray.length - 1, 26, testList)));
		System.out.println(testList);

		
	}

}
