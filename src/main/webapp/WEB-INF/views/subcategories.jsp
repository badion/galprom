<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
        <div class="row">
            <c:forEach var="sub" items="${subcategory}">
                <div class="col m6 l4">
                    <header>
                        <h4>${sub.name}</h4>
                    </header>
                    <p class="subtitle">${sub.products} </p>
                    <p>
                        <a href="categories/sub/"></a>
                    </p>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:genericpage>
