/*
 * Covert a file to a string parse it into 200 character substrings
 *  and insert these into an ArrayList
 *  Use paddedAscii to convert these into BigIntegers of exactly 600 digits in
 *  length and insert these into another ArrayList
 *  In very one of the above, the last block will probably be shorter.
 */

package Week7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unused")
public class CyberChallangePractice {

	private static BigInteger p = new BigInteger(
			"1021300077858969863081029334943225281104450076908283157888165345016728011739287607495493014437028841898033265444986948850765951850225910516954228288323246905463482218167305673010818333421631524614324639747257464270399957057194931893089078765555569774945211079804794117990384285141784276268982566709451");
	private static BigInteger q = new BigInteger(
			"642847995105235794598226990200538905371094720607687227026541712928596518398897426602668416217800229134915673335179937439871030465861567057141301720531339115161184118724586412210219607813233023385086806080742627666144218599511532630210220245791203018131255589973824464144946616333891787737891979786761");
	private static BigInteger n = p.multiply(q);
	private static BigInteger phiOfN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	private static BigInteger e = BigInteger.valueOf(65537); // Public exponent
	private static BigInteger d = e.modInverse(phiOfN); // Private exponent

	public static void main(String[] args) {
//		String s = fileToString("./cs-description.txt");
//		ArrayList<String> sBlocks = toStringBlocks(s);
//
//		ArrayList<BigInteger> plainText = toBigIntegerBlocks(sBlocks);
//		ArrayList<BigInteger> cipherText = encrypt(plainText);
		String cipherTextString = fileToString("./practice-challange.txt");
		ArrayList<BigInteger> cipherText = stringToBigIntegerArrayList(cipherTextString);
		ArrayList<BigInteger> decipheredText = decrypt(cipherText);
		ArrayList<String> stringPlainText = plainTextToStringBlocks(decipheredText);
		stringToFile(stringPlainText, "./practice-challange2.txt");

	}
	
	public static ArrayList<BigInteger> stringToBigIntegerArrayList(String s){
		ArrayList<BigInteger> cipherText = new ArrayList<BigInteger>();
		String[] sBlocks = s.split("\n");
		for(String block: sBlocks){
			if(block.length() > 100){
				cipherText.add(new BigInteger(block));
			}
		}
		return cipherText;
	}

	public static ArrayList<BigInteger> encrypt(ArrayList<BigInteger> plainText) {
		ArrayList<BigInteger> cypherText = new ArrayList<BigInteger>();
		for (BigInteger plainTextBlock : plainText) {
			cypherText.add(plainTextBlock.modPow(e, n));
		}
		return cypherText;
	}

	// Check your work: The result should be exactly the same as the plaintext.
	public static ArrayList<BigInteger> decrypt(ArrayList<BigInteger> cipherText) {
		ArrayList<BigInteger> decypheredText = new ArrayList<BigInteger>();
		for (BigInteger cipherTextBlock : cipherText) {
			decypheredText.add(cipherTextBlock.modPow(d, n));
		}
		return decypheredText;
	}

	public static char unPaddedAscii(int ascii) {
		ascii -= 100;
		char c = (char) ascii;
		return c;
	}

	public static ArrayList<String> plainTextToStringBlocks(ArrayList<BigInteger> plainText) {
		ArrayList<String> stringBlocks = new ArrayList<String>();
		for (BigInteger plainTextBlock : plainText) {
			String stringPlainTextBlock = "";
			for (int i = 0; i < plainTextBlock.toString().length(); i += 3) {
				int plainTextAscii = new Integer(plainTextBlock.toString().substring(i, i + 3));
				stringPlainTextBlock += unPaddedAscii(plainTextAscii);
			}
//			System.out.println(stringPlainTextBlock);
			stringBlocks.add(stringPlainTextBlock);
		}
		return stringBlocks;
	}

	private static String fileToString(String filePath) {
		String str = null;
		try {
			str = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return str;
		}
		return str;
	}

	public static void stringToFile(ArrayList<String> decipheredText, String filePath) {
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");

			for (String decipheredTextBlock : decipheredText) {
				writer.print(decipheredTextBlock);
			}

			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
		System.out.println("File saved.");
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
		ArrayList<BigInteger> bigIntegerBlocks = new ArrayList<BigInteger>();

		for (String block : sBlocks) {
			String integerBlock = "";
			char[] sBlockChar = block.toCharArray();
			for (int i = 0; i < sBlockChar.length; i++) {
				integerBlock += toPaddedAscii(sBlockChar[i]);
			}
			bigIntegerBlocks.add(new BigInteger(integerBlock));
		}

		return bigIntegerBlocks;
	}

	public static int toPaddedAscii(char c) {
		int asciiChar = c;
		asciiChar += 100;
		return asciiChar;
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

	public static BigInteger euclid(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO)) {
			return n;
		} else {
			return euclid(m.abs(), n.abs().mod(m.abs()));
		}
	}

}
