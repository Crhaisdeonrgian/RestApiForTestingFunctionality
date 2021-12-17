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


<div class="page-title">Confirmation</div>



<div class="customer-info-container">
    <h3>Product Information:</h3>
<%--    TODO: Сохранять заказы? ч.2--%>
<%--    <form action="${pageContext.request.contextPath}/purchase" method="post">--%>
        <input type="hidden" name="code" value="${product.code}"/>
        <ul>
            <li>Name: ${product.name}</li>
            <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
            <li>Quantity:<input type="number" min="1" max="${product.quantity}" value="1" step="1" name="quantity" onfocus="this.blur();"/></li>
        </ul>
        <input type="submit" value="Purchase"/>
  <%--  </form>--%>
</div>

<a class="navi-item"
   href="${pageContext.request.contextPath}/hello">
    BACK</a>


</body>
</html>