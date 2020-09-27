import java.util.ArrayList;

/** 
 * @author Jack Ambery
 * 
 *
 */

public class BigInteger {
	
	private static ArrayList<BigInteger> list = new ArrayList<>();
	
	public static ArrayList<BigInteger> fibbonaci(int n) {
		
		BigInteger sum = BigInteger.valueOf(0);
		
		for (long i = 1; i <= n; i++) {
			list.add(sum);
			sum = sum.add(BigInteger.valueOf(i));
		}
		
		return list;
	}
	
	/*
	public String fibonacci(int n) {
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		//int temp = 0;
		
		for (int i = 1; i <= n; i++) {
			//temp += n;
			//String tempString = Integer.toString(temp);
			
			//list.add(new BigInteger(tempString));
		}
		
		return list.toString();
	}
	*/
	
	public static void main(String[] args) {
		System.out.println(fibbonaci(100));
		//System.out.println(list.toString());

	}
}
