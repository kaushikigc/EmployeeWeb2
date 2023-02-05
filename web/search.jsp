
<%@page import="com.exavalu.empweb.entities.Roles"%>
<%@page import="com.exavalu.empweb.entities.Department"%>
<%@page import="com.exavalu.empweb.entities.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

 <%if(request.getSession().getAttribute("User") == null) 
    request.getRequestDispatcher("login.jsp").forward(request, response);
%>

<!doctype html>
<html lang="en">
<head>        
<title>Employee Management Web Application</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/product.css" rel="stylesheet">
<link href="css/sign-in.css" rel="stylesheet">
</head>
 <jsp:include page="menu.jsp"></jsp:include>
  <% Employee emp = (Employee)request.getAttribute("Emp"); %>
    <form action="Search2" method="Post">
    
    <table class = "table table-bordered">
        <thead style="background-color: #D3D3D3">
        <tr style = "color:black">
        
        <th scope = "col">
            First Name
        </th>
        <th scope = "col">
            Last Name
        </th>
        
        <th scope = "col">
            Gender
        </th>
        
        <th scope = "col">
            Department
        </th>
        <th scope = "col">
            Role
        </th>
        

    </tr>
        <thead>
    
        <tbody>
    <tr>
        <td>
            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" placeholder="Enter first name" name="firstName">
                <label for="floatingInput">Enter First Name</label>
            </div>
        </td>
        <td>
            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" placeholder="Last Name" name="lastName">
                <label for="floatingInput">Enter Last Name</label>
            </div>
        </td>
        <td>
            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender">
                <label for="floatingInput">Enter Gender</label>
            </div>
        </td>
        <td>
            <div class="form-floating">

                <%ArrayList deptList = (ArrayList) request.getAttribute("DeptList");
              Iterator itr = deptList.iterator();%>

                <select name="deptId" class="form-select" id="deptId">
                    <option value="0">Select a Department</option>
                    <%
                        while (itr.hasNext()) {
                            Department dept = (Department) itr.next();
                    %>
                    <option value=<%=dept.getDeptId()%>> <%=dept.getDepartmentName()%>  </option>

                    <% }%>
                </select>
            </div>
        </td>
        <td>
            <div class="form-floating">
                <%ArrayList roleList = (ArrayList) request.getAttribute("roleList");
              Iterator itr2 = roleList.iterator();%>
                <select name="roleId" class="form-select" id="roleId">
                    <option value="0">Select a Role</option>
                    <%
                        while (itr2.hasNext()) {
                            Roles role = (Roles) itr2.next();
                    %>
                    <option value=<%=role.getRoleId()%>> <%=role.getRoleName()%>  </option>
                    <% }%>
                </select>
            </div>
        </td>
        </tr>
    
        </tbody>

    



</table>
                
                <div>
    <button class="w-100 btn btn-sm btn-primary" style="background-color: blueviolet; border: none" type="submit">Search in Database</button>
                </div>
    </form>
<!--<a href="SearchEmployeesDB" style="background-color: #8B0000; color: white;padding: 10px 180px;text-align: center;text-decoration: none; margin-left: 60%; border-radius: 15px;">Search</a>-->




</html>