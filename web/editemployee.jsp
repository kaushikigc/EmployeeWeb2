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
        <title>Employee Management</title>      
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/sign-in.css" rel="stylesheet">  
        <link href="css/menu.css" rel="stylesheet">  
        <link href="css/product.css" rel="stylesheet">  
        <!-- Custom styles for this template -->
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <main class="form-signin w-100 m-auto">

            <% Employee emp = (Employee) request.getAttribute("Emp");%>

            <form action="SaveEmployee" method="Post">

                <img class="mb-4" src="images/logo.PNG" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">Please edit employee data</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="employeeId" value=<%=emp.getEmployeeId()%> readonly>
                    <label for="floatingInput">Employee Id</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=<%=emp.getFirstName()%>>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=<%=emp.getLastName()%>>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" value=<%=emp.getAddress()%>>
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone" value=<%=emp.getPhone()%>>
                    <label for="floatingInput">Phone</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" value=<%=emp.getGender()%>>
                    <label for="floatingInput">Gender</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" value=<%=emp.getAge()%>>
                    <label for="floatingInput">Age</label>
                </div>
                     <div class="form-floating">
                    <%ArrayList deptList = (ArrayList) request.getAttribute("DeptList");
                    Iterator itr = deptList.iterator();%>
                    <select name="deptId" class="form-select" id="deptId">
                        <option value=<%=emp.getDeptId()%>><%=emp.getDepartmentName()%></option>
                        <%
                            while (itr.hasNext()) {
                                Department dept = (Department) itr.next();
                        %>
                        <option value=<%=dept.getDeptId() %>> <%=dept.getDepartmentName() %>  </option>
                        <% } %>
                    </select>
                    <label for="floatingInput">Department</label>
               
                </div>
                 <div class="form-floating">
                    <%ArrayList roleList = (ArrayList) request.getAttribute("RoleList");
                       Iterator itr2 = roleList.iterator();%>
                    <select name="roleId" class="form-select" id="roleId">
                        <option value=<%=emp.getRoleId()%> ><%=emp.getRoleName()%></option>
                        <%
                            while (itr2.hasNext()) {
                                Roles role = (Roles) itr2.next();
                        %>
                        <option value=<%=role.getRoleId() %>> <%=role.getRoleName() %>  </option>
                        <% } %>
                    </select>
                    <label for="floatingInput">Role Name</label>
                </div>
               
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" value=<%=emp.getBasicSalary()%>>
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="carAllowance" name="carAllowance" value=<%=emp.getCarAllowance()%>>
                    <label for="floatingInput">Car Allowance</label>
                </div>
<!--                    <input type="hidden" name="employeeId" value=<%=emp.getEmployeeId()%>>-->

                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

            </form>
        </main>
    </body>
</html>
