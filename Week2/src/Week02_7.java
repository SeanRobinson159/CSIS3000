//Use gcd to find and print the group of units modulo n for n = 5 to 100.  Print them out in this format:
//Ex. n = 8: GroupOfUnitsMod 8 = {1,3,5,7}.  Also include the number of elements.  (This equals phi(n)).

public class Week02_7 {

	public static void main(String[] args) {
		int groups[] = new int[100];
		int a = 0;
		for (int n = 5; n <= 100; n++) {
			for (int i = 1; i < n; i++) {
				if (n == 8) {
					if (i%n !=1) {
						//System.out.println(phi(n));
						groups[a] = i%n;
						a++;
					}
				}
			}
		}
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i]);

		}

	}

}
