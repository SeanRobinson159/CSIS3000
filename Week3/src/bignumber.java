public class bignumber {

	public static void main(String[] args) {

		long x = 123;
		for (int i = 1; i < 456; i++) {
			x *= 123;
			x = x % 789;
		}
		System.out.println("123^456 % 789 = "+x);
	}

}
