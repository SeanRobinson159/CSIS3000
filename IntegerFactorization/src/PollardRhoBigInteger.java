/**
 * 
 * @author Sean Robinson
 * @version April 14, 2015
 * Pollard Rho algorithm (BigInteger).
 *
 */

import java.math.BigInteger;

public class PollardRhoBigInteger {
	private int steps = 0;

	public static void main(String[] args) {
		PollardRhoBigInteger p = new PollardRhoBigInteger();
		double start = System.currentTimeMillis();
		BigInteger factor = p.factor(new BigInteger("10403")); 
		double end = System.currentTimeMillis();
		System.out.println("Factor: "+factor+"\nTime to Complete: "+(end-start)/1000+" s\nSteps: "+p.steps);
	}

	public BigInteger factor(BigInteger n){
		BigInteger xi = new BigInteger("2");
		BigInteger x2i = new BigInteger("2");
		BigInteger s = BigInteger.ONE;
		while(s.equals(BigInteger.ONE)){
			xi = f(xi).mod(n);
			x2i = f(f(x2i)).mod(n);
			s= gcd(xi.subtract(x2i).abs(), n);
			steps++;
		}
		return s;
	}
	
	private BigInteger f(BigInteger x){
		x = x.pow(2);
		return x.add(BigInteger.ONE);
		}
	
	private BigInteger gcd(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO))
			return n;
		return gcd(m, n.mod(m));

	}

}
