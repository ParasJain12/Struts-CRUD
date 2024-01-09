package com.uni.dao;

import com.uni.connection.GetConnection;
import com.uni.controller.MyController;
import com.uni.dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
   public static UserDTO loginUser(MyController m)
   {
       Connection con;
       UserDTO ut = null;
       try
       {
           con = GetConnection.getConnection();
           if(con != null)
           {
               String sql = "select * from user where username=? and password=?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1,m.getUsername());
               ps.setString(2,m.getPassword());
               ResultSet rs = ps.executeQuery();
               if(rs.next())
               {
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   String username = rs.getString("username");
                   String email = rs.getString("email");
                   String password = rs.getString("password");
                   String mobile = rs.getString("mobile");
                   int type = rs.getInt("type");
                   ut = new UserDTO(id,type,name,username,email,password,mobile);
               }
           }
           else{
               System.out.println("Login Connection Failed...");
           }
       }
       catch(Exception e)
       {
           System.out.println(e.toString());
       }
       return ut;
   }
}
