<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="alert alert-success lead">
                    ${success}
            </div>
    <span class="well floatRight">
        Перейти<a href="<c:url value='/categories/grid' />">Список сіток</a>
    </span>
        </div>
    </jsp:body>
</t:genericpage>