<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
  <h2>Join Input</h2>
  <form action="./memberLogin" method="post">
  
   <div class="form-group">
      <label class="control-label col-sm-2" for="id">ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id"><br>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pw">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pw" placeholder="Enter password" name="upw">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    
    

  </form>
</div>
	
	
	     
</div>
</body>
</html>