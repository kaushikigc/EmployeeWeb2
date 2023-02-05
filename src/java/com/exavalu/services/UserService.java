/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.empweb.entities.User;
import com.exavalu.empweb.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
 public static boolean doLogin(String emailAddress, String password) {

        boolean result = false;
     Connection con = JDBCConnectionManager.getMySQLConnection();

        String sql = "Select * from users where emailAddress=? and password=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setString(2, password);
            System.out.println("sql="+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                result=true;
            }
           } catch (SQLException ex) {
            ex.printStackTrace();
        }
return result;}
    public static User getUser(String emailAddress) {
        User user= new User();
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "Select * from users where emailAddress=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emailAddress);
            System.out.println("sql="+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
            }
        } catch (SQLException ex) {
        }return user;
    }
}
        
   

