import java.util.Scanner;

//Write a method that, given positive integer n prints all the primes less than or equal to n.

public class week1_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the top number");
		int topNumber = input.nextInt();

		long startTime = System.nanoTime();
		checkIt(topNumber);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println("It took " + duration / 1000000 + "ms to complete.");
		input.close();

	}

	public static void checkIt(int topNumber) {
		for (int i = 0; i <= topNumber; i++) {
			if (isPrime(i))
				System.out.println(i);
		}
	}

	public static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
