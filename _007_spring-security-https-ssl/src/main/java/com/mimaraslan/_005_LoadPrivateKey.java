package com.mimaraslan;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class _005_LoadPrivateKey {

	public static void main(String[] args) {
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    keyStore.load(new FileInputStream("src/main/resources/bootsecurity.p12"), "123456789".toCharArray());
		     
		    Key pvtKey = keyStore.getKey("bootsecurity", "123456789".toCharArray());
		    System.out.println(pvtKey.toString());
		     
		   
		    Certificate[]  certificates =  keyStore.getCertificateChain("bootsecurity");
		    for(java.security.cert.Certificate cert:certificates){
		        System.out.println(cert.toString());
		    }
		} catch (Exception ex){
		    ex.printStackTrace();
		}
	}

}
