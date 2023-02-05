/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlets;

import com.exavalu.services.CreatingAccount;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.UserService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author gaura
 */
public class SignUp extends HttpServlet {

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
        
         String emailAddress = request.getParameter("emailAddress");
         
         if(emailAddress==null)
         {
           request.getRequestDispatcher("SignUp.jsp").forward(request, response);  
         }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    
       String password = request.getParameter("password");
       String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
//         
CreatingAccount.doSignUp(emailAddress, firstName, lastName, password);
//         String employeeId = request.getParameter("employeeId");
//          String firstName = request.getParameter("firstName");
//           String lastName = request.getParameter("lastName");
//            String address = request.getParameter("address");
//             String phone = request.getParameter("phone");
//              String gender = request.getParameter("gender");
//               String age = request.getParameter("age");
//                String deptId = request.getParameter("deptId");
//                 String roleId = request.getParameter("roleId");
//                  String basicSalary = request.getParameter("basicSalary");
//                   String carAllowance = request.getParameter("carAllowance");
//        CreatingAccount.doSignUp2(employeeId, firstName, lastName,address, phone,gender,age,deptId,roleId,basicSalary, carAllowance);
//        
          request.getRequestDispatcher("login.jsp").forward(request, response);
       // we will use this two param to see if user is valid or not
       // we need to check against our database table
//       boolean result = UserService.doLogin(emailAddress, password);
//        if(result)
//        {
//           request.getRequestDispatcher("home.jsp").forward(request, response); 
//        }
//        else{
//            String errorMsg ="Either email address or password is wrong!! Please try again";
//            request.setAttribute("ErrorMsg",errorMsg);
            
//        }
//         ArrayList  empList = EmployeeService.getAllEmployees();
//        request.setAttribute("EmpList", empList);
 
//        if(result)
//        {
//            HttpSession session = request.getSession();
//
//            User user = UserService.getUser(emailAddress);
//            user.setEmailAddress(emailAddress);
//            user.setPassword(password);          
//
//            session.setAttribute("User", user);
//
//            request.getRequestDispatcher("home.jsp").forward(request, response);
//
////            
////HttpSession session = request.getSession();
////User user = new User();s
////user.setEmailAddress(emailAddress);
////user.setPassword(password);
////session.setAttribute("User", user);
////
////
////
////           request.getRequestDispatcher("home.jsp").forward(request, response); 
//        }
//    
//     else{
//           String errorMsg ="Either email address or password is wrong!! Please try again";
//          request.setAttribute("ErrorMsg",errorMsg);
//           request.getRequestDispatcher("login.jsp").forward(request, response);
//       }
       
       
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
