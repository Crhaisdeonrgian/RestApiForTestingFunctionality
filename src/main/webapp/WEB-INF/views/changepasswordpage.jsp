<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<html>
<head>
    <title>Change</title>
</head>
<body>

<div align="center">

    <h1>Reset Password</h1>
    <c:if test = "${param.notMatched != null}">
        <i style = "color: darkred">Passwords does not match!</i>
    </c:if>
    <c:if test = "${param.invalidPassword != null}">
    <i style = "color: darkred">Invalid old password!</i>
    </c:if>
    <form:form action="save-password" method="POST">
        <label>Old Password</label>
        <form:input path="oldPassword"/>
        <br/>
        <label>New Password</label>
        <form:input path="newPassword"/>
        <br/>
        <label>Confirm Password</label>
        <form:input path="confirmPassword"/>
        <br/>
        <input type="submit" value = "Change Password"/>
    </form:form>

</div>


</body>
</html>
