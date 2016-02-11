package interfaces;

import java.math.BigInteger;

public abstract class IPublicKey {
	BigInteger E;
	BigInteger N;
	
	public BigInteger getE() {
		return E;
	}
	public void setE(BigInteger e) {
		E = e;
	}
	public BigInteger getN() {
		return N;
	}
	public void setN(BigInteger n) {
		N = n;
	}
	
}
