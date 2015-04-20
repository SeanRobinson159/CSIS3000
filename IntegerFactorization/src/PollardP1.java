/**
 * 
 * @author Sean Robinson
 * @version April 18, 2015 Pollard p-1 algorithm.
 *
 */

public class PollardP1 {

	public static void main(String[] args) {
		PollardP1 p = new PollardP1();
		double start = System.currentTimeMillis();
		System.out.println(p.pminus1(5917, 5));
		// System.out.println(p.factor(5917));
		double end = System.currentTimeMillis();
		System.out.println("Time to Complete: " + (end - start) / 1000);
	}

	public int factor(int n) {
		int rk = 0;
		int two_k_factorial = 2;
		for (int k = 2; k < Integer.MAX_VALUE; k++) {
			two_k_factorial = (int) Math.pow(two_k_factorial, k) % n;
			rk = gcd(two_k_factorial - 1, n);
			if (rk != 1) {
				return rk;
			}
		}
		return 0;
	}

	public int pminus1(int n, int b) {
		int c = 2;
		for (int p = 2; p < b; p++) {
			int pp = p;
			while (pp < b) {
				c = (int) Math.pow(c, p) % n;
				pp = pp * p;
			}
		}
		int g = gcd(c - 1, n);
		if (1 < g && g < n) {
			return g;
		}
		return 0;
	}

	private int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}
}