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
		<jsp:include page="../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <h4>Форма для додавання сітки</h4>
            <div class="row">
                <form:form method="POST" modelAttribute="grid" class="col s12">
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="subcategory" id="subcategory"/>
                    <!-- Назва -->
                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">info</i>
                            <form:input class="form-control validate" type="text" path="name" id="name"/>
                            <label for="name">Назва</label>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">swap_vert</i>
                            <form:input class="form-control"  type="text" path="subcategory.name" id="subcategory"/>
                            <label for="subcategory">subcategory</label>
                        </div>
                    </div>

                    <!-- Ширина довжина ячейки -->
                    <div class="row">
                       <div class="input-field col s6">
                            <i class="material-icons prefix">aspect_ratio</i>
                            <form:input class="form-control validate" type="text" path="cell_w" id="cell_w"/>
                            <label for="cell_w">Ширина ячейки</label>
                            <div class="has-error">
                                <form:errors path="cell_w" class="help-inline"/>
                            </div>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">swap_vert</i>
                            <form:input type="text" path="cell_h" id="cell_h" class="form-control validate"/>
                            <label for="cell_h">Висота ячейки</label>
                            <div class="has-error">
                                <form:errors path="cell_h" class="help-inline"/>
                            </div>
                        </div>
                    </div>

                    <!-- Довжина ширина рулону -->
                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">swap_horiz</i>
                            <form:input  type="text" path="roll_length" id="roll_length" class="form-control validate"/>
                            <label for="roll_length">Довжина рулону</label>
                            <div class="has-error">
                                <form:errors path="roll_length" class="help-inline"/>
                            </div>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">aspect_ratio</i>
                            <form:input type="text" path="roll_width" id="roll_width" class="form-control validate"/>
                            <label for="roll_width">Ширина рулону</label>
                            <div class="has-error">
                                <form:errors path="roll_width" class="help-inline"/>
                            </div>
                        </div>
                    </div>

                    <!-- Діаметр, ціна-->
                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">account_circle</i>
                            <form:input type="text" path="diametr" id="diametr"  class="form-control validate"/>
                            <label for="diametr">Діаметр</label>
                            <div class="has-error">
                                <form:errors path="diametr" class="help-inline"/>
                            </div>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">payment</i>
                            <form:input type="text" path="price" id="price" class="form-control validate"/>
                            <label for="price">Ціна</label>
                            <div class="has-error">
                                <form:errors path="price" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <p>Поля з * обов'язкові</p>
                    <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Модифікувати" class="btn btn-primary btn-sm"/> or <a
                                    href="<c:url value='/categories/grid' />">Відмінити</a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Додати" class="btn btn-primary btn-sm"/> or <a
                                    href="<c:url value='/categories/grid' />">Відмінити</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
         </div>
    </jsp:body>
</t:genericpage>