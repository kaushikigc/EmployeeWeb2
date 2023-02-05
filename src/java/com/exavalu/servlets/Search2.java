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
public class Search2 extends HttpServlet {

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
       Employee emp = new Employee();
        emp.setFirstName(request.getParameter("firstName"));
        emp.setLastName(request.getParameter("lastName"));
        emp.setGender(request.getParameter("gender"));
        emp.setDeptId(request.getParameter("deptId"));
        emp.setRoleId(request.getParameter("roleId"));
        
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String gender= request.getParameter("gender");
        String deptId = request.getParameter("deptId");
        String roleId = request.getParameter("roleId");
        ArrayList empList  = EmployeeService.Search2(firstName, lastName, gender, deptId, roleId);
        
        if(!empList.isEmpty()){
            request.setAttribute("EmpList", empList);
            request.getRequestDispatcher("search2.jsp").forward(request, response);
        }
        else{
            ArrayList deptList = DepartmentService.getAllDepartment();
            ArrayList roleList = RoleService.getAllRoles();
            Employee emp1 = new Employee();
            request.setAttribute("Emp", emp1);
            request.setAttribute("DeptList", deptList);
            request.setAttribute("roleList", roleList);
            request.getRequestDispatcher("search.jsp").forward(request, response);
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
