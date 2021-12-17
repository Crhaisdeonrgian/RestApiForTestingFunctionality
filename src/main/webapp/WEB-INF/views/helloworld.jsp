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
<h1 style="text-align: right">HELLO, ${username}!</h1>
<br/>
<h2 style="text-align: right">Сумма покупок: <fmt:formatNumber value="${sum}" type="currency"/></h2>
<br/>
<a href="${pageContext.request.contextPath}/cart">Перейти в корзину</a>
<br/>
<form action="clear-cart" method="get">
    <input type="submit" value="Очистить корзину">
</form>
<%--<br/>
<br/>
<br/>
<a href = "/SpringSecurityAppHibernateCustomDB_war_exploded/deleteUser?username=${username}">Delete Account;{((</a>
<br/>
<a href = "/SpringSecurityAppHibernateCustomDB_war_exploded/changePassword">Change Password</a>
<br/>--%>
<c:forEach items = "${list}" var ="product">

            <tr>

                <td>${product.code}</td>
                <td><a href="${pageContext.request.contextPath}/categoryproducts?category=${product.category}">${product.category}</a></td>
                <td><a href="${pageContext.request.contextPath}/productinfo?code=${product.code}">${product.name}</a></td>
                <td><fmt:formatNumber value="${product.price}" type="currency"/></td>
                <td>
                    <form action="add-to-cart" method="get">
                        <input type="hidden" name="code" value="${product.code}"/>
                        <input max="${product.quantity}" min="1" name="quantity" step="1" type="number" value="1"/>
                        <input type="submit" value="Add to cart"/>
                    </form>
                </td>

            </tr>

        <br/>
</c:forEach>
<br/>
<a href="/SpringSecurityAppHibernateCustomDB_war_exploded/">Return to home page</a>
<br/>
<sec:authorize access='hasAuthority("ADMIN")'>
    <h4>You've got roles: ${roles}</h4>
    <a href="/SpringSecurityAppHibernateCustomDB_war_exploded/admin">ADMIN PAGE</a>
    <br/>
</sec:authorize>
<form:form action="logout" method = "POST">
    <input type="submit" value="logout(((">
</form:form>
</body>

</html>
