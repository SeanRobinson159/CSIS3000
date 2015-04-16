/**
 * 
 * @author Sean Robinson
 * @version 04/08/2015 Integer Factorization: Pollard Rho and Pollard p-1
 *          algorithms
 *
 */
public class PollardFactorization {

	public static void main(String[] args) {
		pollardRho(137);
		//115792089237316195423570985008687907853269984665640564039457584007913129639937
	}

	public static void pollardRho(int n) {
		int x_fixed =2;
		int cycle_size = 2;
		int x = 2;
		int h = 1;
		int step = 0;

		System.out.println("x\t\tx_fixed\t\th\t\tstep\n");
		while (h == 1) {
			int count = 1;

			while (count <= cycle_size && h == 1) {
				x = g(x, n);
				count++;
				h = Math.abs(gcd(x - x_fixed, n));
				System.out.println(x + "\t\t" + x_fixed + "\t\t" + h + "\t\t"
						+ step);
				step++;
			}

			if (h != 1) {
				break;
			}
			cycle_size = 2 * cycle_size;
			x_fixed = x;
		}
		System.out.println("Factors of " + n + " is: " + h + " • "
				+ ((int) n / h));
	}

	public static void pollardP_1(int n){
		int a = 2;
		for(int i = 2; i < 200; i++){
			a = (int)Math.pow(a, i) % n;
//			if((g == gcd(a-1, n)) > 1){
//				System.out.println("g divides n");
//				break;
//			}
		}
		System.out.println("Fail");
	}
	
	public static int g(int x, int n) {
		return (x * x + 1) % n;
	}

	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

}
