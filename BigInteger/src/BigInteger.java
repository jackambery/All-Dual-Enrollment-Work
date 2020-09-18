import java.util.ArrayList;

/** 
 * @author Jack Ambery
 * 
 *
 */

public class BigInteger {
	
	public String fibonacci(int n) {
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		int temp = 0;
		
		for (int i = 1; i <= n; i++) {
			temp += n;
			String tempString = Integer.toString(temp);
			
			list.add(new BigInteger(tempString));
		}
		
		return list.toString();
	}
}
