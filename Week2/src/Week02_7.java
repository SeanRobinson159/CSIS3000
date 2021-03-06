import java.util.Vector;

//Use gcd to find and print the group of units modulo n for n = 5 to 100.  Print them out in this format:
//Ex. n = 8: GroupOfUnitsMod 8 = {1,3,5,7}.  Also include the number of elements.  (This equals phi(n)).

public class Week02_7 {

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
		if (m == 0) {
			return n;
		} else {
			return gcd(m, n % m);
		}
	}

}
