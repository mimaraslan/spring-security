package com.mimaraslan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.security.cert.Certificate;
import javax.security.cert.*;

//https://www.pixelstech.net/article/1420427307-Different-types-of-keystore-in-Java----PKCS12
public class _004_StoreCertificate {

	public static void main(String[] args) {
		
		try{
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		//  keyStore.load(new FileInputStream("output.p12"),"password".toCharArray());
		    keyStore.load(null, null);;
		     
//		    CertAndKeyGen gen = new CertAndKeyGen("RSA","SHA1WithRSA");
//		    gen.generate(1024);
//		      
//		    Key key=gen.getPrivateKey();
//		    X509Certificate cert=gen.getSelfCertificate(new X500Name("CN=ROOT"), (long)365*24*3600);
//		      
//		    X509Certificate[] chain = new X509Certificate[1];
//		    chain[0]=cert;
//		      
//		    keyStore.setKeyEntry("output", key, "123456789".toCharArray(), chain);
		      
		    keyStore.store(new FileOutputStream("src/main/resources/output.p12"), "123456789".toCharArray());
		}catch(Exception ex){
		    ex.printStackTrace();
		}
		
	}

}
