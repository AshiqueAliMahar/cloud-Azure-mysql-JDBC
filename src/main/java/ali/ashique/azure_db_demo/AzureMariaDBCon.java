package ali.ashique.azure_db_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AzureMariaDBCon {

	public static void main(String[] args) {

		
//		String importCert = " -import "+
//		    " -alias mysqlServerCACert "+
//		    " -file " + ssl_ca +
//		    " -keystore truststore "+
//		    " -trustcacerts " + 
//		    " -storepass password -noprompt ";
//		String genKey = " -genkey -keyalg rsa " +
//		    " -alias mysqlClientCertificate -keystore keystore " +
//		    " -storepass password123 -keypass password " + 
//		    " -dname CN=MS ";
//		sun.security.tools.keytool.Main.main(importCert.trim().split("\\s+"));
//		sun.security.tools.keytool.Main.main(genKey.trim().split("\\s+"));
//
//		
//		System.setProperty("javax.net.ssl.keyStore","path_to_keystore_file");
//		System.setProperty("javax.net.ssl.keyStorePassword","password");
//		System.setProperty("javax.net.ssl.trustStore","path_to_truststore_file");
//		System.setProperty("javax.net.ssl.trustStorePassword","password");
//
//		url = String.format("jdbc:mariadb://%s/%s?useSSL=true&trustServerCertificate=true", 'mydemoserver.mariadb.database.azure.com', 'quickstartdb');
//		properties.setProperty("user", 'myadmin@mydemoserver');
//		properties.setProperty("password", 'yourpassword');
//		conn = DriverManager.getConnection(url, properties);
		
		
		String url ="jdbc:mariadb://itcenter.mariadb.database.azure.com:3306/it_center?useSSL=false";
		 
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection  myDbConn =DriverManager.getConnection(url, "demo@itcenter", "Password12345");
			System.out.println("connected");
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
