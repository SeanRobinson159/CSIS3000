package Week2;

import java.util.*;

public class ErathosthenesesPrimes {
	public static void main(String[] args) {
		int N = 100;

		long startTime = System.nanoTime();
		System.out.println(checkIt(N));
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println("It took " + duration / 1000000 + "ms to complete.");
	}

	public static int checkIt(int N) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i <= N; i++) {
			if (isPrime(i))
				primes.add(i);
		}
		return primes.size();
	}

	public static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
