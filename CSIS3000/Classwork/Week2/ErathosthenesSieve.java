package Week2;

import java.util.*;

public class ErathosthenesSieve {

	public static void main(String[] args) {
		BitSet sieve = new BitSet(8192);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		int last = (int) Math.sqrt(size);

		sieve.set(2, size, true); // Set all of them to true

		for (int i = 2; i <= last; i++) {
			if (sieve.get(i)) {
				for (int j = 2 * i; j < size; j += i) {
					sieve.clear(j);
				}
			}
		}
		
		for (int i = 2; i < size; i++){
			if (sieve.get(i)){
				primes.add(i);
			}
		}
		
		System.out.println(sieve.toString());

	}

}