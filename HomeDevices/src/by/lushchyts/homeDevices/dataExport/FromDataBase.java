package by.lushchyts.homeDevices.dataExport;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;

public class FromDataBase {

    public void establichConection(){

        String url=("jdbc:sqlserver:DESKTOP-2AFDCIK\\SQLEXPRESS:1433;databaseName=HomeDevices");
        String login="DESKTOP-2AFDCIK\\Uladzimir";
        String password="";
        String sql = "Select * from dbo.Devices";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found!");
        }

        try {
            Connection connection = DriverManager.getConnection(url,login,password);
            PreparedStatement statement = connection.prepareStatement(sql);
        }catch(SQLException e){
            System.out.println("Connection is not established!");
        }
    }
}
