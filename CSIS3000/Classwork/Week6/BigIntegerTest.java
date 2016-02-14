package Week6;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger one = BigInteger.ONE;
		BigInteger p;
		BigInteger q;
		BigInteger n;
		BigInteger phiOfN;
		BigInteger e = new BigInteger("65537");
		BigInteger d; // Private exponent

		int firstThree = 0;
		int lengthOfN = 0;
		do {
			p = randomPrime(301);
			q = randomPrime(300);
			n = multiply(p, q);
			firstThree = new Integer(n.toString().substring(0, 3));
			lengthOfN = n.toString().length();
		} while (lengthOfN != 600 && firstThree < 355); // N needs to be exactly
														// 600 decimal digits,
														// and has to be larger
														// than 355...
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("n = " + n); // N needs to be exactly 600 digits!
		System.out.println("Length(n) = " + lengthOfN);
		System.out.println("FirstThree = " + firstThree);
		
	}

	public static BigInteger multiply(BigInteger a, BigInteger b) {
		return a.multiply(b);
	}

	private static BigInteger randomBigInteger(int numberOfDigits) {
		Random random = new Random();
		// if we know the number of decimal digits, how many bits are required?
		int length = (int) (3.32 * (double) numberOfDigits);
		return new BigInteger(length, random);
	}

	public static BigInteger randomPrime(int numberOfDigits) {
		BigInteger randomBigInt = randomBigInteger(numberOfDigits);
		return randomBigInt.nextProbablePrime();
	}
	
	public static BigInteger euclid(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO)) {
			return n;
		} else {
			return euclid(m.abs(), n.abs().mod(m.abs()));
		}
	}

}
