//Write a program that, given a positive integer n, prints out all the subsets of {1,2,…,n}.
//Hint: (use Integer toBinaryString() and the String method toCharArray() ). 

public class week1_1 {

	public static void main(String[] args) {
		int n = 8;
		int total = (int) Math.pow(2, n);

		for (int i = 0; i < total; i++) {
			char[] binary = Integer.toBinaryString(i).toCharArray();

			System.out.print("{ ");
			for (int j = 0; j < binary.length; j++) {
				if (binary[j] == '1') {
					System.out.print(j + " ");
				}
			}
			System.out.println("}");
		}
	}
}