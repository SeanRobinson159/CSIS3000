import java.util.Scanner;

public class week1_1 {
	public static String[] setA = new String[10];

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please input setA (seperated by commas)");
		setA = input.nextLine().split(",");

		for (int i = 0; i < Math.pow(2, setA.length); i++) {
			int[] iBinary = toBinary(i);
			System.out.print("{");
			for (int j = iBinary.length - 1; j > -1; j--) {
				if (iBinary[j] == 1) {
					System.out.print(setA[j] + ",");
				}
			}
			System.out.println("}");
		}
		input.close();
	}

	public static void printSet(String[] set) {
		System.out.print("{");
		for (int i = 0; i < set.length; i++) {
			System.out.print(set[i]);
			if (i < set.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("}");
	}

	public static int[] toBinary(int a) {
		int binary[] = new int[setA.length];
		int index = 0;
		while (a > 0) {
			binary[index++] = a % 2;
			a = a / 2;
		}
		return binary;

	}
}