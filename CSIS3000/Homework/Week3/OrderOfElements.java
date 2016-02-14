package Week3;

import java.util.ArrayList;

public class OrderOfElements {
	private static ArrayList<Integer> elements;
	private static ArrayList<Integer> order;
	private static ArrayList<Integer> inverse;

	private static int phi;
	private static int o;

	public static void main(String[] args) {
		group(7);
		group(11);
		group(15);
		group(24);
	}

	public static void setup() {
		elements = new ArrayList<Integer>();
		order = new ArrayList<Integer>();
		inverse = new ArrayList<Integer>();

		phi = 0;
		o = 1;
	}

	public static void group(int n) {
		setup();
		elementsAndOrder(n);
		inverse(n);

		System.out.println("n = " + n + "\n" + elements.toString() + " Elements");
		System.out.println(order.toString() + " Order");
		System.out.println(inverse.toString() + " Inverse");

	}

	public static void elementsAndOrder(int n) {
		for (int i = 1; i < n; i++) {
			if (gcd(i, n) == 1) {
				elements.add(i);
				phi++;
				int gen = i;
				while (gen != 1) {
					gen = gen * i % n;
					o++;
				}
				order.add(o);
				o = 1;
			}
		}
	}

	public static void inverse(int n) {
		for (int i = 0; i < phi; i++) {
			inverse.add((int) (Math.pow(elements.get(i), order.get(i) - 1) % n));
		}
	}

	public static int gcd(int n, int m) {
		if (m == 0) {
			return n;
		} else {
			return gcd(m, n % m);
		}
	}

}
