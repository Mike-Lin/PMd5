<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<head><title>First JSP</title></head>
<body>

<c:if test="${!empty list}" >

    <c:forEach items="${list}" var="p" >

        ${p.aqi}

    </c:forEach>

</c:if>

${name}


</body>

</html>
