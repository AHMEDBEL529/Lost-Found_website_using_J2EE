<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
<div align="center">
	<h1><c:out value="${size}" /></h1>
	<c:forEach items="${items}" var="item">
  		<h2><c:out value="${item.category}" /></h2>
    	<h3><c:out value="${item.description}" /></h3>
    	<img src="data:image/jpg;base64,${item.base64Image}" width="240" height="300"/>
 	</c:forEach>
</div>
</body>
</html>