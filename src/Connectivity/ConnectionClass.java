package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public Connection connection;

    public Connection getConnection(){
        String dbName = "journal_app";
        String userName = "root";
        String password = "root";
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

}
