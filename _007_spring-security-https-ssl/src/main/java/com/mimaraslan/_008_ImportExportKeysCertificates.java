package com.mimaraslan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;

public class _008_ImportExportKeysCertificates {

	public static void main(String[] args) {		
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    keyStore.load(new FileInputStream("src/main/resources/bootsecurity.p12"), "123456789".toCharArray());
		     
		    Key pvtKey = keyStore.getKey("bootsecurity", "123456789".toCharArray());
		    java.security.cert.Certificate[] chain =  keyStore.getCertificateChain("bootsecurity");
		     
		    KeyStore jksStore = KeyStore.getInstance("JKS");
		    jksStore.load(null, null);;
		    jksStore.setKeyEntry("jksPrivate", pvtKey, "123456".toCharArray(), chain);
		    jksStore.store(new FileOutputStream("src/main/resources/output.jks"), "123456".toCharArray());
		} catch (Exception ex){
		    ex.printStackTrace();
		}
		
	}

}
