package Week4;

import java.util.*;

public class pseudoPrime {

	public static void main(String[] args) {
		int listSize = 100000;
		int count = 0;
		ArrayList<Integer> primes = primeList(listSize);

		// Show that if 2 ^ (n-1) does not equal 1 mod n, then n is composite.
		// ALWAYS.
		for (int n = 3; n < listSize; n++) {
			if (modexp(2, n - 1, n) != 1) {
				if (primes.contains(n)) {
					count++;
				}
			}
		}
		System.out.println("If 2^(n-1) does NOT equal 1 mod n, then n is prime exactly " + count + " times.");

		// If 2^(n-1) = 1 mod n then n is usually prime. How often?
		count = 0;
		for (int n = 3; n <= listSize; n++) {
			if (modexp(2, n - 1, n) == 1) {
				if (!primes.contains(n)) {
					count++;
				}
			}
		}
		System.out.println("if 2^(n-1) DOES equal 1 mod n, then n is NOT prime exactly " + count + " times.");
		System.out.println("That's a probability of about " + ((double) count / (double) listSize) * 100 + "%");
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}

	public static ArrayList<Integer> primeList(int n) {
		BitSet sieve = new BitSet(n);
		ArrayList<Integer> primes = new ArrayList<Integer>();
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
			if (sieve.get(i))
				primes.add(i);
		}
		return primes;
	}

	public static int modexp(int a, int b, int n) {
		int d = 1;
		String bin = Integer.toBinaryString(b);
		for (int i = 0; i < bin.length(); i++) {
			d = (d * d) % n;
			if (bin.charAt(i) == '1') {
				d = (d * a) % n;
			}
		}
		if (d < 0)
			d += n;

		return d;
	}

}
