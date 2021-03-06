import java.math.BigInteger;

// An int version of GCD

public class gcd {

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger(args[0]);
		BigInteger b2 = new BigInteger(args[1]);
		System.out.println("The GCD of "+b1+" and "+b2+" is: ");
		System.out.println(euclid(b1,b2));
	}
	
	public static BigInteger euclid (BigInteger n, BigInteger m) {
		if(m.equals(BigInteger.ZERO)){
			return n;
		}
		else {
			return euclid(m, n.mod(m));
		}
	}

}
