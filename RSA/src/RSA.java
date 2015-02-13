import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class RSA extends Keys {

	private final int BITLENGTH = 500;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		// System.out.println("Type a message that you would like to encode.");
		// String message = input.nextLine();
		String message = "hello world";
		// test1(message);
		encipherWithPublicKey(message);

		input.close();
	}

	public static void test1(String message) {
		RSA rsa = new RSA();
		rsa.printStart();

		String plainText = rsa.toascii(message);
		System.out.println("PlainText:\t" + plainText);

		String cipherText = rsa.encipher(new BigInteger(plainText));
		System.out.println("CipherText: \t" + cipherText);

		String decipheredText = rsa.decipher(new BigInteger(cipherText));
		System.out.println("DecipheredText: " + decipheredText);

		System.out.println(rsa.valueToAscii(decipheredText));
	}

	@SuppressWarnings("resource")
	public static void encipherWithPublicKey(String message) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"PublicKey.txt"));
			String[] publicKey = reader.readLine().split(",");
			reader = new BufferedReader(new FileReader("PrivateKey.txt"));
			String[] privateKey = reader.readLine().split(",");

			RSA rsa = new RSA(new BigInteger(publicKey[0].toString()),new BigInteger(publicKey[1].toString()));
//			rsa.setE(new BigInteger(publicKey[0].toString()));
//			rsa.setN(new BigInteger(publicKey[1].toString()));
			rsa.setInverse(new BigInteger(privateKey[0].toString()));

			// rsa.printStart();
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

	public RSA() {
		setP(BigInteger.probablePrime(BITLENGTH, new Random()));
		setQ(BigInteger.probablePrime(BITLENGTH, new Random()));
		setN(getP().multiply(getQ()));
		setE(getP().nextProbablePrime());
		setPhi(getP().subtract(BigInteger.ONE).multiply(
				getQ().subtract(BigInteger.ONE)));
		setInverse(getE().modInverse(getPhi()));
	}

	public RSA(BigInteger publicKeyE, BigInteger publicKeyN) {
//		setP(BigInteger.probablePrime(BITLENGTH, new Random()));
//		setQ(BigInteger.probablePrime(BITLENGTH, new Random()));
		setPublicKeys(publicKeyE, publicKeyN);
//		setPhi(getP().subtract(BigInteger.ONE).multiply(
//				getQ().subtract(BigInteger.ONE)));
//		setInverse(getE().modInverse(getPhi()));
	}

	public void keysToFile(BigInteger e, BigInteger inverse, BigInteger n) {

		try {
			FileWriter writer = new FileWriter(new File("PublicKey.txt"));
			writer.write(e.toString() + "," + n.toString());

			FileWriter writer2 = new FileWriter(new File("PrivateKey.txt"));
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

		keysToFile(getE(), getInverse(), getPhi());
	}

}