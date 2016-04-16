//package Week3;
//
//import java.util.ArrayList;
//
//public class Euler {
//	public static void main(String[] args) {
//		int n, first, second;
//		int a = 20;
//		ArrayList<Double> coprimes = phiOf(a);
//
//		for (int i = 1; i < coprimes.size(); i++) {
//			n = coprimes.get(i);
//			int pn = phiOf(a).size();
//			first = (int)Math.pow(a, pn) % n;
//			second = 1 % n;
//
//			System.out.println("a^p(" + pn + ") mod " + n + " = " + first);
//			System.out.println("1 mod " + n + " = " + second);
//		}
//	}
//}
