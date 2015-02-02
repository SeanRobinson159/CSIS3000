//Find the least nonnegative residue mod 13 of these integers: 22, 100, 1001, -1, -100, -1000, 2^20, 2^30.

public class Week02_1 {

	public static void main(String[] args) {
		int x[] = {22,100,1001,-1,-100,-1000,(int)Math.pow(2, 20),(int)Math.pow(2, 30)};
		
		for(int i =0; i <x.length; i++){
			System.out.println(x[i]+" % 13 = "+Math.abs(x[i]%13));
		}
		
	}

}
