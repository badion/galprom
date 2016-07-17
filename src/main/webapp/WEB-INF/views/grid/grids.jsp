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
		<jsp:include page="../../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <h1>Види сіток</h1>
            <a href="<c:url value='/categories/newGridSubCategory' />">Додати новий вид сітки</a>
            <c:forEach var="subCategory" items="${gridPage.keySet()}">
                <div class="container">
                    <h2> ${subCategory.name}:</h2>
                    <h1>${subCategory.description}:</h1>
                    <form method="POST"
                          action="<c:url value='/categories/grid/img/upload/${subCategory.id}?${_csrf.parameterName}=${_csrf.token}' />"
                          name="imgUploadForm${subCategory.id}"
                          enctype="multipart/form-data">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <label for="files${subCategory.id}">
                                <span class="btn btn-success">Виберіть зображення</span>
                            </label>
                        </c:if>
                        <input style="visibility: hidden; position: absolute;" id="files${subCategory.id}"
                               class="form-control"
                               type="file" name="file" onchange="this.form.submit()">
                    </form>
                    <img style="width: 250px;height: 200px;" src="<c:url value='/categories/grid/img/${subCategory.id}' />" alt="">
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
                                    <button class="btn btn-info"
                                            onclick="document.getElementsByClassName('mailForm${grid.id}')[0].style.display='';">
                                        Купити
                                    </button>
                                </td>
                                <c:if test="${pageContext.request.userPrincipal.name == 'a'}">
                                    <td><a href="/categories/grid/${grid.id}/edit"
                                           class="btn btn-danger"><i class="material-icons">Модифікувати</i></a></td>
                                    <td><a class="btn btn-danger" type="submit"
                                           href="/categories/grid/${grid.id}/delete">Видалити</a></td>
                                </c:if>
                            </tr>
                            <tr class="mailForm${grid.id}" style="display: none" name="mailFormContainer">
                                <td colspan="9">
                                    <h4>Надіслати відгук</h4>
                                    <form:form method="POST" action="/categories/grid/${grid.id}/send_mail">
                                        <table>
                                            <tr>
                                                <td>Імя :<input type="text" name="name" title="Імя :"></td>
                                                <td>Телефон :<input type="text" name="tel" title="Телефон :"></td>
                                                <td>Мейл :<input type="email" name="email" title="Мейл :"></td>
                                            </tr>
                                            <tr>
                                                <td colspan="3"><label>Повідомлення :</label></td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">
                                                <textarea style="
                                                        width:100%;
                                                        height:100%;
                                                        box-sizing: border-box;"
                                                          name="comment" title="Повідомлення"></textarea></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="submit"
                                                           class="btn btn-info"
                                                           value="Відправити"/>
                                                </td>
                                                <td>
                                                    <input onclick="document.getElementsByClassName('mailForm${grid.id}')[0].style.display='none';"
                                                           class="btn btn-info"
                                                           value="Закрити"
                                                           title="Закрити"/>
                                                </td>
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
            <script>
                $(document).mouseup(function (e) {
                    var container = $("[name = 'mailFormContainer']");
                    if (!container.is(e.target) // if the target of the click isn't the container...
                            && container.has(e.target).length === 0) // ... nor a descendant of the container
                    {
                        container.hide();
                    }
                });
            </script>
        </div>
    </jsp:body>
</t:genericpage>