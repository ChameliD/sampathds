package com.example.sampathds.dto;

public class LoginRequest
{
    private String username;
    private String password;

    public String getUserName()
    {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
