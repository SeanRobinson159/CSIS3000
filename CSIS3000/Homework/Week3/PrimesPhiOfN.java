package Week3;

public class PrimesPhiOfN {

	public static void main(String[] args) {
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		for (int prime : primes) {
			System.out.println("n = " + prime + " Phi(n) = " + phiOf(prime));
		}
		System.out.println();

		for (int i = 0; i < primes.length; i++) {
			for (int j = 0; j < primes.length; j++) {
				int p = primes[i];
				int q = primes[j];
				if (p != q) {
					int phi = phiOf(p * q);
					int pMinusOne = p - 1;
					int qMinusOne = q - 1;
					System.out.println("phi(" + p + "*" + q + ") = " + phi + " => (" + pMinusOne + ")*(" + qMinusOne
							+ ") = " + pMinusOne * qMinusOne);
				}
			}
			System.out.println();
		}

	}

	public static int phiOf(int p) {
		int phi = 0;
		for (int j = 1; j < p; j++) {
			if (gcd(j, p) == 1) {
				phi++;
			}
		}
		return phi;
	}

	public static int gcd(int n, int m) {
		if (m == 0)
			return n;
		return gcd(m, n % m);
	}
}
