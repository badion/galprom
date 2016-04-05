<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <c:forEach var="grid" items="${grids}">
                    <div class="collection">
                        <a href="#!" class="collection-item">${grid.name}, ${grid.cell_h}
                            / ${grid.cell_w}, ${grid.price}
                            грн.</a>
                        <!-- Modal Trigger -->
                        <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Modal</a>
                        <!-- Modal Structure -->
                        <div id="modal1" class="modal bottom-sheet">
                            <div class="modal-content">
                                <h4>Видалення сітки</h4>
                                <p>Ви дійсно хочете видалити елемент?</p>
                            </div>
                            <div class="modal-footer">
                                <c:url var="deleteGrid" value="/categories/grid/${grid.id}"/>
                                <form:form method="POST" action="${deleteGrid}">
                                    <input type="submit" value="Видалити" class="btn btn-primary btn-sm"/> or <a
                                        href="<c:url value='/categories/grid' />">Відмінити</a>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <a href="<c:url value='/categories/newGrid' />">Додати нову сітку</a>
            </div>
        </div>
    </jsp:body>
</t:genericpage>