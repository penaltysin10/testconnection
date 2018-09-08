package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionClass {

    public static Connection getConnectionClass() throws Exception{
        Connection con = null;

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost/register_system", "root", "");
        return con;

    }

}
