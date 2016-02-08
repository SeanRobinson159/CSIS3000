package Week2;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerEuclidAlgorithm {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			test();
		}
	}

	public static void test() {
		BigInteger randomBigNumber1 = getRandom();
		BigInteger randomBigNumber2 = getRandom();
		randomBigNumber1 = randomBigNumber1.abs();
		randomBigNumber2 = randomBigNumber2.abs();

		System.out.println("The GCD of " + randomBigNumber1 + " and " + randomBigNumber2 + " is: ");
		System.out.println(euclid(randomBigNumber1, randomBigNumber2));
	}

	public static BigInteger euclid(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO)) {
			return n;
		} else {
			return euclid(m.abs(), n.abs().mod(m.abs()));
		}
	}

	public static BigInteger getRandom() {
		byte[] array = new byte[64];
		Random r = new Random();
		r.nextBytes(array);
		BigInteger randomBigNumber = new BigInteger(array);
		return randomBigNumber;
	}

}