package Week4;

import java.math.BigInteger;
import java.util.Random;

public class ModularExponentiation {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			BigInteger base = new BigInteger(1024, new Random());
			BigInteger exponent = new BigInteger(1024, new Random());
			BigInteger modulus = new BigInteger(1024, new Random());
			System.out.println("base = " + base);
			System.out.println("exponent = " + exponent);
			System.out.println("modulus = " + modulus);

			System.out.println("base^exponent % modulus = " + modexp(base, exponent, modulus));
			System.out.println();
		}
	}

	public static BigInteger modexp(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger d = BigInteger.ONE;
		String binary = b.toString(2);

		for (int i = 0; i < binary.length(); i++) {
			d = d.multiply(d).mod(n);
			if (binary.charAt(i) == '1') {
				d = d.multiply(a).mod(n);
			}
		}
		return d;
	}

}