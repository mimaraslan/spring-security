package com.mimaraslan;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;

public class _007_LoadCertificate {

	public static void main(String[] args) {		
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    keyStore.load(new FileInputStream("src/main/resources/output.p12"), "123456789".toCharArray());
		     
		    java.security.cert.Certificate cert =  keyStore.getCertificate("output");
		    
		    System.out.println(cert);
		} catch (Exception ex){
		    ex.printStackTrace();
		}
		
	}

}
