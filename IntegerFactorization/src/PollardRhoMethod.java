public class PollardRhoMethod {
	private final int c = 1;

	public static void main(String[] args) {
		PollardRhoMethod p = new PollardRhoMethod();
		int factor = p.pollardRhoMethod(137);
		System.out.println(factor);
	}

	public int pollardRhoMethod(int n) {
		int x = 2;
		int y = x;
		int d = 1;

		while (d == 1) {
			x = f(x, n) % n;
			y = f(f(y, n), n) % n;
			d = gcd(Math.abs(x - y), n);
			System.out.println("X: " + x + "\tY: " + y % n + "\t|X-Y|: "+Math.abs(x-y)+"\tD: " + d);
		}
		return d;
	}

	public int f(int x, int n) {
		return (int) (Math.pow(x, 2) + c % n);
	}

	public int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

}
