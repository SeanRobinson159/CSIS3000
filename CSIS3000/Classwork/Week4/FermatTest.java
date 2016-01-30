package Week4;

public class FermatTest {

	public static void main(String[] args) {
		int n = 71;
		int m = 72;
		int x;
		int y;
		
		for (int i = 1; i < 71; i++){
			x = modexp(i, 70, 71);
			y = modexp(i, 71, 72);
			System.out.println(i + "\t" + x + "\t" + y);
		}
	}
	
	public static int modexp(int a, int b, int n) {
		int d = 1;
		String bin = Integer.toBinaryString(b);
//		System.out.println(bin);
		for (int i = 0; i < bin.length(); i++) {
			d = (d * d) % n;
			if (bin.charAt(i) == '1') {
				d = (d * a) % n;
			}
//			System.out.println(d);
		}
		if (d < 0){
			d += n;
		}
		return d;
	}

}
