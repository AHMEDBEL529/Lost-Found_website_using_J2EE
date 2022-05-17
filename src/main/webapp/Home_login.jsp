<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
 <h2>Home Page</h2>
 Welcome <%=request.getAttribute("userName") %> <!-- Refer to the video to understand how this works -->
 <div style="text-align: right"><a href="/lost_and_found/LogoutServlet">Logout</a></div>
 <div style="text-align: left"><a href="/lost_and_found/DeclareFoundItemServlet">Insert Found Item</a></div>
 <div style="text-align: left"><a href="/lost_and_found/ShowFoundItemsServlet">Take a look at Found Items</a></div>
</body>
</html>