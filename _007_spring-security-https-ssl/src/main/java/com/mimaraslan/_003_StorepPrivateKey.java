package com.mimaraslan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.security.cert.Certificate;

import javax.security.cert.*;
//  https://www.pixelstech.net/article/1420427307-Different-types-of-keystore-in-Java----PKCS12
public class _003_StorepPrivateKey {

	public static void main(String[] args) {
	
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		//  keyStore.load(new FileInputStream("output.p12"),"password".toCharArray());
		    keyStore.load(null, null);;
		     
//		    CertAndKeyGen gen = new CertAndKeyGen("RSA","SHA1WithRSA");
//		    gen.generate(1024);
//		      
//		    X509Certificate cert=gen.getSelfCertificate(new X500Name("CN=ROOT"), (long)365*24*3600);
//		      
//		    keyStore.setCertificateEntry("cert", cert);
//		      
//		    keyStore.store(new FileOutputStream("output.p12"), "password".toCharArray());
		}catch(Exception ex){
		    ex.printStackTrace();
		}
		
	}

}
