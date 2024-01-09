package com.uni.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
     static Connection con=null;
     public static Connection getConnection()
     {
         try
         {
             if(con != null || con.isClosed())
             {
                 Class.forName(DBProperities.DRIVER);
                 con = DriverManager.getConnection(DBProperities.DB_USERNAME,DBProperities.DB_PASSWORD,DBProperities.URL);
             }
         }
         catch(SQLException | ClassNotFoundException e)
         {
             System.out.println(e.toString());
         }
         return con;
     }
}
