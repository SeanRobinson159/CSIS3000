package Week7;

import java.math.BigInteger;
import java.util.Random;

class Rank {
	public static void main(String[] args) {
		int[] permutation = { 2,4,3,6,7,1,5 };
		int[] randomPermutation = getRandomPermutation(100);

		// Verify my answer for #5
		System.out.print("Rank of ");
		printArray(permutation);
		System.out.println(" = " + getRank(permutation));

		// Rank of a Random permutation of 100 things
		System.out.print("Rank of ");
		printArray(randomPermutation);
		System.out.println(" = " + getRank(randomPermutation));
		
		System.out.println(factorial(69).toString().length());
	}

	public static void printArray(int[] array) {
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("}");
	}

	public static BigInteger getRank(int[] permutation) {
		BigInteger rank = BigInteger.ZERO;
		for (int i = 0; i < permutation.length; i++) {
			int count = 0;
			for (int j = i + 1; j < permutation.length; j++) {
				if (permutation[j] < permutation[i]) {
					count++;
				}
			}
			BigInteger bigIntCount = BigInteger.valueOf(count);
			BigInteger bigIntFactorial = factorial((permutation.length - 1) - i);
			rank = rank.add(bigIntCount.multiply(bigIntFactorial));
		}
		return rank;
	}

	public static BigInteger factorial(int n) {
		if (n < 2)
			return BigInteger.ONE;
		return BigInteger.valueOf(n).multiply(factorial(n - 1));
	}

	// http://stackoverflow.com/questions/6946789/generating-random-permutation-uniformly-in-java
	public static int[] getRandomPermutation(int length) {

		// initialize array and fill it with {0,1,2...}
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++)
			array[i] = i+1;
		Random r = new Random();

//		for (int i = 0; i < length; i++) {
//
//			// randomly chosen position in array whose element
//			// will be swapped with the element in position i
//			// note that when i = 0, any position can chosen (0 thru length-1)
//			// when i = 1, only positions 1 through length -1
//			// NOTE: r is an instance of java.util.Random
//			int ran = i + r.nextInt(length - i);
//
//			// perform swap
//			int temp = array[i];
//			array[i] = array[ran];
//			array[ran] = temp;
//		}
		return array;
	}

}
