/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlets;

import com.exavalu.empweb.entities.Employee;
import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.RoleService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class AddEmployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String employeeId = request.getParameter("employeeId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String deptId = request.getParameter("deptId");
        //String departmentName = request.getParameter("departmentName");
        //String roleName = request.getParameter("roleName");
        String roleId = request.getParameter("roleId");
        String basicSalary = request.getParameter("basicSalary");
        String carAllowance = request.getParameter("carAllowance");

        boolean result;
        //boolean result=UserService.doRegister(emailAddress,password,firstName,lastName);
        Employee emp = new Employee();

        //emp.setEmployeeId(employeeId);
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPhone(phone);
        emp.setAddress(address);
        emp.setGender(gender);
        emp.setAge(age);
        emp.setDeptId(deptId);
         //emp.setDepartmentName(departmentName);
         
       emp.setRoleId(roleId);
         //emp.setRoleName(roleName);
        emp.setBasicSalary(basicSalary);
        emp.setCarAllowance(carAllowance);

        result = EmployeeService.AddEmployee(emp);

        if (result) {
//            String successMsg = "congratulations your information Added to database";
//            request.setAttribute("SuccessMsg", successMsg);
           // String employeeId = request.getParameter("employeeId");
            
           ArrayList emplist = EmployeeService.getAllEmployees();
           request.setAttribute("EmpList", emplist);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            String errorMsg = "Not Added";
            request.setAttribute("ErrorMsg", errorMsg);
            request.getRequestDispatcher("add.jsp").forward(request, response);
            

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
