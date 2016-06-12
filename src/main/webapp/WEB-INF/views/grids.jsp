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
        <style>
            .modal {
                position: absolute;
                z-index: 1;
            }
        </style>
        <div class="container">
            <h1>Види сіток</h1>
            <c:forEach var="subCategory" items="${gridPage.keySet()}">
                <div class="container">
                    <h2> ${subCategory.name}:</h2>
                    <h1>${subCategory.description}:</h1>
                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th>Ячейки</th>
                            <th>Діаметр</th>
                            <th>Довжина\Висота рулону</th>
                            <th>Ціна</th>
                        </tr>
                        </thead>
                        <c:forEach var="grid" items="${subCategory.products}">
                            <tbody>
                            <tr>
                                <td>${grid.cell_w}x${grid.cell_h}</td>
                                <td>${grid.diametr}</td>
                                <td>${grid.roll_length}</td>
                                <td>${grid.price}</td>
                                <td>
                                    <button class="btn-info"
                                            onclick="document.getElementsByClassName('mailForm${grid.id}')[0].style.display='';">
                                        Купити
                                    </button>
                                </td>
                                <c:if test="${pageContext.request.userPrincipal.name == 'a'}">
                                    <td><a href="/galprom/categories/grid/${grid.id}/edit"
                                           class="btn-primary"><i class="material-icons">Модифікувати</i></a></td>
                                    <td><a class="btn-danger" type="submit"
                                           href="/galprom/categories/grid/${grid.id}/delete">Видалити</a></td>
                                </c:if>
                            </tr>
                            <tr class="mailForm${grid.id}" style="display: none">
                                <td colspan="9">
                                    <h4>Надіслати відгук</h4>
                                    <form:form method="POST" action="/galprom/categories/grid/${grid.id}/send_mail">
                                        <table>
                                            <tr>
                                                <td><label>Імя : </label></td>
                                                <td><input type="text" name="name"></td>
                                                <td><label>Телефон : </label></td>
                                                <td><input type="text" name="tel"></td>
                                                <td><label>Мейл : </label></td>
                                                <td><input type="email" name="email"></td>
                                            </tr>
                                            <tr>
                                                <td colspan="6"><label>Повідомлення : </label></td>
                                            </tr>
                                            <td colspan="6"><textarea name="comment"></textarea></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2"><input type="submit" class="btn-info"
                                                                       value="Відправити"></td>
                                                <td colspan="2"><input
                                                        onclick="document.getElementsByClassName('mailForm${grid.id}')[0].style.display='none';"
                                                        class="btn-info"
                                                        value="Закрити"></td>
                                            </tr>
                                        </table>
                                    </form:form>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <a href="<c:url value='/categories/newGrid/${subCategory.id}' />">Додати нову позицію</a>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:genericpage>