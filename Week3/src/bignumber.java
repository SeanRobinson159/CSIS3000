public class bignumber {

	public static void main(String[] args) {

		test(123456789);
		test(1234567890);
		test(12345678901L);

	}

	public static void test(long pow) {
		double start, stop;
		long n = 123456789;
		long mod = 987654321;
		long x = n;
		start = System.currentTimeMillis();

		for (int i = 1; i < pow; i++) {
			x = x * n % mod;
		}
		stop = System.currentTimeMillis();
		System.out.println(n+"^"+pow+" mod("+mod+") = "+ x + "\nTime: " + (stop - start) / 1000);
	}

}
