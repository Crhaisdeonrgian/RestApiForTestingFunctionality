<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %><html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<head>
    <title>Title</title>
</head>
<body>
<%--
<h1 style="text-align: right">HELLO, ${username}!</h1>
<br/>
--%>
<h1 style="text-align: center">${category}</h1>
<br/>
<c:forEach items = "${list}" var ="product">

    <tr>
        <td><a href="${pageContext.request.contextPath}/productinfo?code=${product.code}">${product.name}</a></td>
    </tr>
    <br/>
</c:forEach>
<br/>
<a href="/SpringSecurityAppHibernateCustomDB_war_exploded/hello">GO BACK SHOPPING</a>
<br/>

</body>

</html>
