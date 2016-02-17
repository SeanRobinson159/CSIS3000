/*
 * Random permutation of a set of n things
 * 1. Use the conoical set {1,2,...,n}
 * 2. Starting with the first element and stepping 
 *    to the last choose a random index between 0 
 *    and n-1 and to a swap.
 */

package Week7;

public class randPermutation {

	public static void main(String[] args) {
		int n = 100;
		int[] iArray = randPerm(n);
		int i;

		System.out.print("{");
		for (i = 0; i < iArray.length - 1; i++) {
			System.out.print(iArray[i] + " ");
		}
		System.out.print(iArray[i] + "}");

	}

	public static int[] randPerm(int n) {
		int[] p = new int[n];
		int j, k;

		for (int i = 0; i < n; i++) {
			p[i] = i + 1;
		}

		for (j = 0; j < n; j++) {
			k = (int) (Math.random() * n);
			p = swap(p, j, k);
		}

		return p;
	}

	public static int[] swap(int[] iArray, int indexA, int indexB) {
		int temp = iArray[indexA];

		iArray[indexA] = iArray[indexB];
		iArray[indexB] = temp;

		return iArray;
	}

}
