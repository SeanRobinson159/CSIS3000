import java.util.ArrayList;

public class week03_1 {
	private static ArrayList<Integer> elements;
	private static ArrayList<Integer> order;
	private static ArrayList<Integer> inverse;
	private static ArrayList<Integer> fermat;

	private static int phi;
	private static int o;

	public static void main(String[] args) {
		group(7);
		group(11);
		group(15);
	}

	public static void setup() {
		elements = new ArrayList<Integer>();
		order = new ArrayList<Integer>();
		inverse = new ArrayList<Integer>();
		fermat = new ArrayList<Integer>();

		phi = 0;
		o = 1;
	}

	public static void group(int n) {
		setup();
		elementsAndOrder(n);
		inverse(n);
		fermat(n);

		System.out.println("n = " + n + "\n" + elements.toString()
				+ " Elements");
		System.out.println(inverse.toString() + " Inverse");
		System.out.println(order.toString() + " Order");
		System.out.println(fermat.toString() + " Fermat's Theorem");

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

	public static void fermat(int n) {
		for (int i = 0; i < phi; i++) {
			int a = elements.get(i);
			for (int j = 1; j < n - 1; j++) {
				a = a * elements.get(i) % n;
			}
			fermat.add(a);
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
