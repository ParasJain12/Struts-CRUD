package com.uni.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.uni.dao.LoginDao;
import com.uni.dto.UserDTO;

public class MyController extends ActionSupport {
      private String username;
      private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String register()
    {
        return "success";
    }
    public String login()
    {
        UserDTO u;
        String data = null;
        try{
            u = LoginDao.loginUser(this);
            if(u != null)
            {
                if(u.getType() == 1)
                {
                    data = "admin";
                }
                else if(u.getType() == 2)
                {
                    data = "success";
                }
            }
            else{
                data = "error";
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return data;
    }
    public String insertUser()
    {
        return "success";
    }
}
