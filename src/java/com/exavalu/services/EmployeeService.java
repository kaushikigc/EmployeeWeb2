/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.empweb.entities.Employee;
import com.exavalu.empweb.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author HP
 */
public class EmployeeService {

  public static ArrayList getAllEmployees() {
 ArrayList empList = new ArrayList();
 try {
            
            Connection con = JDBCConnectionManager.getMySQLConnection();
             String sql = "select * from employees e, department d, roles r where e.deptId=d.deptId and e.roleId=r.roleId ";
            
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println("sql="+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            //We will pick up the list of Employees from DB and send these to frontend
            while(rs.next())
            {Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));
                empList.add(emp);}
         } 
        catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("Number of employees = "+empList.size());
        return empList;
    }
  public static Employee getEmployee(String employeeId) {
    Employee emp = new Employee();
try {
 Connection con = JDBCConnectionManager.getMySQLConnection();
 String sql = "select * from employees e, department d, roles r "
+ "where e.deptId=d.deptId and e.roleId=r.roleId and e.employeeId =?";
PreparedStatement preparedStatement = con.prepareStatement(sql);
preparedStatement.setString(1, employeeId);
//System.out.println("Sql="+preparedStatement);
ResultSet rs = preparedStatement.executeQuery();
while (rs.next()) {
emp.setAddress(rs.getString("address"));
emp.setEmployeeId(rs.getString("employeeId"));
emp.setFirstName(rs.getString("firstName"));
emp.setLastName(rs.getString("lastName"));
emp.setPhone(rs.getString("phone"));
emp.setGender(rs.getString("gender"));
emp.setAge(rs.getString("age"));
emp.setDeptId(rs.getString("deptId"));
//emp.setRoleId(rs.getString("roleId"));
emp.setDepartmentName(rs.getString("departmentName"));
emp.setRoleName(rs.getString("roleName"));
emp.setBasicSalary(rs.getString("basicSalary"));
emp.setCarAllowance(rs.getString("carAllowance"));
}
} catch (SQLException ex) {
ex.printStackTrace();
}return emp;
}
  public static boolean updateEmployee(Employee emp, String employeeId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            
            String sql = "UPDATE employeedb.employees\n"
                    + "SET firstName = ? , lastName = ? , phone = ? , address = ? ,\n"
                    + "gender = ? , age = ? , basicSalary = ?,carAllowance=?,deptId = ?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
             preparedStatement.setDouble(7, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(8, Double.parseDouble(emp.getCarAllowance()));
            preparedStatement.setString(9, emp.getDeptId());
               preparedStatement.setString(10, employeeId);
            int row = preparedStatement.executeUpdate();

            if(row==1)
            {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

//
    public static ArrayList Search2(String firstName, String lastName, String gender,String deptId, String roleId) {
         boolean result = true;
       //Employee emp = new Employee();
       ArrayList empList=new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
          String sql = "select * from employees e, department d, roles r "
                    + "where e.deptId=d.deptId and e.roleId=r.roleId having firstName like ? and lastName like ? and gender like ? and d.deptId like ? and r.roleId like ? order by employeeId";
       
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, firstName + "%");
            preparedStatement.setString(2, lastName+"%");
            preparedStatement.setString(3, gender + "%");
            if(deptId.equals("0")){
                preparedStatement.setString(4, "%");
            }
            else{
                preparedStatement.setString(4, deptId+"%");
            }
            if(roleId.equals("0")){
                preparedStatement.setString(5, "%");
            }
            else{
                preparedStatement.setString(5,roleId+"%");
            }
            
            ResultSet rs = preparedStatement.executeQuery();
             
            while (rs.next()) {
                  Employee emp1 = new Employee();
                
                emp1.setEmployeeId(rs.getString("employeeId"));
                emp1.setFirstName(rs.getString("firstName"));
                emp1.setLastName(rs.getString("lastName"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setAddress(rs.getString("address"));
                emp1.setGender(rs.getString("gender"));
                emp1.setAge(rs.getString("age"));
                emp1.setBasicSalary(rs.getString("basicSalary"));
                emp1.setCarAllowance(rs.getString("carAllowance"));
                emp1.setDepartmentName(rs.getString("departmentName"));
                emp1.setRoleName(rs.getString("roleName"));

                empList.add(emp1);

            
            }
           // if(emp.getFirstName()==null ||emp.getLastName()==null || emp.getGender()==null)
                //result=false;
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
        

        return empList;
        
    }
      public static ArrayList getLimitedEmployee(int limit, int page) {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
           
            String sql = "SELECT * FROM employeedb.employees JOIN department ON employees.deptId =department.deptId join role on employees.roleId = role.roleId LIMIT ? OFFSET ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, page*limit);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));

                empList.add(emp);
            }

        } catch (SQLException ex) {

        }
        return empList;
    }

 public static boolean AddEmployee(Employee emp) {
    
        boolean result = false;
       

        try {

            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "INSERT INTO employees (firstName,lastName,phone,address,gender,age,deptId,roleId,basicSalary,carAllowance)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(sql);
           //preparedStatement.setString(1, employeeId);
           // System.out.println(employeeId);
            preparedStatement.setString(1,  emp.getFirstName());
         preparedStatement.setString(2,emp.getLastName() );
           
            preparedStatement.setString(3, emp.getPhone());
          
            preparedStatement.setString(4, emp.getAddress());
            
            preparedStatement.setString(5, emp.getGender());
           
            preparedStatement.setString(6, emp.getAge());
           
            preparedStatement.setString(7, emp.getDeptId());
            //preparedStatement.setString(7, departmentName);
           // System.out.println(departmentId);
            //preparedStatement.setString(8, roleName);
           // System.out.println(roleId);
           preparedStatement.setString(8, emp.getRoleId());
           // System.out.println(roleId);
            preparedStatement.setString(9, emp.getBasicSalary());
          
            preparedStatement.setString(10, emp.getCarAllowance());
            System.out.println("sql="+preparedStatement);

            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
      
            
               
}          
//We will pick up the list of Employees from DB and send these to frontend
      

