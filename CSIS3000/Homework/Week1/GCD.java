package Week1;

public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(566, 230498232));
	}

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}
}
