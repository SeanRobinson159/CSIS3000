import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

	private BigInteger p, q, n, phi, e;

	public static void main(String[] args) {
		RSA rsa = new RSA();
		Scanner input = new Scanner(System.in);
		
		System.out
				.println("Type a message that you would like to encode. (It must start with a lowercase letter");
		String message = input.nextLine();

		String ascii = rsa.toascii(message);

		String blocks = rsa.breakIntoBlocks(ascii);

		System.out.println(blocks);
		String code2 = rsa.encipher(new BigInteger(blocks));
		System.out.println(code2);

		String decipheredCode2 = rsa.decipher(new BigInteger(code2));
		System.out.println(decipheredCode2);

		System.out.println(rsa.valueToAscii(decipheredCode2));

		input.close();
	}

	public RSA() {
		p = BigInteger.probablePrime(500, new Random());
		q = BigInteger.probablePrime(500, new Random());
		n = p.multiply(q);
		e = p.nextProbablePrime();
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	}

	public String encipher(BigInteger c) {
		return c.modPow(e, n).toString();
	}

	public String decipher(BigInteger code) {
		return code.modPow(e.modInverse(phi), n).toString();
	}

	public String valueToAscii(String decipheredCode) {
		String decipheredText = "";
		while (decipheredCode.length() >= 3) {
			decipheredText += String.valueOf((char) Integer
					.parseInt(decipheredCode.substring(0, 3)));
			decipheredCode = decipheredCode.substring(3,
					decipheredCode.length());
		}
		return decipheredText;
	}

	public String breakIntoBlocks(String ascii) {
		String blocks = "";
		while (ascii.length() >= 3) {
			if (ascii.length() >= 3) {
				blocks += ascii.substring(0, 3);
				ascii = ascii.substring(3, ascii.length());
			} else {
				blocks += "000";
			}
		}
		return blocks;
	}

	public String toascii(String s) {
		char[] chars = s.toCharArray();
		String code = "";
		for (int i = 0; i < chars.length; i++) {
			code += asciiToValue(chars[i]);
		}
		while (code.length() < 300) {
			code += "0";
		}
		return code;
	}

	public String asciiToValue(char letter) {
		int ascii = letter;
		if (ascii < 100) {
			return ("0" + ascii);
		}
		return (ascii + "");
	}

	public void printStart() {
		System.out.println("p = \t" + p);
		System.out.println("q = \t" + q);
		System.out.println("n = \t" + n);
		System.out.println("ø(n) = \t" + phi);
		System.out.println("e = \t" + e);
		System.out.println("GCD(e,ø(n)) = " + e.gcd(phi));
		System.out.println();
	}
}