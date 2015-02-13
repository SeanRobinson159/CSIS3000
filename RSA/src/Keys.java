import java.math.BigInteger;

public class Keys {
	private BigInteger p, q, n, phi, e, inverse;
	private boolean firstLetterIsLowercase;

	public String encipher(BigInteger c) {
		return c.modPow(e, n).toString();
	}

	public String decipher(BigInteger code) {
		if (firstLetterIsLowercase) {
			return "0" + code.modPow(inverse, n).toString();
		}
		return code.modPow(inverse, n).toString();
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
	public void setPublicKeys(BigInteger e, BigInteger n){
		this.e = e;
		this.n = n;
	}

	public void printStart() {
		System.out.println("p = \t" + p);
		System.out.println("q = \t" + q);
		System.out.println("n = \t" + n);
		System.out.println("ø(n) =\t" + phi);
		System.out.println("e = \t" + e);
		System.out.println("GCD(e,ø(n)) = " + e.gcd(phi));
		System.out.println();
	}

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getInverse() {
		return inverse;
	}

	public void setInverse(BigInteger inverse) {
		this.inverse = inverse;
	}
	
}