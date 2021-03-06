// Using a BitSet to demonstrate the Sieve of Erotosthenes

import java.util.*;

public class Eratosthenes {
	public static void main(String[] args) {
		BitSet sieve = new BitSet(1024);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		int last = (int) Math.sqrt(size);

		for (int i = 2; i < size; i++) {
			sieve.set(i, true);
		}
		for (int i = 2; i <= last; i++){
			if(sieve.get(i)){
				for(int j = 2*i; j < size; j+= i){
					sieve.clear(j);
				}
			}
		}
		
		for(int i = 1; i < size; i++){
			if(sieve.get(i)){
				primes.add(i);
			}
		}
		
		for(Integer p : primes) {
			System.out.println(p);
		}

	}

}
