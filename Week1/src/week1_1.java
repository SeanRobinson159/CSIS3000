//Write a program that, given a positive integer n, prints out all the subsets of {1,2,…,n}.
//Hint: (use Integer toBinaryString() and the String method toCharArray() ). 


import java.util.Scanner;

public class week1_1 {
	//public static String[] setA = new String[10];
	static int setA = 0;
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please input n");
		int setA = Integer.parseInt(input.nextLine());

		for (int i = 0; i < Math.pow(2, setA); i++) {
			char[] iBinary = Integer.toBinaryString(setA).toCharArray();
			
			System.out.print("{");
			for (int j = iBinary.length-1; j > -1; j--) {
				System.out.println(iBinary[j]);
				if (iBinary[j] == '1') {
					System.out.print(j + ",");
				}
			}
			System.out.println("}");
		}
		input.close();
	}
}