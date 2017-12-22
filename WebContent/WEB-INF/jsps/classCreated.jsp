<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">

<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse">
 
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/createOffer">Create Offer</a></li>
      <li><a href="${pageContext.request.contextPath}/CreateClass">Create Class</a></li>
      <li><a href="${pageContext.request.contextPath}/CreateStudent">Create Student</a></li>
      <li><a href="${pageContext.request.contextPath}/fileUpload">File Upload</a></li>     
     </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/createOffer"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a href="#"> LogOut</a></li>
    </ul>
  </div>
</nav>
		created Successfully
	<table id="customers"">
	
		<tr>
			<th>ID</th>
			<th>Name</th>
			
			<th>Action</th>
		</tr>
		
		<c:forEach var="row" items="${classes}">
			<tr>
			    <td> ${row.id}</td>
			  	 <td> ${row.name}</td>
			  
			    <td>
					<button type="button" class="btn btn-secondary">
						<a style="color: black;" href="editStudentClass?id=${row.id}">Edit</a>
					</button> 
					<button type="button" class="btn btn-danger">
						<a style="color: black;" onclick="return confirm('Are you sure you want to delete this user?')"
						href="deleteStudentClass?id=${row.id}">Remove</a>
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>

	
</body>
</html>