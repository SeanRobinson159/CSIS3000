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
		BigInteger e;
		BigInteger d; // Private exponent

		do {
			p = randomPrime(301);
			q = randomPrime(300);

			System.out.println("p = " + p);
			System.out.println("q = " + q);
			n = multiply(p, q);
		} while (n.toString().length() != 600 && new Integer(n.toString().substring(0, 2)) < 355);
		System.out.println("n = " + n); // N needs to be exactly 600 digits!
		System.out.println("Length(n) = " + n.toString().length());

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

}
