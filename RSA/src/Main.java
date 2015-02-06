import java.math.BigInteger;
import java.util.Random;

public class Main {

	private static BigInteger p, q, n, phi, e;

	public static void main(String[] args) {
		String ascii = toascii("hello world");
		System.out.println(ascii);

		String[] blocks = breakIntoBlocks(ascii);

		for (int i = 0; i < blocks.length; i++) {
			System.out.print(blocks[i] + "\t");
		}

		System.out.println();

		p = BigInteger.probablePrime(4, new Random());
		q = BigInteger.probablePrime(4, new Random());

		n = p.multiply(q);
		e = q.nextProbablePrime();
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		System.out.println("P = " + p);
		System.out.println("Q = " + q);
		System.out.println("N = " + n);
		System.out.println("ø(n) = " + phi);
		System.out.println("E = " + e);

		String[] code = encipher(blocks);

		for (int i = 0; i < code.length; i++) {
			System.out.print(code[i] + "\t");
		}

	}

	public static String[] encipher(String[] ascii) {
		String[] code = new String[20];
		for (int i = 0; i < ascii.length; i++) {
			// System.out.println("ascii[" + i + "] = " + ascii[i]);

			BigInteger c = new BigInteger(ascii[i]);
			code[i] = c.modPow(e, n).toString();

			// System.out.println("code[" + i + "] = " + code[i]);

		}

		return code;
	}

	public static String[] decipher(String[] code) {
		return null;
	}

	public static String[] breakIntoBlocks(String ascii) {
		String[] blocks = new String[ascii.length() / 4];

		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = ascii.substring(0, 4);
			ascii = ascii.substring(4, ascii.length());
		}

		return blocks;
	}

	public static int[] breakIntoBlocksInts(String code) {
		int[] blocks = new int[code.length() / 4];

		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = Integer.parseInt(code.substring(0, 4));
			code = code.substring(4, code.length());
		}

		return blocks;
	}

	public static String toascii(String string) {
		string.toLowerCase();
		char[] chars = string.toCharArray();
		String code = "";
		for (int i = 0; i < chars.length; i++) {
			code = code + asciiValue(chars[i]);
			// System.out.println(asciiValue(chars[i]) + " = " + chars[i]);
		}
		return code;
	}

	public static String asciiValue(char letter) {
		int ascii = letter;

		if (ascii < 10) {
			return ("0" + ascii);
		}
		return (ascii + "");
	}

}
