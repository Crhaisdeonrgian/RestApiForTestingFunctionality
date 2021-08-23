
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<html>
<head>
    <title>SignUP</title>
</head>
<body>
<form:form action = "process-signup" method = "POST" modelAttribute="signupdto">

    Username : <form:input path = "username"/>
    <br/>
    Password : <form:password path = "password"/>
    <br/>
    <input type="submit" value="signup"/>

</form:form>

</body>
</html>
