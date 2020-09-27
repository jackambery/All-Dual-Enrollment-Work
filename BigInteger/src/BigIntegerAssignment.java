import java.util.ArrayList;
import java.math.BigInteger;

/** 
 * @author Jack Ambery
 * 
 *
 */

public class BigIntegerAssignment {
	
	private static ArrayList<BigInteger> list = new ArrayList<>();
	
	/**
	 * This method creates and returns an ArrayList of the first n fibonacci numbers
	 * 
	 * @param n This is how many numbers user wants in final array
	 * @return returns ArrayList of n fibonacci numbers
	 */
	public static ArrayList<BigInteger> fibonacci(int n) {
				
		for (int i = 0; i <= n; i++) {
			
			if (i <= 1) {
				list.add(BigInteger.valueOf(i));
			}
			
			else {   //adds previous two numbers and adds sum to array
				BigInteger temp1 = list.get(i-2);
				BigInteger temp2 = list.get(i-1);
				BigInteger sum = temp1.add(temp2);
				list.add(sum);	
			}
		}
		
		return list;
	}
	
	/**
	 * This is the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(100));
	}
}
