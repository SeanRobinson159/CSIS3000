/*
 * Covert a file to a string parse it into 200 character substrings
 *  and insert these into an ArrayList
 *  Use paddedAscii to convert these into BigIntegers of exactly 600 digits in
 *  length and insert these into another ArrayList
 *  In very one of the above, the last block will probably be shorter.
 */

package Week6;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class twoBigInts {

	public static void main(String[] args) {
		
		String s = fileToString("./cs-description.txt");
		ArrayList<String> sBlocks = toStringBlocks(s);

		System.out.println(sBlocks.toString());

		ArrayList<BigInteger> plainText = toBigIntegerBlocks(sBlocks);
	}

	private static String fileToString(String filePath) {
		String str = null;
		try {
			str = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			return str;
		}
		return str;
	}

	// Parse a string into 200 character substrings
	// Beware of the indices on substring
	public static ArrayList<String> toStringBlocks(String str) {
		ArrayList<String> stringBlock = new ArrayList<String>();
		while (str.length() > 200) {
			stringBlock.add(str.substring(0, 200));
			str = str.substring(200);
		}
		stringBlock.add(str.substring(0));

		return stringBlock;
	}

	// Convert each substring of length 200 to a BigInteger of length 600.
	public static ArrayList<BigInteger> toBigIntegerBlocks(ArrayList<String> sBlocks) {
		return null;
	}

	public static BigInteger multiply(BigInteger a, BigInteger b) {
		return a.multiply(b);
	}

	private static BigInteger randomBigInteger(int numberOfDigits) {
		Random random = new Random();
		// if we know the number of decimal digits, how many bits are required?
		int length = (int) (3.32 * (double) numberOfDigits);
		return new BigInteger(length, random);
	}

	public static BigInteger randomPrime(int numberOfDigits) {
		BigInteger randomBigInt = randomBigInteger(numberOfDigits);
		return randomBigInt.nextProbablePrime();
	}

}
