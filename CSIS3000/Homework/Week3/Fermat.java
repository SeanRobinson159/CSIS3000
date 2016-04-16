//package Week3;
//
//import java.util.ArrayList;
//
//public class Fermat {
//
//	public static void main(String[] args) {
//		int p, first, second;
//		int a = 7;
//		ArrayList<Double> coprime = phiOf(a);
//
//		for (int i = 1; i < coprime.size(); i++) {
//			p = coprimes.get(i);
//
//			first = Math.pow(a, p) % p;
//			second = a % p;
//
//			System.out.println(a + "^(" + p + ") mod " + p + " = " + first);
//			System.out.println(a + " mod " + p + " = " + second);
//		}
//	}
//	
//	public static int phiOf(int p) {
//		int phi = 0;
//		for (int j = 1; j < p; j++) {
//			if (gcd(j, p) == 1) {
//				phi++;
//			}
//		}
//		return phi;
//	}
//	
//	public static int gcd(int n, int m) {
//		if (m == 0)
//			return n;
//		return gcd(m, n % m);
//	}
//
//}
