import java.math.BigInteger;
import java.util.Random;


public class week4_5 {

	public static void main(String[] args) {
		BigInteger p = new BigInteger(512, 1, new Random());
		BigInteger a = new BigInteger(512, new Random());
		BigInteger b = new BigInteger(512, new Random());
		BigInteger n = new BigInteger(512, new Random());
		BigInteger q = new BigInteger("1");
		q = q.setBit(512);
		q = q.nextProbablePrime();

		System.out.println("p = "+p.toString()+"\nProbable Prime? "+p.isProbablePrime(1));
		System.out.println("a = "+a.toString()+"\nProbable Prime? "+a.isProbablePrime(1));
		System.out.println("b = "+b.toString()+"\nProbable Prime? "+b.isProbablePrime(1));
		System.out.println("n = "+n.toString()+"\nProbable Prime? "+n.isProbablePrime(1));
		
		System.out.println("\n\na + b =\n"+a.add(b));
		System.out.println("\nBit length of n = "+n.bitLength());
		
		if(a.compareTo(b)==-1){
			System.out.println("a is smaller than b");
		} else {
			System.out.println("a is bigger than b");
		}
		
		System.out.println("\na ÷ b = "+a.divide(b).toString());
		
		System.out.println("\na mod n = "+a.mod(n));
		System.out.println("a^-1 mod n = "+a.modInverse(n));
		System.out.println("a^b mod n = "+a.modPow(b, n));
		System.out.println("a • b mod n = "+a.multiply(b).mod(n));
		
		System.out.println("\nNext probable prime after p:\n"+p.nextProbablePrime());
		
		System.out.println("\nq = \n"+q);

	}
	
}
