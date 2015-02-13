import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

	private BigInteger p, q, n, phi, e;
	private boolean firstLetterIsLowercase;
	private final int BITLENGTH = 500;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		RSA rsa = new RSA();
		rsa.printStart();

		System.out.println("Type a message that you would like to encode.");
		String message = input.nextLine();

		String plainText = rsa.toascii(message);
		System.out.println("PlainText:\t"+plainText);

		String encipheredCode = rsa.encipher(new BigInteger(plainText));
		System.out.println("EncipheredCode: "+encipheredCode);

		String decipheredPlainText = rsa.decipher(new BigInteger(encipheredCode));
		System.out.println("DecipheredText: "+decipheredPlainText);

		System.out.println(rsa.valueToAscii(decipheredPlainText));

		input.close();
	}

	public RSA() {
		p = BigInteger.probablePrime(BITLENGTH, new Random());
		q = BigInteger.probablePrime(BITLENGTH, new Random());
		n = p.multiply(q);
		e = p.nextProbablePrime();
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	}

	public RSA(BigInteger publicKeyE, BigInteger publicKeyN) {
		p = BigInteger.probablePrime(BITLENGTH, new Random());
		q = BigInteger.probablePrime(BITLENGTH, new Random());
		n = publicKeyN;
		e = publicKeyE;
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	}

	public String encipher(BigInteger c) {
		return c.modPow(e, n).toString();
	}

	public String decipher(BigInteger code) {
		if (firstLetterIsLowercase) {
			return "0" + code.modPow(e.modInverse(phi), n).toString();
		}
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
		if (code.charAt(0) == ('0')) {
			firstLetterIsLowercase = true;
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