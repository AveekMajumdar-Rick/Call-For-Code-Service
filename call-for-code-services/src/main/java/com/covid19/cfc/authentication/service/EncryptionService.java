package com.covid19.cfc.authentication.service;

public interface EncryptionService {
	
	public String aesEncryptAndBase64Encode(String identifier);

	public String aesDecryptAndBase64Decode(String encryptedString);

}
