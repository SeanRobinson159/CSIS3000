package Week3;

import java.math.BigInteger;

public class FermatRatio {
	public static void main(String[] args) {
		fermat();
	}

	public static void fermat() {
		for (int n = 5; n < 1000; n++) {
			double primes = 0;
			for (int a = 1; a < n; a++) {
				if (checkPrime(BigInteger.valueOf(a), BigInteger.valueOf(n)))
					primes++;
			}
			if (primes / (n - 1) > 0.5)
				System.out.println(n + ": " + (primes / (n - 1)));
		}
	}

	public static boolean checkPrime(BigInteger a, BigInteger n) {
		a = a.modPow(n.subtract(BigInteger.ONE), n);

		if (!a.equals(BigInteger.ONE))
			return false;

		return true;
	}
}
