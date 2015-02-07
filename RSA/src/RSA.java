import java.math.BigInteger;
import java.util.Random;

public class RSA {

	private static BigInteger p, q, n, phi, e;

	public static void main(String[] args) {
		p = BigInteger.probablePrime(1024, new Random());
		q = BigInteger.probablePrime(1024, new Random());
		// p = new BigInteger("43");
		// q = new BigInteger("59");

		n = p.multiply(q);
		e = p.nextProbablePrime();
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		System.out.println("p = \t" + p);
		System.out.println("q = \t" + q);
		System.out.println("n = \t" + n);
		System.out.println("ø(n) = \t" + phi);
		System.out.println("e = \t" + e);
		System.out.println("GCD(e,ø(n)) = " + e.gcd(phi));
		System.out.println();

		String ascii = toascii("HELLO WORLD! ");

		String[] blocks = breakIntoBlocks(ascii);

		for (int i = 0; i < blocks.length; i++) {
			System.out.print(blocks[i]);
		}

		System.out.println();

		String[] code = encipher(blocks);

		for (int i = 0; i < code.length; i++) {
			System.out.print(code[i]);
		}
		System.out.println();

		String[] decipheredCode = decipher(code);

		for (int i = 0; i < decipheredCode.length; i++) {
			System.out.print(decipheredCode[i]);
		}

		System.out.println("\n\nText: "+valueToAscii(decipheredCode));

	}

	public static String[] encipher(String[] ascii) {
		String[] code = new String[ascii.length];
		for (int i = 0; i < ascii.length; i++) {
			BigInteger c = new BigInteger(ascii[i]);
			String s = c.modPow(e, n).toString();
			while (s.length() < 4) {
				s = "0" + s;
			}
			code[i] = s;
		}

		return code;
	}

	public static String[] decipher(String[] code) {
		String[] decipheredCode = new String[code.length];
		for (int i = 0; i < code.length; i++) {
			BigInteger a = new BigInteger(code[i]);
			String s = a.modPow(e.modInverse(phi), n).toString();
			while (s.length() < 4) {
				s = "0" + s;
			}
			decipheredCode[i] = s;
		}
		return decipheredCode;
	}

	public static String valueToAscii(String [] decipheredCode) {
		String decipheredText = "";
		for(int i = 0; i < decipheredCode.length; i++){
			String temp = decipheredCode[i].substring(0, 2);
			temp = String.valueOf((char)Integer.parseInt(temp));
			decipheredText += temp;
			temp = decipheredCode[i].substring(2, 4);
			temp = String.valueOf((char)Integer.parseInt(temp));
			decipheredText += temp;
		}
		
		return decipheredText;
	}

	public static String[] breakIntoBlocks(String ascii) {
		String[] blocks = new String[75];

		for (int i = 0; i < blocks.length; i++) {
			if (ascii.length() >= 4) {
				blocks[i] = ascii.substring(0, 4);
				ascii = ascii.substring(4, ascii.length());
			} else {
				blocks[i] = "0000";
			}
		}

		return blocks;
	}

	public static String toascii(String s) {
		s = s.toUpperCase();
		char[] chars = s.toCharArray();
		String code = "";
		for (int i = 0; i < chars.length; i++) {
			code += asciiToValue(chars[i]);
		}
		return code;
	}

	public static String asciiToValue(char letter) {
		int ascii = letter;

		if (ascii < 10) {
			return ("0" + ascii);
		}
		return (ascii + "");
	}

}