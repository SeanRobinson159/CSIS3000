import java.math.BigInteger;
import java.util.Random;

public class week1_5 {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			test();
		}
	}

	public static void test() {
		byte[] array = new byte[64];
		Random r = new Random();
		r.nextBytes(array);
		BigInteger randomBigNumber = new BigInteger(array);
		randomBigNumber = randomBigNumber.abs();
		System.out.println("The GCD of 512 and " + randomBigNumber + " is: ");
		System.out.println(euclid(new BigInteger("512"), randomBigNumber));
	}

	public static BigInteger euclid(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO)) {
			return n;
		} else {
			return euclid(m.abs(), n.abs().mod(m.abs()));
		}
	}

}
