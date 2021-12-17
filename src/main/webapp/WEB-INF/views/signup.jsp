
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<html>
<head>
    <title>SignUP</title>
</head>
<body>
<form:form action="process-signup" method="POST" modelAttribute="signupdto">

    Username : <input type="text" name="username">
    <br/>
    Password : <input type = "text" name = "password">
    <br/>
    <input type = "submit" value = "<<<SignUP>>">
</form:form>
</body>
</html>
