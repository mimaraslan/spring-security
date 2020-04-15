package com.mimaraslan;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;

public class _006_LoadCertificateChain {

	public static void main(String[] args) {
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    keyStore.load(new FileInputStream("src/main/resources/output.p12"), "123456789".toCharArray());
		     
		    Key pvtKey = keyStore.getKey("output", "123456789".toCharArray());
		    System.out.println(pvtKey.toString());
		     
		    java.security.cert.Certificate[] chain =  keyStore.getCertificateChain("output");
		    for(java.security.cert.Certificate cert:chain){
		        System.out.println(cert.toString());
		    }
		} catch (Exception ex){
		    ex.printStackTrace();
		}
	}

}
