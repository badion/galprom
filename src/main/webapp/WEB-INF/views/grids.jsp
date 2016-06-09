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
                    <h2>${subCategory.description}:</h2>
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
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </c:forEach>
        </div>
        <%--        <h4>${subCategory.name}:</h4>
                <h1>${subCategory.description}:</h1>
                <c:forEach var="grid" items="${subCategory.products}">
                    <ul class="collection">
                        <li class="collection-item avatar">
                            <i class="material-icons circle green">insert_chart</i>
                            <span class="title">${grid.name} </span>
                            <p>Висота/Ширина ячейки: ${grid.cell_w}
                                / ${grid.cell_w}<br>
                                Ціна: ${grid.price}
                                <a style="margin-top: 30px;" href="<c:url value='/categories/grid/edit/${grid.id}'/>"
                                   class="secondary-content"><i class="material-icons">mode_edit</i></a>
                            </p>

                            <a href="#modal${grid.id}" class="secondary-content modal-trigger"><i
                                    class="material-icons">delete</i></a>


                            <div id="modal${grid.id}" class="modal bottom-sheet">
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
                        </li>
                    </ul>
                </c:forEach>
                <a href="<c:url value='/categories/newGrid' />">Додати нову сітку</a>
            </c:forEach>
        </div>--%>
    </jsp:body>
</t:genericpage>