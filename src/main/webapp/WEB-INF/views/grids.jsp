<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp" />
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp" />
    </jsp:attribute>
    <jsp:body>
    <div class="container">
        <div class="row">
            <c:forEach var="grid" items="${grids}">
                <div class="collection">
                    <a href="#!" class="collection-item">${grid.name}, ${grid.cell_h} / ${grid.cell_w}, ${grid.price} грн.</a>
                </div>
            </c:forEach>
            <a href="<c:url value='/categories/newGrid' />">Додати нову сітку</a>
        </div>
    </div>
    </jsp:body>
</t:genericpage>