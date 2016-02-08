package Week2;

public class Mod13 {

	public static void main(String[] args) {
		int x[] = { 22, 100, 1001, -1, -100, -1000, 200, 230 };

		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i] + " % 13 = " + Math.abs(x[i] % 13));
		}
	}
}
