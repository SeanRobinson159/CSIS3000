package Week4;

/*
 * Write a BigInteger version of the fast pseudoprime test.  Using n = 10^300 +/- 10,000, 
 * determine the probability of a 300 digit number being prime 
 * (this can also be calculated using the Prime Number Theorem).
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

public class BigIntegerPseudoPrime {

	public static void main(String[] args) {
		BigInteger listSize = BigInteger.valueOf((int) Math.pow(10, 300));
		int count = 0;
		ArrayList<BigInteger> primes = primeList(listSize);
		BigInteger two = BigInteger.valueOf(2);

		// Show that if 2 ^ (n-1) does not equal 1 mod n, then n is composite.
		// ALWAYS.
		for (long n = 3; n < listSize.longValue(); n++) {
			if (modexp(two, BigInteger.valueOf(n - 1), BigInteger.valueOf(n)) != BigInteger.ONE) {
				if (primes.contains(n)) {
					count++;
				}
			}
		}
		System.out.println("If 2^(n-1) does NOT equal 1 mod n, then n is prime exactly " + count + " times.");

		// If 2^(n-1) = 1 mod n then n is usually prime. How often?
		count = 0;
		for (long n = 3; n <= listSize.longValue(); n++) {
			if (modexp(two, BigInteger.valueOf(n - 1), BigInteger.valueOf(n)) == BigInteger.ONE) {
				if (!primes.contains(n)) {
					count++;
				}
			}
		}
		System.out.println("if 2^(n-1) DOES equal 1 mod n, then n is NOT prime exactly " + count + " times.");
		System.out.println("That's a probability of about " + ((double) count / listSize.longValue()) * 100 + "%");
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}

	public static ArrayList<BigInteger> primeList(BigInteger n) {
		BitSet sieve = n.bit;
		ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
		int last = (int) Math.sqrt(n);

		sieve.set(2, n, true); // Set all of them to true

		for (int i = 2; i <= last; i++) {
			if (sieve.get(i)) {
				for (int j = 2 * i; j < n; j += i) {
					sieve.clear(j);
				}
			}
		}

		for (int i = 2; i < n; i++) {
			if (sieve.get(i)) {
				BigInteger a = BigInteger.valueOf(i);
				primes.add(a);
			}
		}
		return primes;
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
