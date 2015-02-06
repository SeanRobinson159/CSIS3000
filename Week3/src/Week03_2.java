public class Week03_2 {

	public static void main(String[] args) {
		int primes = 0;
		int composits = 0;
		for (int i = 2; i <= 1000; i++) {
			long mod = 0;
			mod = (long) (Math.pow(2, i - 1) % i);
			if (mod == 1 % i) {
				primes++;
				System.out.println(i);
			} else {
				composits++;
			}
		}
		System.out.println("Primes: " + primes);
		System.out.println("Composits: " + composits);
	}

}
