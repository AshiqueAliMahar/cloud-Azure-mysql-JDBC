package ali.ashique.azure_db_demo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class App {

    public static void main(String[] args) {

        // Connect to database
        String hostName = "oracleserver.database.windows.net"; // update me
        String dbName = "mySampleDatabase."; // update me
        String user = "azureuser"; // update me
        String password = "Azure1234567"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://oracleserver.database.windows.net:1433;database=mySampleDatabase;user=azureuser@oracleserver;password={Azure1234567};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            String selectSql = "select * from dbo.BuildVersion";

            try (Statement statement = connection.createStatement();
            	ResultSet resultSet = statement.executeQuery(selectSql)) {
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1) + " "+ resultSet.getString(2)+ " "+ resultSet.getString(3)+ " "+ resultSet.getString(4));
                }
                connection.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}