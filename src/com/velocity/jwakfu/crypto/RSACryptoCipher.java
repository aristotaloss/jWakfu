package com.velocity.jwakfu.crypto;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPrivateKeySpec;

import javax.crypto.Cipher;

public class RSACryptoCipher extends CryptoCipher {

	public static final AlgorithmParameterSpec parameterSpec = new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4);
	private KeyFactory factory;

	public RSACryptoCipher(String algoName, AlgorithmParameterSpec spec) {
		super(algoName, spec);

		try {
			factory = KeyFactory.getInstance(algorithmName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(byte[] keyData) {
		try {
			EncodedKeySpec keySpec = createKeySpec(keyData);
			PublicKey key = factory.generatePublic(keySpec);
			cipher.init(1, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initRSA(BigInteger modulus, BigInteger privateKey) {
		try {
			RSAPrivateKeySpec rsaspec = new RSAPrivateKeySpec(modulus, privateKey);
			PrivateKey pub = factory.generatePrivate(rsaspec);
			cipher.init(Cipher.DECRYPT_MODE, pub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] encode(byte[] data) {
		try {
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public byte[] decode(byte[] data) {
		try {
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
