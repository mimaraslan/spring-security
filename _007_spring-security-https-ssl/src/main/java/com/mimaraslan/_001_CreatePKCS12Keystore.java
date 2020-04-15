package com.mimaraslan;

import java.io.FileOutputStream;
import java.security.KeyStore;

public class _001_CreatePKCS12Keystore {

	public static void main(String[] args) {
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    keyStore.load(null, null);
		     
		    keyStore.store(new FileOutputStream("src/main/resources/output.p12"), "123456789".toCharArray());
		} catch (Exception ex){
		    ex.printStackTrace();
		}
	}

}
