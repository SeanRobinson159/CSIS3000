import java.math.BigInteger;

public class PollardRhoBigInteger {

	public static void main(String[] args) {
		PollardRhoBigInteger p = new PollardRhoBigInteger();
		BigInteger factor = p.pollardRho(new BigInteger("897"));
		System.out.println(factor);
	}

	public BigInteger pollardRho(BigInteger n){
		BigInteger xi = new BigInteger("2");
		BigInteger x2i = new BigInteger("2");
		BigInteger s = BigInteger.ONE;
		while(s.equals(BigInteger.ONE)){
			xi = (xi.pow(2).add(BigInteger.ONE).mod(n));
			x2i = (x2i.pow(2).add(BigInteger.ONE));
			x2i = (x2i.pow(2).add(BigInteger.ONE).mod(n));
			s= gcd(xi.subtract(x2i).abs(), n);
		}
		return s;

	}
	public BigInteger gcd(BigInteger n, BigInteger m) {
		if (m.equals(0))
			return n;
		return gcd(m, n.mod(m));

	}

}
