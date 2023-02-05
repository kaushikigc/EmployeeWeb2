<%@page import="com.exavalu.services.RoleService"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="com.exavalu.empweb.entities.Roles"%>
<%@page import="com.exavalu.empweb.entities.Employee"%>
<%@page import="com.exavalu.empweb.entities.Department"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Add Employee</title>      
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/sign-in.css" rel="stylesheet"> 
        <link href="css/menu.css" rel="stylesheet">  
        <link href="css/product.css" rel="stylesheet">  
        <!-- Custom styles for this template -->
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
       
            <form action="AddEmployee" method="Post">
            <main class="form-signin w-100 m-auto">

                <img class="mb-4" src="images/logo.PNG" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">Please add employee data</h1>
               
             
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="firstName" name="firstName" required>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="lastName" name="lastName" required>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" required>
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone" required>
                    <label for="floatingInput">Phone</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" required>
                    <label for="floatingInput">Gender</label>
                </div>
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingInput" placeholder="age" name="age" required>
                    <label for="floatingInput">Age</label>
                </div>
                <div class="form-floating">
                    <%ArrayList deptList = DepartmentService.getAllDepartment();
                        Iterator itr = deptList.iterator();%>
                    <select name="deptId" class="form-select" id="deptId">
                        <option value="0">Select a Department</option>
                        <%
                            while (itr.hasNext()) {
                                Department dept = (Department) itr.next();
                        %>
                        <option value=<%=dept.getDeptId()%>> <%=dept.getDepartmentName()%>  </option>
                        <% } %>  <label for="floatingInput">Department</label>
                    </select>
                </div>
                <div class="form-floating">
                       <%ArrayList roleList = RoleService.getAllRoles();
                      
              Iterator itr2 = roleList.iterator();%>
                <select name="roleId" class="form-select" id="roleId">
                    <option value="0">Select a Role</option>
                    <%
                        while (itr2.hasNext()) {
                            Roles role = (Roles) itr2.next();
                    %>
                   <option value=<%=role.getRoleId()%>> <%=role.getRoleName()%>  </option>
                    <% }%>  <label for="floatingInput">Role</label>
                </select>
                </div>
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" required>
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingInput" placeholder="carAllowance" name="carAllowance" required>
                    <label for="floatingInput">Car Allowance</label>
                </div>
 
                <button class="w-100 btn btn-lg btn-primary" type="submit">Add Employee</button>

            </form>
        </main>


    </body>
</html>
