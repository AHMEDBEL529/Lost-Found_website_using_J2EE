<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" href = "design.css" type = "text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script> 
function validate()
{ 
     var fullName = document.form.fullName.value;
     var email = document.form.email.value;
     var userName = document.form.userName.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     
     if (fullName==null || fullName=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (userName==null || userName=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
 } 
</script> 
</head>
<body>
    <div style="text-align:center" ><h1 > LOST AND FOUND APP </h1> </div>
    <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
        <table align="center"  style="text-align:center;width:40%" cellpadding="2" cellspacing="0">
         <tr>
         <td>Full Name</td>
         <td><input type="text" name="fullName" /></td>
         </tr>
         <tr>
         <td>Email</td>
         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
         <td>Username</td>
         <td><input type="text" name="userName" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td>Confirm Password</td>
         <td><input type="password" name="conpassword" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input style="margin: 0 10px;" type="submit" value="Register"></input>
         <input style="margin: 0 15px;"
         type="reset" value="Reset"></input></td>
         <tr>
         <td> Already a user? <a href="/lost_and_found/LoginServlet">log-in</a> to continue.</td>
         </tr>
         </tr>
        </table>
    </form>
</body>
</html>