public class PollardRho2 {

	public static void main(String[] args) {
		PollardRho2 p = new PollardRho2();
		System.out.println(p.pollardRho(Integer.MAX_VALUE));

	}

	public int pollardRho(int n) {
		int xi = 2;
		int x2i = 2;
		int s;
		
		for (int i = 0; i < n; i++) {
			// Find x(i+1) and x(2*(i+1))
			int xiPrime = (int) Math.pow(xi, 2) + 1;
			int x2iPrime = (int) Math.pow(Math.pow(x2i, 2) + 1, 2) + 1;
			// Increment i: change our running values for x(i), x(2*i)
			xi = xiPrime % n;
			x2i = x2iPrime % n;
			s = gcd(Math.abs(xi - x2i), n);
			if (s != 1 && s != n) {
				return s;
			}
		}
		return 0;
	}

	public int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}
}
