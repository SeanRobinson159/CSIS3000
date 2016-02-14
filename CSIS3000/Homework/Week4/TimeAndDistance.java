package Week4;

import java.math.*;

public class TimeAndDistance {

	public static void main(String[] args) {
		BigInteger ten = new BigInteger("10");
		BigInteger power = new BigInteger("596");
		BigInteger year = new BigInteger("31557600");

		System.out.println("10^596 seconds = " + ten.modPow(power, year) + " years.");

		// size of proton = 0.8418±0.0007 fm. A femtometer is 10^-15 meters.
		// diameter of universe = 8.8×10^26 m

		BigDecimal proton = new BigDecimal("0.0000000000000008418");

		BigDecimal universe = new BigDecimal("880000000000000000000000000");

		System.out.println("Size difference: proton and universe = " + universe.divideToIntegralValue(proton) + " meters");

	}

}
