import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class RSA extends Keys {

	private final int BITLENGTH = 500;
	private final static String privateLoc = "PrivateKey.txt";
	private final static String publicLoc = "PublicKey.txt";

	public static void main(String[] args) throws IOException {
		String message = "hello world";
		// test1(message);
		encipherWithPublicKey(message);
	}

	public static void test1(String message) {
		RSA rsa = new RSA();

		String plainText = rsa.toascii(message);
		System.out.println("PlainText:\t" + plainText);

		String cipherText = rsa.encipher(new BigInteger(plainText));
		System.out.println("CipherText: \t" + cipherText);

		String decipheredText = rsa.decipher(new BigInteger(cipherText));
		System.out.println("DecipheredText: " + decipheredText);

		System.out.println(rsa.valueToAscii(decipheredText));

		System.out.println("\nE: " + rsa.getE());
		System.out.println("N: " + rsa.getN());
		System.out.println("I: " + rsa.getInverse());
	}

	@SuppressWarnings("resource")
	public static void encipherWithPublicKey(String message) {

		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(publicLoc));
			String[] publicKey = reader.readLine().split(",");
			reader = new BufferedReader(new FileReader(privateLoc));
			String[] privateKey = reader.readLine().split(",");

			RSA rsa = new RSA(new BigInteger(publicKey[0].toString()),
					new BigInteger(publicKey[1].toString()), new BigInteger(
							privateKey[0].toString()));
			String plainText = rsa.toascii(message);
			System.out.println("PlainText:\t" + plainText);

			String cipherText = rsa.encipher(new BigInteger(plainText));
			System.out.println("CipherText:\t" + cipherText);

			String decipheredText = rsa.decipher(new BigInteger(cipherText));
			System.out.println("DecipheredText: " + decipheredText);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("resource")
	public void readKeys() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(publicLoc));
			String[] publicKey = reader.readLine().split(",");
			reader = new BufferedReader(new FileReader(privateLoc));
			String[] privateKey = reader.readLine().split(",");

			setPublicKeys(new BigInteger(publicKey[0]), new BigInteger(
					publicKey[1]));
			setInverse(new BigInteger(privateKey[0]));

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public RSA() {
		setP(BigInteger.probablePrime(BITLENGTH, new Random()));
		setQ(BigInteger.probablePrime(BITLENGTH, new Random()));
		setN(getP().multiply(getQ()));
		setE(getP().nextProbablePrime());
		setPhi(getP().subtract(BigInteger.ONE).multiply(
				getQ().subtract(BigInteger.ONE)));
		setInverse(getE().modInverse(getPhi()));
	}

	public RSA(BigInteger publicKeyE, BigInteger publicKeyN,
			BigInteger privateKeyI) {
		setPublicKeys(publicKeyE, publicKeyN);
		setInverse(privateKeyI);
	}

	public void keysToFile(BigInteger e, BigInteger inverse, BigInteger n) {

		try {
			FileWriter writer = new FileWriter(new File(publicLoc));
			writer.write(e.toString() + "," + n.toString());

			FileWriter writer2 = new FileWriter(new File(privateLoc));
			writer2.write(inverse.toString() + "," + n.toString());

			writer.close();
			writer2.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void generateNewKeys() {
		setP(BigInteger.probablePrime(BITLENGTH, new Random()));
		setQ(BigInteger.probablePrime(BITLENGTH, new Random()));
		setN(getP().multiply(getQ()));
		setE(getP().nextProbablePrime());
		setPhi(getP().subtract(BigInteger.ONE).multiply(
				getQ().subtract(BigInteger.ONE)));
		setInverse(getE().modInverse(getPhi()));

		keysToFile(getE(), getInverse(), getN());
	}

}