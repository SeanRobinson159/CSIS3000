package interfaces;

import java.math.BigInteger;

public abstract class IPrivateKey {
	BigInteger D; //= e-1 mod phi of n (using extended Euclid).
	BigInteger N;
}
