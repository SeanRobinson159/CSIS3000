package Week1;

public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(8, 245349852));
	}

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}
}