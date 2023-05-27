package com.covid19.cfc.authentication.service;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

	private static final String AES_VALUE = "AES";

	/*
	 * A key with 16 bytes. This means we are using AES128. To make it AES 192
	 * increase the key bytes to 24 For AES 256 the bytes of the key should be 32
	 */
	private static final byte[] keyValue = new byte[] { 'F', 'R', 'E', 'E', 'D', 'O', 'M', 'S', 'E', 'C', 'U', 'R', 'E',
			'I', 'B', 'M' };

	private String base64Encode(byte[] hash) {

		return Base64.encode(hash);
	}

	private byte[] base64Decode(String encryptedData) {
		byte[] encryptedBytes = null;
		try {
			encryptedBytes = Base64.decode(encryptedData);
		} catch (WSSecurityException e) {
			e.printStackTrace();
		}

		return encryptedBytes;
	}

	/**
	 * Performs AES encryption of a given identifier. This string can be later
	 * decrypted using a common key
	 * 
	 * @param identifier - The identifier to encrypt
	 * @return - The encrypted string
	 */
	public String aesEncryptAndBase64Encode(String identifier) {
		try {
			Key key = generateKey();

			Cipher cipher = Cipher.getInstance(AES_VALUE);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] encryptedBytes = cipher.doFinal(identifier.getBytes("UTF-8"));

			return base64Encode(encryptedBytes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SecurityException(e);
		}
	}

	/**
	 * Decrypts an AES encrypted base 64 encoded string and returns the decrypted
	 * string
	 * 
	 * @param encryptedString - The encrypted string to decrypt
	 * @return - The base64 decoded and decrypted string.
	 * 
	 */
	public String aesDecryptAndBase64Decode(String encryptedString) {
		try {
			Key key = generateKey();

			Cipher c = Cipher.getInstance(AES_VALUE);
			c.init(Cipher.DECRYPT_MODE, key);

			byte[] encryptedBytes = base64Decode(encryptedString);
			byte[] decryptedBytes = c.doFinal(encryptedBytes);

			return new String(decryptedBytes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SecurityException(e);
		}
	}

	private static Key generateKey() {

		return new SecretKeySpec(keyValue, AES_VALUE);
	}
}
