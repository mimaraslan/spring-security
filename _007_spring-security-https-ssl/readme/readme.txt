WINDOWS
cd C:\Program Files\Java\jdk1.8.0_231\bin
.\keyto001 -genkeypair -alias bootsecurity -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore bootsecurity.p12 -validity 3650


MACOS
sudo su
cd /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/bin/
cd /Library/Java/JavaVirtualMachines/jdk-11.0.4.jdk/Contents/Home/bin/
keytool -genkeypair -alias bootsecurity -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore bootsecurity.p12 -validity 3650


UBUNTU
sudo su
cd /usr/lib/jvm/java-11-openjdk-amd64/bin/
.\keytool -genkeypair -alias bootsecurity -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore bootsecurity.p12 -validity 3650

 
 