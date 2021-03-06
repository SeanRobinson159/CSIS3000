import java.math.*;
import java.util.*;

public class BigIntegerTest {

	public static void main(String[] args) {
		Random r = new Random();

		BigInteger a = new BigInteger(8, r);
		BigInteger b = new BigInteger(8, r);
		BigInteger n = new BigInteger(8, r);

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("n = " + n);

		System.out.println("Binary string for a: "+a.toString(2));
		System.out.println("Bitlenght for a: "+a.bitLength());
		System.out.println("GCD of a and b = "+a.gcd(b));
		
		// Other userful commands: mod inverse, nextProbablePrime, modPow

		
		
	}
}
