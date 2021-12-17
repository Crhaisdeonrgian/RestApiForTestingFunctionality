<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %><html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<head>
    <title>Cart</title>
</head>
<body>
<br/>
<h1>Your Shopping Card</h1>
<c:forEach items = "${list}" var ="order">
    <tr>
        <td><a href="${pageContext.request.contextPath}/productinfo?code=${order.product.code}">${order.product.name}</a></td>
        <td>${order.product.price}</td>
    <td>${order.quantity}шт</td>
    </tr>
    <br/>
</c:forEach>
<h3>Итого: <fmt:formatNumber value="${sum}" type="currency"/></h3>
<br/>
<form action="finish-cart" method="get">
    <input type="submit" value="ОФОРМИТЬ ЗАКАЗ">
</form>
<br/>
<a href="/SpringSecurityAppHibernateCustomDB_war_exploded/hello">GO BACK SHOPPING</a>
<br/>
</body>
</html>
