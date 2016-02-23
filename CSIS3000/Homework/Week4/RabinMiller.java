package Week4;

import java.math.BigInteger;
import java.util.Random;

public class RabinMiller{ 
 
    private int bitLength; 
    private BigInteger n; 
    private BigInteger a; 
    private int fermatsPassCount; 
    
    public static void main(String[] args){ 
        RabinMiller rm = new RabinMiller(1024); 
 
        rm.generateN(); 
        rm.generateALessThanN(); 
 
        while(rm.fermatsPassCount < 100){ 
            rm.generateALessThanN(); 
            rm.fermatsTest(); 
        } 
 
        System.out.println(rm.n + " is probably a prime.\n"); 
 
        System.out.println("Double checking with built-in method..."); 
        if(rm.n.isProbablePrime(99)){ 
            System.out.println("Yup! Looks like n is in fact a prime."); 
        } 
    }
 
    private RabinMiller(int bitLength){ 
        this.bitLength = bitLength; 
        this.fermatsPassCount = 0; 
    } 
 
    private void generateN(){ 
        this.n = new BigInteger(this.bitLength, new Random()); 
    } 
 
    private void generateALessThanN(){ 
        this.a = new BigInteger(this.bitLength, new Random()); 
 
        while(this.a.compareTo(n) != -1){ 
            this.a = new BigInteger(this.bitLength, new Random()); 
        } 
    } 
 
    private void fermatsTest(){ 
        BigInteger fermat = this.a.modPow(this.n.subtract(BigInteger.ONE), this.n); 
 
        if(fermat.equals(BigInteger.ONE)){ 
            this.fermatsPassCount++; 
        } else { 
            this.n = this.n.add(BigInteger.ONE); 
            this.fermatsPassCount = 0; 
        } 
    } 
 
} 