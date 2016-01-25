//Slow exponentiation
//Complexity: linear in the exponent.

package Week4;
import java.math.*;

public class SlowExponentiation {

	public static void main(String[] args) {
		BigInteger a = new BigInteger("1234567");
		BigInteger prod = BigInteger.ONE;
		BigInteger m = new BigInteger("12345");
		int b = 123456789;
		
		// Compute a^b mod m
		for(int i = 1; i <= b; i++){
			prod = prod.multiply(a);
			prod = prod.mod(m);
		}
		
		System.out.println(a + "^" + b + " = " + prod + " mod " + m);
	}

}
