<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %><html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>ADMINZONE</title>
</head>
<body>
<h1 style="text-align: right">HELLO, ${username}!</h1>
<br/>

<h2>Товар out of stock:</h2>
<c:forEach items = "${list}" var ="product">

    <tr>

        <td>${product.code}</td>
        <td><a href="${pageContext.request.contextPath}/categoryproducts?category=${product.category}">${product.category}</a></td>
        <td><a href="${pageContext.request.contextPath}/productinfo?code=${product.code}">${product.name}</a></td>
        <td><fmt:formatNumber value="${product.price}" type="currency"/></td>
        <td>
            <form action="add-to-stock" method="get">
                <input type="hidden" name="code" value="${product.code}"/>
                <input min="1" name="quantity" step="1" type="number" value="1"/>
                <input type="submit" value="Add to stock"/>
            </form>
        </td>

    </tr>

    <br/>
</c:forEach>

<form:form action="logout" method = "POST">

    <input type="submit" value="logout(((">
</form:form>
</body>
</html>
