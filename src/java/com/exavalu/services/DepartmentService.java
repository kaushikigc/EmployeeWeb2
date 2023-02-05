/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.empweb.entities.Department;
import com.exavalu.empweb.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class DepartmentService {

    public static ArrayList getAllDepartment() {

        ArrayList deptList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getMySQLConnection();

            String sql = "Select * from department";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Department dept = new Department();
                
                dept.setDeptId(rs.getInt("deptId"));
                dept.setDepartmentName(rs.getString("departmentName"));
                
                deptList.add(dept);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return deptList;
    }

}
