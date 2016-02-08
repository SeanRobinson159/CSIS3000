package Week2;

public class LeastPositiveResidue {

	public static void main(String[] args) {
		double x[] = { Math.pow(3, 10), Math.pow(2, 12), Math.pow(5, 16), Math.pow(3, 22) };

		System.out.println("3^10 % 11 = " + x[0] % 11);
		System.out.println("2^12 % 13 = " + x[1] % 13);
		System.out.println("5^16 % 17 = " + x[2] % 17);
		System.out.println("3^22 % 23 = " + x[3] % 23);
	}
}
