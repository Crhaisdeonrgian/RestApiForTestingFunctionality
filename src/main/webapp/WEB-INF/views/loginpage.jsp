
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<html>
<head>
    <title>login</title>
</head>
<body>



    <h1>Please enter your username and password</h1>
    <br/>
    <a href="/SpringSecurityAppHibernateCustomDB_war_exploded/">Return to home page</a>
    <br/>
    <c:if test="${param.logout != null}">
        <i style = "color: greenyellow">You've been successfully logged out.</i>
    </c:if>
    <form:form action="process-login" method="POST">

      Username : <input type="text" name="username">
      <br/>
      Password : <input type = "text" name = "password">
        <br/>
      <input type = "submit" value = "<<<Login>>>">
        <c:if test="${param.error != null}">
            <i style = "color: darkred">Invalid login or password</i>
        </c:if>
    </form:form>
    haven't got an account yet? <a href="/SpringSecurityAppHibernateCustomDB_war_exploded/signup">Create new one!</a>
</body>
</html>
