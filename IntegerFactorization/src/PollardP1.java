/**
 * 
 * @author Sean Robinson
 * @version April 18, 2015 Pollard p-1 algorithm.
 *
 */

public class PollardP1 {

	public static void main(String[] args) {
		PollardP1 p = new PollardP1();
		double start = System.currentTimeMillis();
		//System.out.println(p.pminus1(21238));
		System.out.println(p.factor(29));
		double end = System.currentTimeMillis();
		System.out.println("Time to Complete: " + (end - start) / 1000);
	}

	public int factor(int n) {
		int rk = 0;
		int two_k_factorial = 3;
		for (int k = 3; k < Integer.MAX_VALUE; k++) {
			two_k_factorial = (int) Math.pow(two_k_factorial, k) % n;
			rk = gcd(two_k_factorial - 1, n);
			System.out.println(rk);
			if (rk != 1) {
				return rk;
			}
		}
		return 0;
	}

	private int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

	public int pminus1(int n) {
		int c = 2;
		for (int p = 2; p < n; p++) {
			int pp = p;
			while (pp < n) {
				c = (int) Math.pow(c, p) % n;
				pp = pp * p;
			}
		}
		int g = gcd(c - 1, n);
		if (1 < g && g < n) {
			return g;
		}
		return 0;
	}
	
	//Pollard p-1 factorization-runs until a factor is found
//	   public static BigInteger pMinusOneFactor(BigInteger n) throws IllegalArgumentException {
//	      Random rand=new Random();
//	      BigInteger power=BigInteger.valueOf(1);
//	      BigInteger residue=lnr(BigInteger.valueOf(rand.nextInt()),n);
//	      BigInteger test=residue.subtract(BigInteger.ONE);
//	      BigInteger gcd=test.gcd(n);
//	      while (true) {
//	         while (gcd.equals(BigInteger.ONE)) {
//	            power=power.add(BigInteger.ONE);
//	            residue=residue.modPow(power,n);
//	            test=residue.subtract(BigInteger.ONE);
//	            gcd=test.gcd(n);
//	         }
//	         if (gcd.equals(n)) {
//	            power=BigInteger.valueOf(1);
//	            residue=lnr(BigInteger.valueOf(rand.nextInt()),n);
//	            test=residue.subtract(BigInteger.ONE);
//	            gcd=test.gcd(n);
//	         } else return gcd;
//	      }
//	   }
	
	
}