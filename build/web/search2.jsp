
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

<body>

 

    <jsp:include page="menu.jsp"></jsp:include>



    <%
        ArrayList empList = (ArrayList) request.getAttribute("EmpList");
        Iterator itr = empList.iterator();
    %>
    <table class = "table table-bordered">
        <thead style="background-color: #D3D3D3">
        <tr style = "color:black">
        <th scope = "col">
            Employee Id
        </th>
        <th scope = "col">
            First Name
        </th>
        <th scope = "col">
            Last Name
        </th>
        <th scope = "col">
            Address
        </th>
        <th scope = "col">
            Phone
        </th>
        <th scope = "col">
            Gender
        </th>
        <th scope = "col">
            Age
        </th>
        <th scope = "col">
            Department
        </th>
        <th scope = "col">
            Role
        </th>
        <th scope = "col">
            Basic Salary
        </th>
        <th scope = "col">
            Car Allowance
        </th>
        <th>Action</th>
        

    </tr>
        <thead>
    <%
        while (itr.hasNext()) {
            Employee emp = (Employee) itr.next();
    %>
        <tbody>
    <tr>
        <td>
            <%=emp.getEmployeeId()%>
        </td>
        <td>
            <%=emp.getFirstName()%>
        </td>
        <td>
            <%=emp.getLastName()%>
        </td>
        <td>
            <%=emp.getAddress()%>
        </td>
        <td>
            <%=emp.getPhone()%>
        </td>
        <td>
            <%=emp.getGender()%>
        </td>
        <td>
            <%=emp.getAge()%>
        </td>
        <td>
            <%=emp.getDepartmentName()%>
        </td>
        <td>
            <%=emp.getRoleName()%>
        </td>
        <td>
            <%=emp.getBasicSalary()%>
        </td>
        <td>
            <%=emp.getCarAllowance()%>
        </td>
        <td><a style="color:#8B0000" href=EditEmployee?employeeId=<%=emp.getEmployeeId()%>>Edit</a></td>
        
    </tr>
    
        </tbody>

    <%
        }
    %>



</table>




</body>
</html>