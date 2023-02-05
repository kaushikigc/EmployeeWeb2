/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlets;

import com.exavalu.empweb.entities.User;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Here we will do our business logic
        //Here we Should try to code minimise as much as possible
        //Retrieve the params sent from frontend 
        String emailAddress = request.getParameter("emailAddress");
       String password = request.getParameter("password");
        // we will use this two param to see if user is valid or not
       // we need to check against our database table

       boolean result = UserService.doLogin(emailAddress, password);
        if(result)
        {
            HttpSession session = request.getSession();
              // we need to check against our database table
       //We will pick up the list of Employees from DB and send these to frontend
       User user = UserService.getUser(emailAddress);
            user.setEmailAddress(emailAddress);
            user.setPassword(password);  
              session.setAttribute("User", user);
        ArrayList empList = EmployeeService.getAllEmployees();
       request.setAttribute("EmpList", empList);
//             session.setAttribute("User", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            String errorMsg ="Either email address or password is wrong!! Please try again";
           request.setAttribute("ErrorMsg",errorMsg);
           request.getRequestDispatcher("login.jsp").forward(request, response);}
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
