/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.empweb.entities.Department;
import com.exavalu.empweb.entities.Roles;
import com.exavalu.empweb.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class RoleService {
     public static ArrayList getAllRoles() {
        ArrayList roleList = new ArrayList();
       
          try {

            Connection con = JDBCConnectionManager.getMySQLConnection();

            String sql = "Select * from roles";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Roles role = new Roles();
                
                role.setRoleId(rs.getInt("roleId"));
                role.setRoleName(rs.getString("roleName"));
                
                roleList.add(role);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return roleList;
    }

}

        
     
