<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
* {
    box-sizing: border-box;
}

input[type=text], select, textarea{
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    resize: vertical;
}

label {
    padding: 12px 12px 12px 0;
    display: inline-block;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

.col-25 {
    float: left;
    width: 25%;
    margin-top: 6px;
}

.col-75 {
    float: left;
    width: 75%;
    margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

media (max-width: 600px) {
    .col-25, .col-75, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}
</style>
</head>
<body>

<center> <h2>Create Class</h2></center> 
<div class="container">
 <form method="post" action="${pageContext.request.contextPath}/createclass"" name="submit" enctype="multipart/form-data">
		
 

    <div class="row">
      <div class="col-25">
        <label for="name"> Class Name</label>
        
     
      </div>
      <div class="col-75">
        
         <select class="form-control" id="name" name="name">
        <option>one</option>
        <option>two</option>
        <option>three</option>
        <option>four</option>
      </select>    
	     
      </div>
       <div class="col-75">
 		
			<input type="submit" name="submit" value="Submit">
  	 </div>
    </div>
  
  </form>
</div>
    </div>


</body>
</html>