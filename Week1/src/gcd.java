// An int version of GCD

public class gcd {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		System.out.println("The GCD of "+n+" and "+m+" is: ");
		System.out.println(euclid(n,m));
	}
	
	public static int euclid (int n, int m) {
		if(m == 0){
			return n;
		}
		else {
			return euclid(m, n%m);
		}
	}

}
