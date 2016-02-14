package Week5;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerTests {

	public static void main(String[] args) {
		BigInteger p = new BigInteger(1024, 100, new Random());
		BigInteger a = new BigInteger(1024, new Random());
		BigInteger b = new BigInteger(1024, new Random());
		BigInteger n = new BigInteger(1024, new Random());

		System.out.println("A + B = " + a.add(b));
		System.out.println("A * B = " + a.multiply(b));
		System.out.println("Bitlength of N = " + n.bitLength());
		System.out.println("Max of A and B = " + a.max(b));
		System.out.println("A / B = " + a.divide(b));
		System.out.println("GCD(A,B) = " + a.gcd(b));
		System.out.println("P probably prime? " + p.isProbablePrime(100));
		System.out.println("A Mod N = " + a.mod(n));
		System.out.println("A^-1 mod P = " + a.modInverse(p));
		System.out.println("A^B mod n = " + a.modPow(b, n));
		System.out.println("A*B mod n = " + a.multiply(b).mod(n));
		System.out.println("Next prime after P = " + p.nextProbablePrime());
		BigInteger q = BigInteger.probablePrime(1024, new Random());
		System.out.println("Q = " + q);
	}

}
