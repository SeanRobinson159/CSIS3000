package Week2;

import java.util.Vector;

public class GroupOfUnits {

	public static void main(String[] args) {
		for (int i = 5; i <= 100; i++) {
			Vector<Integer> v = new Vector<Integer>();
			int phi = 0;
			for (int j = 1; j < i; j++) {
				if (gcd(j, i) == 1) {
					v.addElement(j);
					phi++;
				}
			}

			System.out.print("n = " + i + " GroupOfUnitsMod " + i + " = { ");
			for (int k = 0; k < v.size(); k++) {
				System.out.print(v.get(k) + " ");
			}
			System.out.println("} \nPhi =  " + phi);
		}
	}

	public static int gcd(int n, int m) {
		if (m == 0)
			return n;
		return gcd(m, n % m);
	}

}