/**
 * 
 * @author Sean Robinson
 * @version April 14, 2015
 * Pollard Rho algorithm.
 *
 */

public class PollardRho {
	private final int c = 1;

	public static void main(String[] args) {
		PollardRho p = new PollardRho();
		int factor = p.factor(10403);
		System.out.println(factor);
	}

	public int factor(int n) {
		int xi = 2;
		int x2i = 2;
		int d = 1;

		while (d == 1) {
			xi = f(xi) % n;
			x2i = f(f(x2i)) % n;
			d = gcd(Math.abs(xi - x2i), n);
//			System.out.println(xi + "\t" + x2i % n + "\t"+ Math.abs(xi - x2i) + "\t" + d);
		}
		return d;
	}

	private int f(int x) {
		return (int)Math.pow(x, 2) + c;
	}

	private int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

}
