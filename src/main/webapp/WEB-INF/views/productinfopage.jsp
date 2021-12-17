<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %><html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- NetworkTechnologiesProject
 @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]--%>
<head>

    <title>ProductConfirmation</title>

</head>
<body>

<h1 style="text-align: center">${product.name}</h1>
<div>
    <h3>Информация о продукте:</h3>
    <input type="hidden" name="code" value="${product.code}"/>
    <ul>
        <li>Артикул: ${product.code}</li>
        <li>Категория: ${product.category}</li>
        <li>${product.description}</li>
        <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
        </ul>
</div>

<a class="navi-item"
   href="${pageContext.request.contextPath}/hello">
    BACK</a>


</body>
</html>
