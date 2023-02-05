/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.empweb.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gaura
 */
public class CreatingAccount {

 

    public static void doSignUp(String emailAddress,String firstName,String lastName, String password) {

      
        Connection con = JDBCConnectionManager.getMySQLConnection();

        String sql = "INSERT INTO employeedb.users(emailAddress,password,firstName,lastName,status)VALUES (?,? ,? ,? ,1 );";

        try {
              PreparedStatement preparedStatement = con.prepareStatement(sql);
              preparedStatement.setString(1, emailAddress);
              preparedStatement.setString(2, password);
              preparedStatement.setString(3, firstName);
              preparedStatement.setString(4, lastName);
              preparedStatement.executeUpdate();
            } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//public static void doSignUp2(String employeeId,String firstName,String lastName, String address, String phone, String gender,String age,String deptId,String roleId,String basicSalary,String carAllowance) {
//    
//        Connection con = JDBCConnectionManager.getMySQLConnection();
//
//
//        String sql2 = "INSERT INTO employeedb.employees(employeeId,firstName,lastName,address,phone,gender,age,deptId,roleId,basicSalary,carAllowance)VALUES (?,? ,? ,? ,1 );";
//
//        try {
//              PreparedStatement preparedStatement = con.prepareStatement(sql2);
//              preparedStatement.setString(1, employeeId);
//              preparedStatement.setString(2, firstName);
//              preparedStatement.setString(3, lastName);
//              preparedStatement.setString(4, address);
//               preparedStatement.setString(5, phone);
//                preparedStatement.setString(6, gender);
//                 preparedStatement.setString(7, age);
//                  preparedStatement.setString(8, deptId);
//                   preparedStatement.setString(9, roleId);
//                            preparedStatement.setString(10, basicSalary);
//                             preparedStatement.setString(11, carAllowance);;
//              preparedStatement.executeUpdate();
//            } 
//        catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//}

}
        
   

