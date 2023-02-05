
<%-- 
    Document   : searchresult
    Created on : 25-Jan-2023, 1:35:40 pm
    Author     : user
--%>

<%@page import="com.exavalu.empweb.entities.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
                
        <title>Employee Management</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
      <link href="css/bootstrap.min.css" rel="stylesheet">-->
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">


    </head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Search Result</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="css/menu_css.css" rel="stylesheet">-->
        <!-- Custom styles for this template -->
        <!--<link href="css/product.css" rel="stylesheet">-->
       
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    </head>
    <body>

        
       <jsp:include page="menu.jsp"></jsp:include>
        
        <div class="container">
                <h3>Select Number Of Rows</h3>
                <div class="form-group"> 				
                    <select class  ="form-control" name="state" id="maxRows">
                        <option value="5000">Show ALL Rows</option>
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="15">15</option>
                        <option value="20">20</option>
                        <option value="50">40</option>
                        <option value="70">60</option>
                        
                    </select>		 		
                </div>
        
        
        <%
                    if (request.getAttribute("Success") != null) {
                %>
                <script src="vali.js"></script>
                <%}else{ %>
                <h4></h4>
               <% }%>
        
        
        <%
                ArrayList empList = (ArrayList) request.getAttribute("EmpList");
                Iterator itr = empList.iterator();
            %>
            <table class="table table-striped" id="table-id">
                <thead>
                    <tr>
                        <th scope="col">
                            Employee Id
                        </th>
                        <th scope="col">
                            First Name
                            </td>
                        <th scope="col">
                            Last Name
                        </th>


                        <th scope="col">
                            Gender
                        </th>
                        <th scope="col">
                            Phone
                            </td>
                        <th scope="col">
                            Address
                        </th>
                        <th scope="col">
                            Age
                        </th>
                        <th scope="col">
                            Basic Salary
                        </th>
                        <th scope="col">
                            Car Allowance
                        </th>
                        <th scope="col">
                            Department
                        </th>
                        <th scope="col">
                            Role
                            </td>
                        <th scope="col">
                            Action
                        </th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        while (itr.hasNext()) {
                            Employee emp = (Employee) itr.next();
                    %>

                    <tr>
                        <th scope="row">
                            <%=emp.getEmployeeId()%>
                        </th>
                        <td>
                            <%=emp.getFirstName()%>
                        </td>
                        <td>
                            <%=emp.getLastName()%>
                        </td>
                        <td>
                            <%=emp.getGender()%>
                        </td>
                        <td>
                            <%=emp.getPhone()%>
                        </td>
                        <td>
                            <%=emp.getAddress()%>
                        </td>
                        <td>
                            <%=emp.getAge()%>
                        </td>
                        <td>
                            <%=emp.getBasicSalary()%>
                        </td>
                        <td>
                            <%=emp.getCarAllowance()%>
                        </td>
                        <td>
                            <%=emp.getDepartmentName()%>
                        </td>
                        <td>
                            <%=emp.getRoleName()%>
                        </td>
                        <td>
                            <a href=EditEmployee?employeeId=<%=emp.getEmployeeId()%>>
                                Edit
                            </a>                     
                        </td>

                    </tr>
                </tbody>

                <%
                    }
                %>



            </table>

            <jsp:include page="pagination.jsp"></jsp:include>
        </div> <!-- 		End of Container -->
        
        <script src="pagination.js"></script>

    </body>
</html>
