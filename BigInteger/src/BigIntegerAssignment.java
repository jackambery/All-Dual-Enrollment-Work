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
	 * 
	 * @param n This is how many 
	 * @return
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
	
	
	public static void main(String[] args) {
		System.out.println(fibonacci(100));
	}
}
