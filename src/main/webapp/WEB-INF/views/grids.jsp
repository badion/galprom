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
            <h1>Види сіток</h1>
            <c:forEach var="subCategory" items="${gridPage.keySet()}">
                <div class="container">
                    <h2> ${subCategory.name}:</h2>
                    <h1>${subCategory.description}:</h1>
                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th>Висота решітки</th>
                            <th>Щирина решітки</th>
                            <th>Діаметр</th>
                            <th>Довжина рулону</th>
                            <th>Ширина рулону</th>
                            <th>Ціна</th>
                        </tr>
                        </thead>
                        <c:forEach var="grid" items="${subCategory.products}">
                            <tbody>
                            <tr>
                                <td>${grid.cell_h}</td>
                                <td>${grid.cell_w}</td>
                                <td>${grid.diametr}</td>
                                <td>${grid.roll_length}</td>
                                <td>${grid.roll_width}</td>
                                <td>${grid.price}</td>
                                <td><a style="margin-top: 30px;"
                                       href="<c:url value='/categories/grid/edit/${grid.id}'/>"
                                       class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
                                <td><a href="#modal${grid.id}" class="secondary-content modal-trigger"><i
                                        class="material-icons">delete</i></a></td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <a href="<c:url value='/categories/newGrid' />">Додати нову позицію</a>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:genericpage>