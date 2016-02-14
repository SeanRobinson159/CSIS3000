/*
 * Covert a file to a string parse it into 200 character substrings
 *  and insert these into an ArrayList
 *  Use paddedAscii to convert these into BigIntegers of exactly 600 digits in
 *  length and insert these into another ArrayList
 *  In very one of the above, the last block will probably be shorter.
 */

package Week6;

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
public class toBigInts {

	private static BigInteger p = new BigInteger(
			"4353148317158884929938894629323657442790082275333762242118934090249129324223327569113947802205405349279485526159428071268333238900209280543207988503881018624670549086033276923223838188563176535643492283916713896272727572123233998850168662186120814786676825737234938518198082619261331585429597830255697");
	private static BigInteger q = new BigInteger(
			"135829747332072109818262617213061327917137635061428931755186068654850529026272480796477314029141026524377293503600198814264691923195009167306573346023202296741243485400316177320752203456536146226410922239330669435336987877241755168287535519453259856371328454759510532906388630312005953250794598326251");
	private static BigInteger n = new BigInteger(
			"591287036018726244866483124848879900904910635350061423920835476704371576932347934014031588540512377888265534219076040419167104475587786403795890611818692452820906345221565049713597224560173170586721922112074807410843974721096307131051521704357835128829910897105095446613330353580233402141443840270799265127481147562598629190465814147869497638898580411094586104969034652704590504150933885130890113573834354270298324759763950605034851601196051838036666989526384999033412140806762855852142420380121656999196474935600858280567737181569000961298515848153357219456922047275703489918312382882488043557401947");
	private static BigInteger phiOfN = new BigInteger(
			"591287036018726244866483124848879900904910635350061423920835476704371576932347934014031588540512377888265534219076040419167104475587786403795890611818692452820906345221565049713597224560173170586721922112074807410843974721096307131051521704357835128829910897105095446613330353580233402141443840270794776149416656605558872033219277429098790418988185219920711984810130672851340904101023460014655567198030491450635296489681352674211447311485537276186762768604973206461978547706218265460122707698251753793040430369892793720567261427550544763592941773510309065264927598224599018668739045343807651128820000");
	private static BigInteger e = new BigInteger("65537"); // Public exponent
	private static BigInteger d = e.modInverse(phiOfN); // Private exponent

	public static void main(String[] args) {
		String s = fileToString("./cs-description.txt");
		ArrayList<String> sBlocks = toStringBlocks(s);

		ArrayList<BigInteger> plainText = toBigIntegerBlocks(sBlocks);
		ArrayList<BigInteger> cipherText = encrypt(plainText);
		ArrayList<BigInteger> decipheredText = decrypt(cipherText);
		ArrayList<String> stringPlainText = plainTextToStringBlocks(decipheredText);
		stringToFile(stringPlainText, "./cs-description2.txt");

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
